import Mock from 'mockjs';

// 自动生成的api数据 
Mock.mock('/api/test', 'get', {
  'data|20': [
    {
      'id|+1': 1,
      'studentId': function () {
        // Function to pad the ID with leading zeros to make it three digits
        return ('00' + this.id).slice(-3);
      },
      'name': '@name',
      'gender|1': ['Male', 'Female'],
      'age|15-75': 1,
    },
  ],
});