import Vue from 'vue'
import App from './App.vue'
import store from './store.js'

Vue.config.productionTip = false

//add store
new Vue({
  render: h => h(App),
  store
}).$mount('#app')
