import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
//위와 아래가 같은 말
/* new Vue({
  el: '#app',
  render: h => h(App) //App화면을 모두 만들어서 #app에 붙여준다.
}) */

/*
  //렌더 화살표 함수는 아래와 같다.
  render: function(h){
    return h(App);
  }
  //내부에서 아래의 꼴로 바뀐다.
  render: function(createElement){
    retunr createElement(App);
  }
*/
