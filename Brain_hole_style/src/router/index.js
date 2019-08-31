import Vue from 'vue'
import Router from 'vue-router'
import HeadWeb from '@/components/Head/HeadWeb.vue'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(Router)
Vue.use(ElementUI);

export default new Router({
  routes: [
    {
      path: '/', name: '/Brain_hole/headweb', component: HeadWeb,
    }
  ]
})
