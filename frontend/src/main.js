import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vueMoment from 'vue-moment' 

import '@/assets/css/bootstrap.min.css'
import '@/assets/font-awesome/css/font-awesome.css'
import '@/assets/css/plugins/dataTables/datatables.min.css'
import '@/assets/css/animate.css'
import '@/assets/css/style.css'




Vue.config.productionTip = false
new Vue({
  router,
  store,
  vueMoment,
  render: h => h(App)
}).$mount('#app')
