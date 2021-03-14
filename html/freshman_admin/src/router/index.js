import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/Index'),
    redirect: '/student/login',
    children: [
      {
        path: '/student/login',
        component: () => import('../views/index/StudentLogin')
      },
      {
        path: '/student/register',
        component: () => import('../views/index/StudentRegister')
      },
      {
        path: '/admin/login',
        component: () => import('../views/index/AdminLogin')
      },
      {
        path: '/admin/register',
        component: () => import('../views/index/AdminRegister')
      }
    ]
  },
  {
    path: '/student/main',
    component:()=>import('../views/StudentMain'),
    redirect: '/student/main/homePage',
    children: [
      {
        path: '/student/main/homePage',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/studentMain/HomePage')
      },
      {
        path: '/student/main/dorm',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/studentMain/Dorm')
      },
      {
        path: '/student/main/payment',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/studentMain/Payment')
      },{
      path: '/student/main/studentInfo',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/studentMain/StudentInfo')
      }
    ]
  },
  {
    path: '/admin/main',
    component:()=>import('../views/AdminMain'),
    children: [
      {
        path: '/admin/main/studentCheckIn',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/adminMain/StudentCheckIn')
      },
      {
        path: '/admin/main/studentDorm',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/adminMain/StudentDorm')
      },
      {
        path: '/admin/main/studentPayment',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/adminMain/StudentPayment')
      },
      {
        path: '/admin/main/studentAccount',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/adminMain/StudentAccount')
      },
      {
        path: '/admin/main/admin',
        meta: {
          requireAuth: true,  // 该路由项需要权限校验
        },
        component:()=>import('../views/adminMain/Admin')
      }
    ]
  },
  {
    path: '*',
    component:()=>import('../components/Error404')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
    if (localStorage.token) {  // 获取当前的token是否存在
      console.log("token存在");
      next();
    } else {
      console.log("token不存在");
      next({
        path: '/student/login', // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    }
  }
  else { // 如果不需要权限校验，直接进入路由界面
    next();
  }
});


export default router
