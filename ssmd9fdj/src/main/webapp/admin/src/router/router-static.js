import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import chat from '@/views/modules/chat/list'
    import gangweigongzuo from '@/views/modules/gangweigongzuo/list'
    import gangweishenqing from '@/views/modules/gangweishenqing/list'
    import xueshengkaoqin from '@/views/modules/xueshengkaoqin/list'
    import laoshi from '@/views/modules/laoshi/list'
    import shenqingqingkuang from '@/views/modules/shenqingqingkuang/list'
    import config from '@/views/modules/config/list'
    import laoshikaoqin from '@/views/modules/laoshikaoqin/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/news',
        name: '公告资讯',
        component: news
      }
          ,{
	path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
          ,{
	path: '/chat',
        name: '联系我们',
        component: chat
      }
          ,{
	path: '/gangweigongzuo',
        name: '岗位工作',
        component: gangweigongzuo
      }
          ,{
	path: '/gangweishenqing',
        name: '岗位申请',
        component: gangweishenqing
      }
          ,{
	path: '/xueshengkaoqin',
        name: '学生考勤',
        component: xueshengkaoqin
      }
          ,{
	path: '/laoshi',
        name: '老师',
        component: laoshi
      }
          ,{
	path: '/shenqingqingkuang',
        name: '申请情况',
        component: shenqingqingkuang
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
          ,{
	path: '/laoshikaoqin',
        name: '老师考勤',
        component: laoshikaoqin
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
