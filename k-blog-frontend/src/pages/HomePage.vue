<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <photo-wall></photo-wall>
          <section-title :mainTitle="'博文'" :subTitle="'Articles'">
             <title-menu-filter @filterByMenu="refreshArticle"  slot="menu"></title-menu-filter>
          </section-title>
          <article-list-cell v-for="article in articleList" :article="article" :key="article.title"
                             :type="'article'"></article-list-cell>
          <iv-page class='mt-10 text-right' :total="total" :current='pageParam.currentPage'
                   :page-size='pageParam.pageSize' @on-change="changePage" @on-page-size-change="changeSize"
                   show-elevator show-total/>
        </div>
      </iv-col>
      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <about></about>
          <recommend></recommend>
          <friend-links style="margin-top:15px;"></friend-links>
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">
import PhotoWall from '@/components/PhotoWall'
import ArticleListCell from '@/components/Article/ArticleListCell'
import SectionTitle from '@/components/SectionTitle/SectionTitle'
import TitleMenuFilter from '@/components/SectionTitle/TitleMenuFilter'
import About from '@/components/About'
import FriendLinks from '@/components/FriendLinks'
import Recommend from '@/components/Recommend'
import merge from 'lodash/merge' // 合并对象工具

export default {
  data () {
    return {
      articleList: [],
      manager: {},
      total: 1,
      pageParam: {
        pageSize: 5,
        currentPage: 1
      }
    }
  },
  components: {
    'photo-wall': PhotoWall,
    'article-list-cell': ArticleListCell,
    'section-title': SectionTitle,
    'title-menu-filter': TitleMenuFilter,
    'about': About,
    'friend-links': FriendLinks,
    'recommend': Recommend
  },
  created: function () {
    let param = {}
    param.latest = true
    this.refreshArticle(param)
  },
  mounted: function () {
    let manager = JSON.parse(localStorage.getItem('currentManager'))
    if (manager !== null) {
      this.manager = manager
    }
  },
  methods: {
    refreshArticle (param) {
      let params = merge(param, this.pageParam)
      this.$http({
        url: this.$http.adornUrl('/article/list'),
        params: this.$http.adornParams(params),
        method: 'get'
      }).then(({data}) => {
        if (data.result.data !== null && data.status === 0) {
          this.articleList = data.result.data.list
          this.total = data.result.data.total
        }
      })
    },
    changePage (page) {
      this.pageParam.currentPage = page
      this.$router.push({
        path: this.$route.path,
        query: {
          latest: true,
          pageSize: 5,
          currentPage: this.pageParam.currentPage
        }
      })
      this.refreshArticle()
    },
    changeSize (size) {
      this.pageParam.pageSize = size
      this.pageParam.currentPage = 1
      this.refreshArticle()
    }
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

/*.live-bg{
  background-image:url({{this.imgUrl}})
}*/
</style>
