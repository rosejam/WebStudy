<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <TestWorld></TestWorld>
    <HelloWorld msg="Welcome to Your Vue.js App...my first vue-cli"/> <!-- 지역 컴포넌트 이므로 사용 가능. 부모인 이쪽에서 msg를 전달한다! -->
    <SayWorld code="123"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import SayWorld from './components/SayWorld.vue'
import TestWorld from './components/TestWorld.vue'

export default { //vue를 import해서 다시 export하는 App.vue
  name: 'app', //App.vue의 이름은 app
  components: { //지역 컴포넌트 등록!!
    HelloWorld,
    SayWorld,
    TestWorld
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
