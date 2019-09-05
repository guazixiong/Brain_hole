import Vue from 'vue'
import Router from 'vue-router'
//测试
import Test from '@/components/Test.vue'
//首页
import HeadWeb from '@/components/Head/HeadWeb.vue'
import Head from '@/components/Head/Head.vue'

//登录
import Login from '@/components/Head/Login.vue'

//World
import World_Fantasy from '@/components/Head/World/World_Fantasy.vue'
import World_Kongfu from '@/components/Head/World/World_Kongfu.vue'
import World_History from '@/components/Head/World/World_History.vue'
import World_Urban from '@/components/Head/World/World_Urban.vue'
import World_Science from '@/components/Head/World/World_Science.vue'

//用户
import UserWeb from '@/components/User/UserWeb.vue'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';

Vue.prototype.$axios = axios

//Vue.prototype.$http=axios

Vue.use(Router)
Vue.use(ElementUI);


export default new Router({
  routes: [
    {
      name: 'HeadWeb', path: '/', component: HeadWeb,
      children: [
        {name: 'test', path: '/Brain_hole/test', component: Test},
        //登录与注册
        {name: 'Login', path: '/Brain_hole/Login', component: Login},
        //首界面
        {name: 'Head', path: '/Brain_hole/Head', component: Head},
        /*
        * 世界观
        * */
        //玄幻
        {name: 'World_Fantasy', path: '/Brain_hole/World_Fantasy', component: World_Fantasy},
        //武侠仙侠
        {name: 'World_Kongfu', path: '/Brain_hole/World_Kongfu', component: World_Kongfu},
        //历史军事
        {name: 'World_History', path: '/Brain_hole/World_History', component: World_History},
        //都市娱乐
        {name: 'World_Urban', path: '/Brain_hole/World_Urban', component: World_Urban},
        //科幻游戏
        {name: 'World_Science', path: '/Brain_hole/World_Science', component: World_Science},
        /*
        *剧情
        * */
      ],
    },
    {
      name: 'UserWeb', path: '/Brain_hole/UserWeb', component: UserWeb,

    }

  ],
  //消除网址中#
  mode: 'history',
})
