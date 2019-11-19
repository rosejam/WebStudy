<template>
  <!-- vueboot_my_todolist2 서버와 같이 돌린다. -->
  <div id="app">
    <h3>{{this.$store.state.message}}</h3><!-- 삽입 메시지 그냥 여기다 넣어봄 -->
    <TodoHeader></TodoHeader>
    <router-view></router-view>
  </div>
</template>

<script>

import Vue from 'vue';
//import vue-router
import VueRouter from 'vue-router'

//import other vue files(TodoHeader, TodoInput, TodoList)
import TodoHeader from './components/TodoHeader.vue'
import TodoList from './components/TodoList.vue'
import TodoInput from './components/TodoInput.vue'
import TodoDetail from './components/TodoDetail.vue'

//VueRouter global functionalty
Vue.use(VueRouter)

//create VueRouter : router로 들어오는 모든 요청과 컴포넌트 맵핑 정보 표시
const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/', 
      component: TodoList  
    },
    {
      path: '/list', 
      component: TodoList
    },
    {
      path: '/input', 
      component: TodoInput  
    },
    {
      path: '/detail/:id', 
      component: TodoDetail
    }
  ]
})

//add compo, router
export default {
  name: 'app',
  router,
  components:{
    TodoHeader //초기화면에는 얘만 들어있음(router 링크가 여기 포함되어 있다.)
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
body {
    text-align: center;
    background-color: #F6F6F8;
  }
  input {
    border-style: groove;
    width: 200px;
  }
  button {
    border-style: groove;
  }
  .shadow {
    box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
  }

</style>
