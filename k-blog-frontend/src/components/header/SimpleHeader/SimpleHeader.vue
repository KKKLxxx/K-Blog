<template>
  <div>
    <transition name="slide-fade">
      <div id="header" v-show="show">
        <router-link id="logo" to="/">
          <img src="@/assets/logo.png">
          <span class="title">K-Blog</span>
        </router-link>

        <ul id="nav">
          <li>
            <router-link to="/articleList" class="nav-link"><span class="iconfont icon-icon-test">技术交流</span>
            </router-link>
          </li>
          <li>
            <router-link to="/codes" class="nav-link"><span class="iconfont icon-fenxiang">源码分享</span>
            </router-link>
          </li>
          <li>
            <router-link to="/life" class="nav-link"><span class="iconfont icon-erjiji">程序人生</span>
            </router-link>
          </li>
          <li>
            <router-link to="/timeline" class="nav-link"><span class="iconfont icon-shijian">时间轴</span>
            </router-link>
          </li>
          <li>
            <router-link to="/article/1" class="nav-link"><span class="iconfont icon-xiaobaicai">关于我</span>
            </router-link>
          </li>

          <li>
            <input
              type="text" id="search-query-nav" class="search-query" name="keywords"
              v-model="keywords" @keyup.enter="submit(keywords)"
              placeholder="在这里可劲搜吧....">
          </li>
          <li v-show="manager.id == null">
            <router-link to="/login" class="nav-link" style="color: #E6E61A">登录</router-link>
          </li>
          <!--          <li v-show="this.manager.id != null">
                      <router-link :to="{name:'publish',params:{managerId:manager.id}}" class="nav-link" style="margin-right: 0px;color: dodgerblue">
                        <span class="iconfont icon-wen">发表文章</span>
                      </router-link>
                    </li>-->
          <li v-show="manager.id != null">
            <a class="nav-link iconfont" style="color: dodgerblue" @click="noLogin">{{manager.name}}(点击注销)</a>
          </li>
        </ul>
      </div>
    </transition>
  </div>

</template>

<script>

export default {
  data () {
    return {
      show: true,
      keywords: '',
      manager: {}
    }
  },
  created () {
    this.keywords = this.$route.query.keywords
  },
  mounted: function () {
    let manager = JSON.parse(localStorage.getItem('currentManager'))
    if (manager !== null) {
      this.manager = manager
    }
    // 给页面绑定滑轮滚动事件
    if (document.addEventListener) { // firefox
      document.addEventListener('DOMMouseScroll', this.watchScroll, false)
    }
    // 滚动滑轮触发scrollFunc方法  ie 谷歌
    window.onmousewheel = document.onmousewheel = this.watchScroll
  },
  methods: {
    noLogin () {
      this.$http({
        url: this.$http.adornUrl('/login/noLogin'),
        method: 'get',
        data: this.$https.adornDatas()
      }).then(({data}) => {
        if (data.result.status === -1) {
          this.$Message.error(data.result.error)
        } else {
          localStorage.removeItem('currentManager')
          this.$Message.success('已退出登录')
          // 跳到首页
          window.location.reload()
          this.$router.push({path: '/'})
        }
      })
    },
    submit (keywords) {
      this.$router.push({path: '/articles/search', query: {keywords}})
    },
    watchScroll (e) {
      e = e || window.event
      if (e.wheelDelta) {
        if (e.wheelDelta > 0 && this.show === false) { // 当滑轮向上滚动
          this.show = true
        }
        if (e.wheelDelta < 0 && this.show === true) { // 当滑轮向下滚动
          this.show = false
        }
      } else if (e.detail) {
        if (e.detail < 0 && this.show === false) { // 当滑轮向上滚动
          this.show = true
        }
        if (e.detail > 0 && this.show === true) { // 当滑轮向下滚动
          this.show = false
        }
      }
    }
  }
}
</script>

<style lang="stylus">
@import "../../../common/stylus/theme.styl";

/* common */
a
  color: $color-secondary-info

/* header */
$header-height = 40px

body.docs
  font-family: $body-font
  font-size: $body-font-size
  background-color: #f5f5f5
  padding-top: 60px

  #header
    background-color: #fff
    padding: $heading-padding-vertical 60px
    z-index: 11
    position: fixed
    width: 100%
    top: 0

    .title
      color: $color-gradually-gray-31

  #nav
    position: fixed

#nav
  list-style-type: none
  margin: 0
  padding: 0
  position: absolute
  right: 100px
  top: $heading-padding-vertical
  height: $header-height
  line-height: $header-height

  li
    display: inline-block
    position: relative
    margin: 0 .6em

.nav-link
  padding-bottom: 3px
  font-size: 17px
  margin-left: 20px

  &:hover, &.current
    color $color-main-primary

.search-query
  height: 30px
  line-height: 30px
  box-sizing: border-box
  padding: 0 15px 0 30px
  border: 1px solid #e3e3e3
  color: $dark
  outline: none
  border-radius: 15px
  margin-right: 10px

  background: #fff url(./../../../assets/search.png) 8px 5px no-repeat
  background-size: 20px
  vertical-align: middle !important

  &:focus
    border-color: $color-main-primary

#logo
  display: inline-block
  font-size: 1.5em
  line-height: $header-height
  color: $dark
  font-family: $logo-font
  font-weight: 500

  img
    vertical-align: middle
    margin-right: 6px
    width: $header-height
    height: $header-height

#header
  box-shadow: 0 0 1px rgba(0, 0, 0, .25)

// 添加导航栏显示动画
.slide-fade-enter-active, .slide-fade-leave-active {
  transition: all .8s ease;
}

.slide-fade-leave-to, .slide-fade-enter {
  /* .slide-fade-leave-active for below version 2.1.8 */
  transform: translateY(-70px);
  opacity: 0;
}
</style>
