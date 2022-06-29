<template>
  <div>
    <SimpleHeader/>
    <router-view/>
    <CommonFooter/>
    <div class="backTop" v-show="btnFlag" @click="backTop"></div>
    <div>
      <aplayer :audio="audio" :lrcType="1" fixed/>
    </div>
  </div>
</template>

<script>
import SimpleHeader from '@/components/header/SimpleHeader'
import CommonFooter from '@/components/footer/CommonFooter'

export default {
  components: {
    SimpleHeader,
    CommonFooter
  },
  data () {
    return {
      btnFlag: false,
      audio: []
    }
  },
  created () {
    // vue的两个生命钩子，这里不多解释。
    // window对象，所有浏览器都支持window对象。它表示浏览器窗口，监听滚动事件
    window.addEventListener('scroll', this.scrollToTop)
  },

  destroyed () {
    window.removeEventListener('scroll', this.scrollToTop)
  },

  mounted () {
    this.musicList()
  },

  methods: {
    // 点击图片回到顶部方法，加计时器是为了过渡顺滑
    backTop () {
      const that = this
      let timer = setInterval(() => {
        let speed = Math.floor(-that.scrollTop / 5)
        document.documentElement.scrollTop = document.body.scrollTop = that.scrollTop + speed
        if (that.scrollTop === 0) {
          clearInterval(timer)
        }
      }, 16)
    },

    // 为了计算距离顶部的高度，当高度大于60显示回顶部图标，小于60则隐藏
    scrollToTop () {
      const that = this
      that.scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop
      that.btnFlag = that.scrollTop > 0
    },

    // 音乐列表
    musicList () {
      let params = {
        pageSize: 10,
        currentPage: 1
      }
      this.$http({
        url: this.$http.adornUrl('/music/list'),
        method: 'get',
        params: this.$http.adornParams(params)
      }).then(({data}) => {
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
