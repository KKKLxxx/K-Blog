<template>
  <div class="photowall">
    <iv-row>
      <!-- <iv-col span="8" style="padding-left: 0;padding-right: 0;">
        <div class="big-photo">
          <a href="">
            <img src="../../assets/photowall/4.gif" alt="">
          </a>
        </div>
      </iv-col>
      <iv-col span="8" style="padding-left: 0;padding-right: 0;">
        <div class="big-photo">
          <a href="">
            <img src="../../assets/photowall/3.gif" alt="">
          </a>
        </div>
      </iv-col> -->
      <iv-col span="25" style="padding-left: 0;padding-right: 0;">
        <div class="big-photo">
          <a href="">
            <img src="@/assets/photowall/1.gif" alt="">
          </a>
        </div>
      </iv-col>
      <!-- <iv-col span="12" style="padding-left: 0;padding-right: 0;">
        <iv-row>
          <iv-col span="12" style="padding-left: 0;padding-right: 0;">
            <div class="small-photo">
              <a href="">
                <img src="../../assets/photowall/3.gif" alt="">
              </a>
            </div>
          </iv-col>
          <iv-col span="12" style="padding-left: 0;padding-right: 0;">
            <div class="small-photo">
              <a href="">
                <img src="../../assets/photowall/5.gif" alt="">
              </a>
            </div>
          </iv-col>
        </iv-row>
        <iv-row>
          <iv-col span="12" style="padding-left: 0;padding-right: 0;">
            <div class="small-photo">
              <a href="">
                <img src="../../assets/photowall/5.gif" alt="">
              </a>
            </div>
          </iv-col>
          <iv-col span="12" style="padding-left: 0;padding-right: 0;">
            <div class="small-photo">
              <a href="">
                <img src="../../assets/photowall/5.gif" alt="">
              </a>
            </div>
          </iv-col>
        </iv-row>
      </iv-col> -->
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">

</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
.photowall
  .big-photo
    padding-bottom: 42%
    width: 100%
    height: 0
    overflow hidden

    a
      display: block
      width: 100%

      img
        width 100%
        transition: All 0.4s ease-in-out
        transform: scale(1.0)
        zoom: 1.0

    &:hover
      img
        transition: All 0.4s ease-in-out
        transform: scale(1.05)
        zoom: 1.05

  .small-photo
    padding-bottom: 100%;
    width: 100%;
    height: 0;
    overflow hidden

    a
      display: block
      width: 100%

      img
        width 100%
        transition: All 0.4s ease-in-out
        transform: scale(1.0)
        zoom: 1.0

    &:hover
      img
        transition: All 0.4s ease-in-out
        transform: scale(1.05)
        zoom: 1.05

</style>
