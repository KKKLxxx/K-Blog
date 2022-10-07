<template>
  <panel :title="'文章分类'">
    <div slot="content" class="content">
      <div v-for="category in categoryList" :key="category.id" class="top">
        <router-link :to="{ name: 'categoryArticleList', params: {categoryId: category.id}, query: {mainTitle: '分类文章', categoryName: category.name} }" target="_blank">
          <div class="name">{{ category.name }}
            <div class="num"> {{category.total}} </div>
          </div>
        </router-link>
      </div>
    </div>
  </panel>
</template>

<script type="text/ecmascript-6">
import Panel from '@/components/Panel'
import { getAll } from '@/api/category'

export default {
  components: {
    'panel': Panel
  },
  data() {
    return {
      categoryList: []
    }
  },
  created() {
    this.getCategories()
  },
  methods: {
    getCategories() {
      getAll().then(({ data }) => {
        this.categoryList = data
      })
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
@import "../../common/stylus/index.styl";

.content
  padding 5px 20px

.top
  a
    padding 4px
    display block
    margin-top 10px
    margin-bottom 10px

    .name
      color $color-gradually-gray-21
      font-size 20px
      //margin-top 5px
      display inline

      .num
        width 40px
        display inline-block
        margin-left 180px
        padding-left 3px
        padding-right 3px
        font-size 16px
        background-color $color-gradually-gray-81

  &:hover
    box-shadow 2px 2px 3px $color-border
    background-color $color-gradually-gray-91

</style>
