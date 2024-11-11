 import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: ()=>import('../views/Home.vue')
  },
  {
    path: '/login',
    name: 'Login',
    component: ()=>import('../views/LoginRegister.vue')
  },
  
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
