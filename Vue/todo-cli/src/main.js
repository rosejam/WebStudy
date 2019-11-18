import Vue from 'vue'
import App from './App.vue'
import store from './js/store.js' //

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  store: store //키 밸류 이름이 같으므로 그냥 store라고 생략해서 적어도 됨
}).$mount('#app')
