<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    {{this.$store.state.name}}
    <hr>
    <h2>Todo List App</h2>
    <InputTodo/>
    <ListTodo/>
  </div>
  
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import InputTodo from './components/InputTodo.vue'
import ListTodo from './components/ListTodo.vue'

export default {
  name: 'app',
  components: {
    //HelloWorld,
    InputTodo,
    ListTodo
  }
}
</script>

<style>
* {  box-sizing: border-box;  }
.header {
    background-color: purple; padding: 30px 30px;
    color: yellow; text-align: center;
}
.header:after {
    content: ""; display: table; clear: both;
}
</style>
