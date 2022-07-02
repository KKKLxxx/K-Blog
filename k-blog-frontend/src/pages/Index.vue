<template>
  <div>
    <CommonHeader/>
    <router-view/>
    <CommonFooter/>
    <div class="backTop" v-show="btnFlag" @click="backTop"></div>
    <div>
      <aplayer :audio="audio" :lrcType="1" fixed/>
    </div>
  </div>
</template>

<script>
import CommonHeader from '@/components/header/CommonHeader'
import CommonFooter from '@/components/footer/CommonFooter'

export default {
  components: {
    CommonHeader,
    CommonFooter
  },
  data() {
    return {
      btnFlag: false,
      audio: []
    }
  },

  mounted() {
    this.musicList()
  },

  methods: {
    // 点击图片回到顶部方法，加计时器是为了过渡顺滑
    backTop() {
      const that = this
      let timer = setInterval(() => {
        let speed = Math.floor(-that.scrollTop / 5)
        document.documentElement.scrollTop = document.body.scrollTop = that.scrollTop + speed
        if (that.scrollTop === 0) {
          clearInterval(timer)
        }
      }, 16)
    },

    // 音乐列表
    musicList() {
      let params = {
        pageSize: 10,
        currentPage: 1
      }
      this.$http({
        url: this.$http.adornUrl('/music/list'),
        method: 'get',
        params: this.$http.adornParams(params)
      }).then(({ data }) => {
        if (data.result.data !== null && data.status === 0) {
          this.audio = data.result.data.list
        }
      })
    }
  }
}

</script>

<style scoped>
.backTop {
  position: fixed;
  bottom: 10px;
  right: 45px;
  width: 23px;
  height: 23px;;
  background: url('../assets/toTop.png');
  cursor: pointer;
}
</style>
