<template>
  <div class="time-content">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <timeline-header></timeline-header>
          <div v-for="year in timelineList" :key="year.year">
            <archive-list-time-title :date="year.year" :count="year.article.length"></archive-list-time-title>
            <archive-list-cell v-for="post in year.article" :post="post"
                               :key="post.articleName"
            ></archive-list-cell>
            <!-- <archive-list-cell v-for="post in year.article"
                               :key="post.articleName"></archive-list-cell> -->
          </div>
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
import TimeLineHeader from '@/components/TimeLine/TimeLineHeader'
import ArchiveListCell from '@/components/TimeLine/ArchiveListCell'
import ArchiveListTimeTitle from '@/components/TimeLine/ArchiveListTimeTitle'
import Recommend from '@/components/Recommend'

export default {
  data() {
    return {
      timelineList: []
    }
  },
  components: {
    'timeline-header': TimeLineHeader,
    'archive-list-time-title': ArchiveListTimeTitle,
    'archive-list-cell': ArchiveListCell,
    'recommend': Recommend
  },
  created() {
    this.listTimeline()
  },
  mounted() {
    var h = document.body.clientHeight - 60 - 35 - 30
    document.getElementsByClassName('home-content')[0].style.height = h + 'px'
  },
  methods: {
    listTimeline() {
      this.$http({
        url: this.$http.adornUrl('/article/timeLine'),
        params: this.$http.adornParams(),
        method: 'get'
      }).then(({ data }) => {
        if (data.result.data !== null && data.status === 0) {
          this.timelineList = data.result.data
        }
      })
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.time-content
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

/*.live-bg{
  background-image:url({{this.imgUrl}})
}*/
</style>
