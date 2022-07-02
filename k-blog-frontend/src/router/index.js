import Vue from 'vue'
import Router from 'vue-router'
import {LoadingBar } from 'iview'
import Index from '@/pages/Index'
import HomePage from '@/pages/HomePage'
import ArticleDetail from '@/pages/ArticleDetail'
import ArticleList from '@/pages/ArticleList'
import LifeList from '@/pages/LifeList'
import TimeLinePage from '@/pages/TimeLinePage'
import page404 from '@/components/404/page404'
import SearchPage from '@/pages/SearchPage'
import LoginPage from '@/pages/LoginPage'
import RegisterPage from '@/pages/RegisterPage'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  // base:"/aqian_blog/",
  scrollBehavior: () => ({y: 0}),
  routes: [
    // eslint-disable-next-line no-undef
    {
      path: '/404',
      component: page404,
      name: 'page404'
    },
    {
      path: '/',
      name: 'Index',
      component: Index,
      children: [
        // 首页
        {
          path: '/',
          name: 'index',
          component: HomePage
        },
        // 登录页
        {
          path: '/login',
          name: 'login',
          component: LoginPage
        },
        // 注册
        {
          path: '/register',
          name: 'register',
          component: RegisterPage
        },
        // 全部文章列表
        {
          path: '/articleList',
          name: 'articleList',
          component: ArticleList
        },
        // 文章详情页
        {
          path: '/article/:articleId',
          name: 'article',
          component: ArticleDetail
        },
        // 文章查询页
        {
          path: '/articles/search',
          name: 'search',
          component: SearchPage
        },
        // 程序人生
        {
          path: '/life',
          name: 'life',
          component: LifeList
        },
        // 时间线
        {
          path: '/timeline',
          name: 'timeline',
          component: TimeLinePage
        },
        {
          path: '*', // 页面不存在的情况下会跳到404页面
          redirect: '/404',
          name: 'notFound',
          hidden: true
        }
      ]
    }
  ]
})

// 配置加载进度条
LoadingBar.config({
  color: '#5cb85c',
  failedColor: '#f0ad4e',
  height: 2
})

router.beforeEach((to, from, next) => {
  LoadingBar.start()
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

router.afterEach(() => {
  LoadingBar.finish()
  window.scrollTo(0, 0)
})

export default router
