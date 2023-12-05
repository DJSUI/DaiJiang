<template>
  <v-app>
    <v-container>
      <v-row align="center" justify="center">
        <v-col cols="12" sm="10">
          <v-card class="elevation-6 mt-10">
            <h2>Todo List</h2>
            <br>
            <ul>
              <li>初期表示功能，结合axios</li>
              <li>搜索功能</li>
              <li>增添功能</li>
              <li>删除功能</li>
              <li>修改功能</li>

            </ul>

          </v-card>
        </v-col>
        <v-col cols="12" sm="10">
          <v-card class="elevation-6 mt-10">
            <v-card-title style="background-color: rgb(222, 225, 230);">
              【NEOBANK】顧客情報
            </v-card-title>
            <v-card-text style="background-color: rgb(222, 225, 230);">
              <v-data-table :headers="headers" :items="items" :search="search" :items-per-page="3"></v-data-table>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>

    </v-container>
  </v-app>
</template>




<script>
export default {
  data() {
    return {
      headers: [
        { text: 'Name', value: 'name' },
        { text: 'Age', value: 'age' },
        { text: 'Country', value: 'country' },
      ],
      items: [
        { name: 'sdj', age: 30, country: 'USA' },
        { name: 'kyt', age: 25, country: 'Canada' },
        { name: 'kyt1', age: 26, country: 'Canada' },
        { name: 'kyt2', age: 27, country: 'Canada' },
        // 添加更多数据项
      ],
      search: '', // 用于搜索
    };
  },
};
</script>

