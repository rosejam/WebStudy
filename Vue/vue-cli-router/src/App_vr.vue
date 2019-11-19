<template>
<div>
  <div class="header">
    <h1 class="headerText">test router</h1>
    <nav>
      <ul>
      <!-- router-link -->
        <li><router-link to="/contacts">Contacts</router-link></li>
        <li><router-link to="/about">About</router-link></li>
        <li><router-link to="/home">Home</router-link></li>
      </ul>
    </nav>
  </div>

  <div class="container">
    <!-- router-view -->
    <router-view></router-view>
  </div>
</div>

</template>
<script>
//import
import VueRouter from 'vue-router'; //cdn이 아닌 다운받은 라이브러리를 사용하기 위해 import
import Vue from 'vue';

import Contacts from './components/Contacts.vue'
import About from './components/About.vue'
import Home from './components/Home.vue'

//VueRouter의 global functionality 꼭 써주기
Vue.use(VueRouter)

//VueRouter 생성(path, component)
var router = new VueRouter({
  mode: 'history', //이거 막으면 #이 router.html뒤에 붙음
  routes: [
    {
      path: '/contacts', //url
      component: Contacts
    },
    {
      path: '/about',
      component: About
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/',
      component: Home
    }
  ]
});

export default { //이게 뷰객체와 비슷함
  name : 'app',
  router //
}

</script>
<style>
.header { background-color:aqua; padding: 10px 0px 0px 0px; }
.headerText { padding: 0px 20px 0px 20px; } 
ul { list-style-type: none; margin: 0; padding: 0;
    overflow: hidden; background-color: purple;  }
li { float: left; }
li a { display: block; color: yellow; text-align: center;
    padding: 14px 16px; text-decoration: none;  }
li a:hover { background-color: aqua; color:black; }
</style>