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
                  <router-link :to="'/category/' + article.categoryId" class="iconfont icon-icon-test">
                    {{ article.categoryName }}
                  </router-link>
                </div>
                <div class="live-down-right">
                  <div class="live-name">
                    <iv-icon type="ios-person" size="18" />
                    KKKL
                  </div>
                  <Icon type="person"></Icon>
                  <div class="live-time">
                    <iv-icon type="ios-time-outline" size="14" />
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
  font-size: 20px;
  margin-left: 5px;
}

.live-desc {
  color: #9ea7b4;
  margin-top: 20px;
  line-height: 20px;
  margin-left: 6px;
}

.live-down-left {
  margin-top: 20px;
  margin-left 15px
  font-size 18px
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
  font-size: 15px;
  text-align bottom
}

.live-time {
  margin-left 2px
  color: #9ea7b4;
  font-size: 12px;
}

</style>
