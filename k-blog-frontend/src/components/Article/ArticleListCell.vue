<template>
  <div>
    <a>
      <iv-card class="ivu">
        <div class="ivu-row">
          <router-link :to="'/article/' + article.id" target="_blank">
            <div class="ivu-col ivu-col-span-7">
              <img class="live-cover" :src="article.categoryCover">
            </div>
            <div class="ivu-col ivu-col-span-17">
              <div class="live-info">
                <div class="live-title">{{ article.title }}</div>
                <div class="live-desc">{{ article.intro }}</div>
              </div>
              <div class="live-down">
                <div class="live-down-left">
                </div>
                <div class="live-down-right">
                  <div class="live-name">
                    <iv-icon type="ios-contact" class="icon"/>
                    KKKL
                  </div>
                  <div class="live-time">
                    <iv-icon type="ios-timer-outline" class="icon"/>
                    {{ article.createTime }}
                  </div>
                </div>
              </div>
            </div>
          </router-link>
        </div>
      </iv-card>
    </a>
  </div>
</template>

<script>

export default {
  props: {
    article: {}
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
@import "../../common/stylus/index.styl";

> a
  display block
  cursor default
  border 1px solid $color-border

  &:hover
    border 1px solid $color-border-hover
    box-shadow 2px 2px 3px $color-border

.ivu {
  background-color #fff;
  margin-bottom: 10px;
  cursor: pointer;
}

.live-cover {
  width: 230px
  height: 150px;
  border-radius: 4px;
}

.live-info {
  height: 110px;
  padding: 10px;
  overflow: hidden;
}

.live-title {
  font-size: 16px;
  font-weight: 700;
  margin-left: 5px;
}

.live-desc {
  color: #9ea7b4;
  margin-top: 20px;
  line-height: 20px;
  margin-left: 5px;
}

.live-down-left {
  margin-top: 20px;
  float: left;
  width: 200px;
}

.live-for {
  float: left;
  margin-left: 15px;
}

.live-down-right {
  width: 50px;
  margin-left: 400px;
}

.live-name {
  width: 200px;
  font-size: 15px;
}

.live-time {
  color: #9ea7b4;
  width: 200px;
  margin-top: 5px;
  font-size: 10px;
  line-height: 20px;
}

.icon {
  margin-right: 10px;
}
</style>
