import { createRouter, createWebHistory } from "vue-router";

import login from '../views/login_layout.vue'
import company_layout from '../views/company_layout.vue';
import company_aircraft from "@/components/company_aircraft.vue";
import company_info from "@/components/company_info.vue";
import company_submitAirline from "@/components/company_submitRoutes.vue";
import airport_layout from "@/views/airport_layout.vue";

//定义路由关系
const routes =[
    {path: '/', component: login},
    {path: '/company', component: company_layout,
        redirect: '/company/submitAirline',
        children:[
        {path:'/company/info',component:company_info},
        {path:'/company/aircraft',component:company_aircraft},
        {path:'/company/submitAirline',component:company_submitAirline},
    ]},
    {path: '/airport', component: airport_layout},
]

//创建路由器
const router=createRouter({
    history:createWebHistory(),
    routes:routes
})

export default router;