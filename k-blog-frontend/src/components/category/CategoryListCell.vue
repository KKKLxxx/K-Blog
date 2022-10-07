<template>
  <iv-card class="ivu">
    <router-link :to="{ name: 'categoryArticleList', params: {categoryId: category.id}, query: {mainTitle: '分类文章', categoryName: category.name} }" target="_blank">
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
  </iv-card>
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

.ivu {
  background-color #fff;
  margin-bottom: 10px;
  cursor: pointer;
}

.live-cover {
  width: 230px
  height: 150px
  overflow: hidden
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
