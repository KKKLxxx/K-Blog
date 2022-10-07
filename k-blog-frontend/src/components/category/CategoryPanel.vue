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
  padding 10px 20px

.top
  a
    padding 3px
    display block
    margin-bottom 3px

    .name
      color $color-gradually-gray-41
      font-size 16px
      display inline

      .num
        width 40px
        display inline-block
        float right
        font-size 15px
        background-color $color-gradually-gray-91
        text-align center

  &:hover
    box-shadow 2px 2px 3px $color-border
    background-color $color-gradually-gray-91

</style>
