<template>
  <v-app>
    <v-container>
      <!-- hint it will appear find how many reauslts or find nothing  -->
      <v-snackbar v-model="snackbar" :timeout="3000" color="success" top>
        Find {{ filterData.length }} results
      </v-snackbar>
      <v-snackbar v-model="noResultsSnackbar" :timeout="3000" color="error" top>
        Data not found
      </v-snackbar>

      <!-- Todo function area  -->
      <v-row align="center" justify="center">
        <v-col cols="12" sm="10">
          <v-card class="elevation-6 mt-10">
            <h2>Todo List</h2>
            <br>
            <ul>
              <li>初期表示功能，结合axios</li>
              <!-- function searching  -->
              <li>搜索功能</li>
              <input v-model="keyword" @keyup.enter="search" style="outline: auto;margin: auto 20px;">
              <button @click="search" style="outline: auto;">Search</button>
              <li>增添功能</li>
              <li>删除功能</li>
              <li>修改功能</li>
            </ul>
          </v-card>
        </v-col>
        <!-- list of  StudentInfo -->
        <v-col cols="12" sm="10">
          <v-card class="elevation-6 mt-10">
            <v-card-title style="background-color: rgb(222, 225, 230);">
              StudentInfo
            </v-card-title>
            <v-card-text style="background-color: rgb(222, 225, 230);">
              <v-data-table :headers="headers" :items="filterData.length > 0 ? filterData : sData"
                :items-per-page="3"></v-data-table>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>

    </v-container>
  </v-app>
</template>




<script>
import axios from "axios";
export default {
  data() {
    return {
      headers: [
        { text: 'id', value: 'id' },
        { text: 'name', value: 'name' },
        { text: 'Sex', value: 'sex' },
        { text: 'Age', value: 'age' },

      ],

      sData: [],
      filterData: [],
      keyword: '',
      snackbar: false,
      noResultsSnackbar: false
    };
  },
  created() {
    axios.get('http://localhost:3000/stdata')
      .then(response => {
        this.sData = response.data
        console.log(this.sData);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  },
  methods: {
    // boundle by button , when click button , it will execute search fucntion  
    search() {
      this.filterData = this.filterByName(this.keyword.toLowerCase())
      console.log(this.keyword);
      console.log(this.filterData);
      if (this.filterData.length > 0) {
        this.snackbar = true;
      } else {
        this.noResultsSnackbar = true;
      }

      // Automatically hide the snackbar after 3 seconds
      setTimeout(() => {
        this.snackbar = false;
        this.noResultsSnackbar = false;
      }, 3000);

    },
    filterByName(key) {
      return this.sData.filter(item =>
        item.name.toLowerCase().includes(key)
      );
    },

  }

}

</script>

