<template>
  <div class="article-page-footer">
    <license-tag :tags="tags"></license-tag>
    <article-pay></article-pay>
    <Comment :commentList="commentList" :postId="postId" @on-comment="showCommentById"></Comment>
    <br/>
    <br/>
  </div>
</template>

<script type="text/ecmascript-6">
import LicenseTag from '@/components/Article/LicenseTag'
import Pay from '@/components/Article/Pay'
import Comment from '@/components/Comment/Comment'

export default {
  components: {
    'license-tag': LicenseTag,
    'article-pay': Pay,
    'Comment': Comment
  },
  data () {
    return {}
  },
  props: {
    postId: Number,
    tags: Array,
    commentList: Array
  },
  methods: {
    showCommentById () {
      this.$emit('on-comment', this.postId)
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
@import "../../common/stylus/theme.styl";

.article-page-footer
  text-align left

  .operate_menu
    margin-top 30px

  .comment-menu
    margin-top 30px

    .comment-menu-item
      margin-bottom 20px

    p.comment-menu-item
      a
        font-size 14px

        &:hover
          color $color-main-primary

.operate_info
  text-align right
  font-size 14px
  margin-left 15 0 0 0

</style>
