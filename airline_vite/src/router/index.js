import { createRouter, createWebHistory } from "vue-router";

import login from '../views/login_layout.vue'
import company_layout from '../views/company_layout.vue';
import company_aircraft from "@/components/company_aircraft.vue";
import company_info from "@/components/company_info.vue";
import company_submitAirline from "@/components/company_submitRoutes.vue";
import airport_layout from "@/views/airport_layout.vue";
import airport_flight from "@/components/airport_flight.vue";
import airport_customer from "@/components/airport_customer.vue";
import airport_aircraft from "@/components/airport_aircraft.vue";
import airport_info from "@/components/airport_info.vue";
import Customer_layout from "@/views/customer_layout.vue";
import Customer_bill from "@/components/customer_bill.vue";

//定义路由关系
const routes =[
    {path: '/', component: login},
    {path: '/company', component: company_layout,
        redirect: '/company/info',
        children:[
        {path:'/company/info',component:company_info},
        {path:'/company/aircraft',component:company_aircraft},
        {path:'/company/submitAirline',component:company_submitAirline},
    ]},
    {path: '/airport', component: airport_layout,
        redirect: '/airport/flight',
        children:[
        {path:'/airport/info',component:airport_info},
        {path:'/airport/flight',component:airport_flight},
        {path:'/airport/customer',component:airport_customer},
        {path:'/airport/aircraft',component:airport_aircraft},
    ]}, 
     {path: '/customer', component: Customer_layout,
        redirect: '/customer/bill',
        children:[
        {path:'/customer/bill',component:Customer_bill},
        {path:'/customer/ticket',component:airport_flight},
        {path:'/customer/info',component:airport_customer},
        
    ]}
]

//创建路由器
const router=createRouter({
    history:createWebHistory(),
    routes:routes
})

export default router;