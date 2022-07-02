<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <photo-wall></photo-wall>
          <section-title :mainTitle="'博文'" :subTitle="'Articles'">
            <title-menu-filter @filterByMenu="refreshArticle" slot="menu"></title-menu-filter>
          </section-title>
          <article-list-cell v-for="article in articleList" :key="article.id" :article="article"></article-list-cell>
          <iv-page :total="total" :current="pageParam.curPage"
                   :page-size="pageParam.pageSize" :page-size-opts="[5, 10, 15, 20]"
                   @on-change="changePage" @on-page-size-change="changeSize"
                   show-elevator show-total show-sizer/>
        </div>
      </iv-col>
      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <about/>
          <recommend style="margin-top:20px;" />
          <friend-links style="margin-top:20px;" />
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
import { getAll } from '@/api/article'

export default {
  components: {
    'photo-wall': PhotoWall,
    'article-list-cell': ArticleListCell,
    'section-title': SectionTitle,
    'title-menu-filter': TitleMenuFilter,
    'about': About,
    'friend-links': FriendLinks,
    'recommend': Recommend
  },
  data() {
    return {
      articleList: [],
      total: 0,
      pageParam: {
        pageSize: 5,
        curPage: 1
      }
    }
  },
  created: function() {
    this.refreshArticle()
  },
  methods: {
    refreshArticle(param) {
      const params = merge(param, this.pageParam)
      getAll(params).then(response => {
        this.articleList = response.data.records
        this.total = response.data.total
      })
    },
    changePage(page) {
      this.pageParam.curPage = page
      this.refreshArticle()
    },
    changeSize(size) {
      this.pageParam.pageSize = size
      this.pageParam.curPage = 1
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
</style>
