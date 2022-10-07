<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <photo-wall />
          <article-list :mainTitle="'博文'" :subTitle="'Article'"/>
        </div>
      </iv-col>

      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <about />
          <recommend style="margin-top:20px;" />
          <friend-links style="margin-top:20px;" />
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">
import PhotoWall from '@/components/PhotoWall'
import ArticleList from '@/components/Article/ArticleList'
import About from '@/components/About'
import FriendLinks from '@/components/FriendLinks'
import Recommend from '@/components/category/CategoryPanel'

export default {
  components: {
    'photo-wall': PhotoWall,
    'about': About,
    'friend-links': FriendLinks,
    'recommend': Recommend,
    'article-list': ArticleList
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.home-content
  width 1300px
  margin 15px auto 0
  margin-bottom 200px

  .layout-left, .layout-right
    padding 0 10px
</style>
