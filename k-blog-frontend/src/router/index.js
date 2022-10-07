import Vue from 'vue'
import Router from 'vue-router'
import { LoadingBar } from 'iview'
import Index from '@/pages/Index'
import HomePage from '@/pages/HomePage'
import ArticleDetail from '@/pages/ArticleDetail'
import ArticleList from '@/components/Article/ArticleList'
import FilteredArticleList from '@/pages/FilteredArticleList'
import CategoryList from '@/pages/CategoryList'
import TimeLinePage from '@/pages/TimeLinePage'
import page404 from '@/pages/404Page'
import LoginPage from '@/pages/LoginPage'
import RegisterPage from '@/pages/RegisterPage'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/404',
      component: page404,
      name: '404'
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
        // 登录
        {
          path: '/login',
          name: 'login',
          redirect: '/404',
          component: LoginPage
        },
        // 注册
        {
          path: '/register',
          name: 'register',
          redirect: '/404',
          component: RegisterPage
        },
        // 全部文章列表
        {
          path: '/articleList',
          name: 'articleList',
          component: ArticleList
        },
        // 分类列表
        {
          path: '/categoryList',
          name: 'categoryList',
          redirect: '/404',
          component: CategoryList
        },
        // 分类文章
        {
          path: '/category/:categoryId',
          name: 'categoryArticleList',
          component: FilteredArticleList
        },
        // 文章详情
        {
          path: '/article/:articleId',
          name: 'article',
          component: ArticleDetail
        },
        // 文章查询
        {
          path: '/articles/search',
          name: 'search',
          redirect: '/404',
          component: FilteredArticleList
        },
        // 时间线
        {
          path: '/timeline',
          name: 'timeline',
          redirect: '/404',
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
