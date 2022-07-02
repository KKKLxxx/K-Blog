import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui'
// import 'element-ui/lib/theme-chalk/index.css'

import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

// import '@/permission' // permission control

import 'iview/dist/styles/iview.css'
// iView UI 组件引入
import {
  ListItemMeta,
  ListItem,
  List,
  Row,
  Col,
  Button,
  Input,
  Tag,
  Icon,
  Card,
  Affix,
  Form,
  FormItem,
  DatePicker,
  Modal,
  Message,
  Page,
  Notice,
  Poptip
} from 'iview'


Vue.component('ListItem', ListItem)
Vue.component('ListItemMeta', ListItemMeta)
Vue.component('List', List)
Vue.component('iv-row', Row)
Vue.component('iv-col', Col)
Vue.component('iv-card', Card)
Vue.component('iv-button', Button)
Vue.component('iv-page', Page)
Vue.component('iv-input', Input)
Vue.component('iv-tag', Tag)
Vue.component('iv-icon', Icon)
Vue.component('iv-affix', Affix)
Vue.component('iv-date-picker', DatePicker)
Vue.component('iv-form', Form)
Vue.component('iv-formItem', FormItem)
Vue.component('iv-modal', Modal)
Vue.component('iv-poptip', Poptip)

// 修改弹框
Vue.prototype.$Modal = Modal
Vue.prototype.$Message = Message
Vue.prototype.$Notice = Notice
Vue.prototype.$Notice.config({
  top: 70,
  duration: 3
})
/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online ! ! !
 */
if (process.env.NODE_ENV === 'production') {
  const { mockXHR } = require('../mock')
  mockXHR()
}

Vue.use(ElementUI)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
