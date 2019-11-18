<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <First></First>
    <Second></Second>
    <Third></Third>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import First from './components/First.vue' //script부분이 비어있는 나머지 부분만 import된다.
import Second from './components/Second.vue'
import Third from './components/Third.vue'

export default {
  name: 'app',
  components: {
    //HelloWorld,
    First,
    Second,
    Third
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
</style>
