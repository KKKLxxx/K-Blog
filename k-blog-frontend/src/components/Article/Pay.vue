<template>
  <div class="pay">
    <div>
      <iv-poptip trigger="hover">
        <iv-button class="screen-reader-text">
          赏
        </iv-button>

        <div slot="content" class="screen">
          <div>
            <div slot="title" class="tit">微信打赏</div>
            <iv-button type="text" class="btn">
              <img src="@/assets/weChatpay.png" alt="">
            </iv-button>
          </div>
          <div>
            <div slot="title" style="margin-left: 30px">支付宝打赏</div>
            <iv-button type="text" class="btn" style="margin-left: 30px">
              <img src="@/assets/alipay.jpg" alt="">
            </iv-button>
          </div>
        </div>

      </iv-poptip>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">

</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
.pay
  padding-bottom: 10%
  // margin-left:300px
  width auto
  height: 120px
  text-align center
  overflow hidden

  img
    width 100%

.btn
  border: 1px solid #6190e8;
  width: 150px
  height: 150px
  padding: 5px
  border-style: dashed;

.screen
  width: 330px
  height: 170px
  display: flex;

.screen-reader-text
  position: relative;
  display: block;
  font-size: 30px;
  width: 62px;
  height: 62px;
  margin: 0 auto;
  color: #6190e8;
  background-color: #fff;
  border: 1px solid #6190e8;

  border-radius: 50%;
</style>
