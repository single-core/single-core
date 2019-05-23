<template>
  <div>
    <table>
      <thead>
        <th>ID</th>
        <th>姓名</th>
        <th>学号</th>
        <th>入学时间</th>
      </thead>
      <tbody>
        <tr>
          <td>{{responseInfo.id}}</td>
          <td>{{responseInfo.name}}</td>
          <td>{{responseInfo.schoolId}}</td>
          <td>{{responseInfo.number}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import axios from 'axios'
  export default {
    name: 'HelloWorld',
    data() {
      return {
        responseInfo: ''
      }
    },
    created: function () {
      this.getData()
    },
    methods: {
      getData() {
        axios.get('http://192.168.10.73:8090/template/student/1')
          .then((response) => {
            this.responseInfo = response.data.data;
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
