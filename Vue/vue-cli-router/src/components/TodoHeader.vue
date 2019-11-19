<template>
  <header>
    <img src="../assets/logo.png">
    <h1>Todo List - Vuex with VueRouter</h1>
    <div>
      <router-link to="/input">할일 추가</router-link>&nbsp;&nbsp; <!-- 띄어쓰기 -->
      <router-link to="/list">할일 목록</router-link>
    </div>
  </header>
</template>

<script>
export default {};
</script>

<style scoped>
h1 {
  color: #2f3b52;
  font-weight: 900;
  margin: 2.5rem 0 1.5rem;
}
</style>