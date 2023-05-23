import axios from 'axios'
import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

axios.defaults.baseURL = 'http://localhost:8080/automoviles'

new Vue({
  render: h => h(App),
}).$mount('#app')
