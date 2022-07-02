<template>
  <div class="recommend">
    <panel :title="'推荐阅读'">
      <div slot="content" class="content">
        <div class="top" v-for="recommend in recommendList" :key="recommend.id">
          <router-link :to="{name:'article',params:{articleId:recommend.id}}">
            <p class="title">{{ recommend.articleName }}</p>
            <p class="info">
              <span class="time">{{ recommend.createTime }}</span>
              <!--              <span class="likes"><iv-icon type="heart"></iv-icon> {{ recommend.likeNum }} </span>-->
              <!--              <span class="comments"><iv-icon type="compose"></iv-icon> {{ recommend.commentNum }} </span>-->
              <span class="readings"><iv-icon type="eye"></iv-icon> {{ recommend.articleReadCount }} </span>
            </p>
          </router-link>
        </div>
      </div>
    </panel>
  </div>
</template>

<script type="text/ecmascript-6">
import Panel from '@/components/Panel'
import merge from 'lodash/merge' // 合并对象工具

export default {
  components: {
    'panel': Panel
  },
  data() {
    return {
      recommendList: [],
      currentPage: 1,
      pageSize: 5
    }
  },
  created() {
    this.listRecommend()
  },
  methods: {
    listRecommend() {
      let orderBy = {
        articleState: 2
      }
      let params = merge(orderBy)
      this.$http({
        url: this.$http.adornUrl('/article/recommend'),
        method: 'get',
        params: this.$http.adornParams(params)
      }).then(({ data }) => {
        if (data.result.data !== null && data.status === 0) {
          this.recommendList = data.result.data
        }
      })
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">

.recommend
  .content
    padding 5px 20px

  .top, .others
    a
      display block
      overflow hidden

      .tags
        margin-bottom 10px

      .title
        text-align justify
        color $color-gradually-gray-41
        font-size 16px
        line-height 23px
        margin-bottom 5px

      .info
        margin 5px 0 0px

        span
          font-size 13px
          line-height 18px
          font-weight 100
          color $color-secondary-info

          + span
            float right
            margin-left 10px

        a
          display inline-block
          color: #777
          cursor pointer

          &:hover
            color $color-main-primary
            text-decoration underline

      .img
        padding-bottom: 40%
        width: 100%
        height: 0
        margin 5px 0
        overflow hidden

        img
          width 100%
          transition: All 0.4s ease-in-out
          transform: scale(1.0)
          zoom: 1.0

      .desc
        text-align justify
        color $color-secondary-info
        font-size 13px
        line-height 20px
        margin 5px 0 0

      &:hover
        .title
          color $color-main-primary

        img
          transition: All 0.4s ease-in-out
          transform: scale(1.05)
          zoom: 1.05

  .others
    li
      list-style-type none
      margin-top 10px
      padding-top 10px
      border-top 1px solid $color-border

</style>
