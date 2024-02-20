<template>
  <v-app>
    <div>
      <v-container>

        <v-dialog
          v-model="showDialog"
          max-width="500px"
        >
          <v-card>
            <v-card-title>确认删除</v-card-title>
            <v-card-text>确定要删除该学生信息吗？</v-card-text>
            <v-card-actions>
              <v-btn
                color="red darken-1"
                text
                @click="deleteStudent"
              >确认</v-btn>
              <v-btn
                text
                @click="showDialog = false"
              >取消</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>

        <v-data-table
          :headers="headers"
          :items="students"
          item-key="id"
          :items-per-page="-1"
          hide-default-footer
        >
          <template v-slot:[`item.No`]="{ index }">
            {{ index + 1 }}
          </template>
          <template v-slot:[`item.studentId`]="{ item }">
            {{ item.studentId }}
          </template>
          <template v-slot:[`item.name`]="{ item }">
            {{ item.name }}
          </template>
          <template v-slot:[`item.gender`]="{ item }">
            {{ item.gender }}
          </template>
          <template v-slot:[`item.age`]="{ item }">
            {{ item.age }}
          </template>
          <template v-slot:item="{ item, index }">
            <!-- 获取到的数据显示深色和浅色 -->
            <tr :style="{ 'background-color': index % 2 === 0 ? '#f0f0f0' : 'white' }">
              <td>{{ index + 1 }}</td>
              <td>{{ item.studentId }}</td>
              <td>{{ item.name }}</td>
              <td>{{ item.gender }}</td>
              <td>{{ item.age }}</td>
              <td>
                <v-icon @click="editStudent(item)">mdi-pencil</v-icon>
                <!-- <v-icon @click="deleteStudent(item)">mdi-delete</v-icon> -->
                <v-icon @click="confirmDelete(item)">mdi-delete</v-icon>

              </td>
            </tr>
          </template>
        </v-data-table>
      </v-container>
    </div>
  </v-app>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      // 学生表header
      headers: [
        { text: 'No', value: 'No' },
        // 以下需要mysql数据库提供
        { text: '学号', value: 'studentId' },
        { text: '姓名', value: 'name' },
        { text: '性别', value: 'gender' },
        { text: '年龄', value: 'age' },
        //* *******************
        { text: '操作', value: 'actions', sortable: false }
      ],
      students: [],
      showDialog: false,
      studentToDelete: null

    }
  },
  mounted() {
    // 挂载时候触发fetchStudents 函数
    this.fetchStudents()
    console.log('!!!!' + this.students)
  },
  methods: {
    fetchStudents() {
      axios.get('http://localhost:8085/api/Students')
        .then(response => {
          console.log('!!!! zhao dao le ' + response.data)
          // 真实API students 形式是一群对象的形式，使用空数组接收形式： this.students = response.data;
          // MOCKAPI students 形式是父对象包含子对象，使用空数组接收形式： this.students = response.data.data;
          this.students = response.data
          //  TEST 数据形式
          console.log('!!! Students data forms: ' + this.students[0].name)
        })
        .catch(error => {
          console.error('!!!!mei zhao dao Error fetching students:', error)
        })
    },
    editStudent(student) {
      // TODO：编辑学生信息的逻辑
    },
    confirmDelete(student) {
      this.studentToDelete = student
      this.showDialog = true
    },
    deleteStudent() {
      // 删除学生信息的逻辑
      if (this.studentToDelete) {
        // 获取到的学生ID信息
        console.log("catch studnet ID !!" + this.studentToDelete.studentId);

        axios.delete(`http://localhost:8085/api/Students/${this.studentToDelete.studentId}`)
          .then(response => {
            console.log('Student deleted successfully')
            this.fetchStudents() // 重新获取数据以更新页面
          })
          .catch(error => {
            console.error('Error deleting student:', error)

          })
      }
      this.showDialog = false
    }
  }

}

</script>
