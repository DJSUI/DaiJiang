import Mock from 'mockjs';

Mock.mock('/student', 'get', {
  'data|20': [
    {
      'id|+1': 1,
      'sid': function () {
        // Function to pad the ID with leading zeros to make it three digits
        return ('00' + this.id).slice(-3);
      },
      'name': '@name',
      'sex|1': ['Male', 'Female'],
      'age|15-75': 1,
    },
  ],
});