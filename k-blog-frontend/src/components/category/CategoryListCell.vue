<template>
  <div>
    <a>
      <iv-card class="ivu">
        <div class="ivu-row">
          <router-link :to="'/category/' + category.id" target="_blank">
            <div class="ivu-col">
              <img class="live-cover" :src="category.cover">
            </div>
            <div class="ivu-col">
              <div class="live-info">
                <div class="live-title">{{ category.name }}</div>
                <div class="live-desc">共 {{ category.total }} 篇</div>
              </div>
            </div>
          </router-link>
        </div>
      </iv-card>
    </a>
  </div>
</template>

<script type="text/ecmascript-6">

export default {
  props: {
    category: {}
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
  height 60px
  padding-left 4px
}

.live-title {
  margin 0
  font-size: 25px;
}

.live-desc {
  margin 0
  color: #9ea7b4;
  font-size: 10px;
}
</style>
