import Vue from 'vue'
import App from './App.vue'
import store from './js/store.js' //여기에 스토어 가져오는 것 필수!!

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  store: store //키 밸류 이름이 같으므로 그냥 store라고 생략해서 적어도 됨
}).$mount('#app')
