import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
import BoardList from '../components/Board/BoardList'
import BoardWrite from '../components/Board/BoardWrite'
import BoardDetail from '../components/Board/BoardDetail'
import BoardModify from '../components/Board/BoardModify'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'BoardList',
    component: BoardList
  },
  {
    path: '/BoardWrite',
    name: 'BoardWrite',
    component: BoardWrite
  },
  {
    path: '/BoardDetail/:bnum',
    name: 'BoardDetail',
    component: BoardDetail
  },
  {
    path: '/BoardModify/:bnum',
    name: 'BoardModify',
    component: BoardModify
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
