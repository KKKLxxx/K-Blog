<template>
  <div class="about">
    <img class="background" src="@/assets/350.jpg" alt="">
    <img class="avatar" src="@/assets/touxiang.jpg" alt="">
<!--    <img class="avatar" src="@/assets/tx.gif" alt="">-->
<!--    <p v-show="this.manager.name === ''" class="name">（待修改）</p>-->
<!--    <p v-show="this.manager.name !== ''" class="name">{{ manager.name }}</p>-->
    <p class="name">KKKL</p>
    <p class="desc">那次车窗起雾，写的还是你的名字</p>
    <div class="line"></div>
    <ul class="social">
      <li>
        <div style="float: left" class="desc">社交:</div>
        <iv-poptip trigger="hover" title="QQ：1223344454">
          <a href="tencent://AddContact/?fromId=50&fromSubId=1&subcmd=all&uin=1223344454" target="_blank"><img src="@/assets/icon/qq.png"  alt=""></a>
        </iv-poptip>
        <iv-poptip trigger="hover" title="Gitee：KKKLxxx">
          <a href="https://gitee.com/KKKLxxx" target="_blank"><img src="@/assets/icon/gitee.png" alt=""></a>
        </iv-poptip>
        <iv-poptip trigger="hover" title="Github：KKKLxxx">
          <a href="https://github.com/KKKLxxx" target="_blank"><img src="@/assets/icon/github.png" alt=""></a>
        </iv-poptip>
      </li>
    </ul>
<!--    <div class="line"></div>
    <ul class="social">
      <li>
        <div style="float: left;margin-top: 0px" class="desc">加入我们:</div>
        &lt;!&ndash; <a href="//shang.qq.com/wpa/qunwpa?idkey=8af40e2d5571c9cd39289c4e1f9cabd2374da9d61950d0ec41a458bc1ad88057" target="_blank" style="margin-left:-30px "><img src="../../assets/icon/Qqun.png"  alt=""><span style="font-size: 8px">技术交流</span></a> &ndash;&gt;
        <a href="//shang.qq.com/wpa/qunwpa?idkey=5342c70630733610e25122d3731f16a58a2db6c84ccb7861a736138685998e11"
           target="_blank" style="margin-left: -50px;width: 50px; "><img src="@/assets/icon/Qqun.png" alt=""><span
          style="font-size: 5px">技术交流</span></a>
      </li>
    </ul>-->
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data () {
    return {
      manager: {
        name: ''
      }
    }
  },
  mounted () {
    let manager = JSON.parse(localStorage.getItem('currentManager'))
    if (manager !== null) {
      this.manager = manager
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
@import "../common/stylus/theme.styl";

.about
  position relative
  text-align center
  border 1px solid $color-border
  padding-bottom 20px
  background-color #fff

  img.background
    position absolute
    top 0
    left 0
    right 0
    width 100%
    height 125px
    z-index 1

  img.avatar
    position relative
    margin 75px auto 15px
    width 100px
    height 100px
    border 5px solid $color-gradually-gray-91
    border-radius 50%
    z-index 9

  .name
    font-size 22px
    color $color-typegraphy-title
    line-height 30px
    font-weight 700

  .desc
    font-size 15px
    color $color-secondary-info
    line-height 30px
    font-weight 100

  .social
    text-align center
    padding 0 20px
    margin-top 15px

    > li
      padding 8px

      a
        display inline-block
        width: 44px
        height: 44px
        margin: auto

        img
          width 90%

  .line
    height 1px
    background-color $color-gradually-gray-91
    margin 10px 20px

  h4
    font-size 19px
    margin 30px 0 20px
    font-weight 600

  .progresses
    padding 0 20px

    p.title
      height 38px
      line-height 38px
      text-align right

    .bar
      margin 10px 0
</style>
