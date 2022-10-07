<template>
  <div>
    <section-title :mainTitle="mainTitle" :subTitle="subTitle">
      <title-menu-filter slot="menu" @filterByMenu="getArticles" />
    </section-title>
    <article-list-cell v-for="article in articleList" :key="article.id" :article="article" />
    <iv-page :total="total" :current="pageParam.curPage"
             :page-size="pageParam.pageSize" :page-size-opts="[5, 10, 15, 20]"
             @on-change="changePage" @on-page-size-change="changeSize"
             show-elevator show-total show-sizer />
  </div>
</template>

<script type="text/ecmascript-6">
import ArticleListCell from '@/components/Article/ArticleListCell'
import SectionTitle from '@/components/SectionTitle/SectionTitle'
import TitleMenuFilter from '@/components/SectionTitle/TitleMenuFilter'
import merge from 'lodash/merge'
import { getAll } from '@/api/article' // 合并对象工具

export default {
  components: {
    'article-list-cell': ArticleListCell,
    'section-title': SectionTitle,
    'title-menu-filter': TitleMenuFilter
  },
  props: {
    mainTitle: '',
    subTitle: '',
    categoryId: 0
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
  created() {
    this.getArticles()
  },
  methods: {
    getArticles() {
      const param = { 'categoryId': this.categoryId }
      const params = merge(param, this.pageParam)
      getAll(params).then(({ data }) => {
        this.articleList = data.records
        this.total = data.total
      })
    },
    changePage(page) {
      this.pageParam.curPage = page
      this.getArticles()
    },
    changeSize(size) {
      this.pageParam.pageSize = size
      this.pageParam.curPage = 1
      this.getArticles()
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.article-list-content
  width auto
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

.ivu-card, .ivu-card-bordered
  border 1px solid #dcdee2
  border-color #e8eaec

.before {
  box-sizing: border-box;
}

.live-cover {
  height: 150px;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 50%;
  border-radius: 4px;
}

.live-info {
  height: 130px;
  padding: 10px
}

.live-title {
  font-size: 16px;
  font-weight: 700;
}

.live-desc {
  color: #9ea7b4;
  margin-top: 20px;
  line-height: 20px
}

.live-down {
  margin-top: -10px;
}

.live-down-left {
  margin-top: 20px;
  float: left
  width: 200px;
}

.live-for {
  float: left;
  margin-left: 15px;
}

.live-down-right {
  width: 50px;
  margin-left: 400px;
}

.live-name {
  width: 200px;
  font-size: 15px;
}

.live-time {
  color: #9ea7b4;
  width: 200px;
  margin-top: 5px;
  font-size: 10px;
  line-height: 20px;
}

.icon {
  margin-right: 10px;
}
</style>
