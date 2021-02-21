import Vue from 'vue'
import VueRouter from 'vue-router'

import App from '../App'
import Main from '../views/Main'
import Login from "../views/Login"
import Add from '../study/Add'
import NotFound from "../views/NotFound";
import FollowNews from "../views/FollowNews"
Vue.use(VueRouter)

const routes = [
  {path:'/', component:Login},
  {path: '/main', component: Main,
    // show:false,  让当前route隐藏
    // children:[
    //   {// path:'/pageone',name:'图书查询',component:PageOne},]
  },
  {path:'/follownews', component:FollowNews},
  {path:'/test', component:Add},
  {path:'*',redirect:"/404"},
  {path:'/404',component:NotFound}
]

const router = new VueRouter({
  mode: 'history',  //去掉井号 #
  base: process.env.BASE_URL,
  routes
})

export default router
