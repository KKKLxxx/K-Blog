<template>
  <div class="article-list-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <section-title :mainTitle="'技术交流'" :subTitle="'整理个人技术栈中的知识点'">
            <title-menu-filter @filterByMenu="listArticle" slot="menu"></title-menu-filter>
          </section-title>
          <article-list-cell v-for="article in articleList" :article="article" :key="article.id"></article-list-cell>
          <iv-page class="mt-10 text-right" :total="total" :current="currentPage" :page-size="pageSize"
                   @on-change="changePage" @on-page-size-change="changeSize" show-elevator show-total
          />
        </div>
      </iv-col>
      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <recommend></recommend>
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">
import Recommend from '@/components/Recommend'
import ArticleListCell from '@/components/Article/ArticleListCell'
import SectionTitle from '@/components/SectionTitle/SectionTitle'
import TitleMenuFilter from '@/components/SectionTitle/TitleMenuFilter'
import merge from 'lodash/merge' // 合并对象工具

export default {
  components: {
    'recommend': Recommend,
    'article-list-cell': ArticleListCell,
    'section-title': SectionTitle,
    'title-menu-filter': TitleMenuFilter
  },
  data() {
    return {
      articleList: [],
      currentPage: 1,
      pageSize: 5,
      total: 0
    }
  },
  created() {
    let param = {}
    param.latest = true
    this.listArticle(param)
  },
  methods: {
    listArticle(param) {
      let orderBy = {
        articleType: 1001,
        pageSize: this.pageSize,
        currentPage: this.currentPage
      }
      let params = merge(param, orderBy)
      this.$http({
        url: this.$http.adornUrl('/article/list'),
        method: 'get',
        params: this.$http.adornParams(params)
      }).then(({ data }) => {
        if (data.result.data !== null && data.status === 0) {
          this.articleList = data.result.data.list
          this.total = data.result.data.total
        }
      })
    },
    changePage(page) {
      this.currentPage = page
      this.$router.push({
        path: this.$route.path,
        query: {
          latest: true,
          pageSize: 5,
          currentPage: this.currentPage
        }
      })
      this.listArticle()
    },
    changeSize(size) {
      this.pageSize = size
      this.currentPage = 1
      this.listArticle()
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.article-list-content
  width auto
  min-height calc(100vh - 308px)
  @media only screen and (max-width: 768px)
    margin 5px 5px 0 5px
  @media screen and (min-width: 768px)
    margin 10px 10px 0 10px
  @media screen and (min-width: 992px)
    margin 15px 35px 0 35px
  @media screen and (min-width: 1200px)
    width 1200px
    margin 15px auto 0
    margin-bottom 200px

  .layout-left, .layout-right
    padding 0
    @media only screen and (max-width: 768px)
      padding 0
    @media screen and (min-width: 768px)
      padding 0
    @media screen and (min-width: 992px)
      padding 0 10px
    @media screen and (min-width: 1200px)
      padding 0 10px

</style>
