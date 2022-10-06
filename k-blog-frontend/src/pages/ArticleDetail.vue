<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left" style="background-color: #fff;padding:30px 20px 10px 20px">
          <article-page-header :article="article" />
          <article-page-content :content="article.content" />
          <article-page-footer :postId="article.id" :commentList="commentList" @on-comment="showCommentById" />
        </div>
      </iv-col>

      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <recommend/>
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">
import ArticlePageHeader from '@/components/Article/ArticlePageHeader'
import ArticlePageContent from '@/components/Article/ArticlePageContent'
import ArticlePageFooter from '@/components/Article/ArticlePageFooter'
import Recommend from '@/components/Recommend'
import { getById } from '@/api/article'

export default {
  components: {
    'article-page-header': ArticlePageHeader,
    'article-page-content': ArticlePageContent,
    'article-page-footer': ArticlePageFooter,
    'recommend': Recommend
  },
  data() {
    return {
      article: {},
      commentList: []
    }
  },
  created() {
    this.getArticle(this.$route.params.articleId)
    this.showCommentById(this.$route.params.articleId)
  },
  methods: {
    getArticle(articleId) {
      const params = { 'articleId': articleId }
      getById(params).then(({ data }) => {
        this.article = data
      })
    },
    // 根据id查询该博客的评论信息
    showCommentById(articleId) {
      this.$http({
        url: this.$http.adornUrl('/comment/' + articleId),
        method: 'get'
      }).then(({ data }) => {
        if (data) {
          this.commentList = data.result.data
        } else {
          this.$Message.error(data.result.message)
        }
      })
    }
  }
}
</script>
