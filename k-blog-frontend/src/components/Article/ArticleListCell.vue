<template>
  <router-link :to="'/article/' + article.id" target="_blank">
    <iv-card class="ivu">
      <div class="ivu-row">
        <div class="live-title">{{ article.title }}</div>
        <div class="live-down-left">
          <router-link :to="{ name: 'categoryArticleList', params: {categoryId: article.categoryId}, query: {mainTitle: '分类文章', categoryName: article.categoryName} }" class="iconfont icon-icon-test">
            {{ article.categoryName }}
          </router-link>
        </div>
        <div class="live-down-right">
          <div class="live-name">
            <iv-icon type="ios-person" size="18" />
            KKKL
          </div>
          <div class="live-time">
            <iv-icon type="ios-time-outline" size="14" />
            {{ article.createTime }}
          </div>
        </div>
      </div>
    </iv-card>
  </router-link>
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

.live-title {
  font-size: 25px;
  margin-left: 20px;
}

.live-down-left {
  margin-left 20px
  font-size 18px
}

.live-down-right {
  margin-left: 620px;
}

.live-name {
  font-size: 15px;
}

.live-time {
  margin-left 2px
  color: #9ea7b4;
  font-size: 12px;
}

</style>
