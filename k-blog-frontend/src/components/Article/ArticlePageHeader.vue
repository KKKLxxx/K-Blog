<template>
  <div class="article-page-header">
    <p class="title">{{ article.title }}</p>
    <iv-row>
      <iv-col :xs="24" :sm="10" :md="10" :lg="10" style="padding-left: 0;padding-right: 0;">
        <p class="info">
          <span class="author"><iv-icon type="ios-person" size="18" />KKKL</span>
          <span class="publish-time"><iv-icon type="ios-time-outline" size="14" />{{ article.createTime }}</span>
        </p>
      </iv-col>
<!--      <iv-col :xs="24" :sm="14" :md="14" :lg="14" style="padding-left: 0;padding-right: 0;">
        <p class="operate_info">
          <span><iv-icon type="md-eye" size="18" />阅读 {{ article.readNum }}</span>
          <span class="like"><a @click="likePost(article)"><iv-icon type="md-thumbs-up" size="19" /></a>点赞 {{ article.likeNum }}</span>
        </p>
      </iv-col>-->
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">

export default {
  props: {
    article: {}
  },
  data() {
    return {
      manager: {}
    }
  },
  methods: {
    likePost(post) {
      this.$http({
        url: this.$http.adornUrl('/article/like/' + post.id),
        method: 'put',
        data: this.$http.adornData()
      }).then(({ data }) => {
        if (data && data.code === 200) {
          post.likeNum += 1
          this.$Message.success('点赞成功')
        }
      }).catch((error) => {
        console.log(error)
      })
    }
  },
  mounted() {
    let manager = JSON.parse(localStorage.getItem('currentManager'))
    if (manager !== null) {
      this.manager = manager
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">

.article-page-header
  text-align left
  padding 25px 5px 10px 5px
  @media only screen and (max-width: 768px)
    padding-top 10px
  @media screen and (min-width: 768px)
    padding-top 10px
  @media screen and (min-width: 992px)
    padding-top 25px

  .tags
    margin-bottom 18px

  .title
    font-size 30px
    font-weight bold
    color $color-typegraphy-title
    margin-bottom 23px
    text-align center

  .info
    margin-top 10px
    font-size 14px
    line-height 18px
    font-weight 200

    a
      color: #777
      cursor pointer

      &:hover
        color $color-main-primary
        text-decoration underline

    .publish-time
      margin-left 20px

  .operate_info
    text-align right
    font-size 14px
    margin 15px 0
    @media only screen and (max-width: 768px)
      text-align left

    span
      margin-right 10px

      + span
        margin-left 10px

      a
        cursor pointer

        &:hover
          color $color-main-primary
          text-decoration underline

  .abstract
    color $default-desc-color
    border 1px dashed $default-border-color
    background $default-border-color
    @media only screen and (max-width: $responsive-sm)
      padding 8px
      margin-top 8px
      font-size 13px
      line-height 18px
    @media screen and (min-width: $responsive-sm)
      padding 15px
      margin-top 8px
      font-size 14px
      line-height 24px
    @media screen and (min-width: $responsive-md)
      padding 20px
      margin-top 15px
      line-height 28px
    @media screen and (min-width: $responsive-lg)
      padding 20px
      margin-top 15px
      line-height 28px

.like {
  a:link {
    color:#000000;
  }  /* 未访问链接*/
  a:visited {
    color:#00FF00;
  }  /* 已访问链接 */
  a:hover {
    color:#FF00FF;
  }  /* 鼠标移动到链接上 */
  a:active {
    color:#0000FF;
  }  /* 鼠标点击时 */
}
</style>
