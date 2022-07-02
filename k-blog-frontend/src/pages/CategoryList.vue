<template>
  <div class="category-list">
    <iv-row>
      <iv-col :xs="24" :sm="24" :md="24" :lg="17">
        <div class="layout-left">
          <section-title :mainTitle="'分类'" :subTitle="'分类'"/>
          <iv-row>
            <iv-col v-for="category in categoryList" :key="category.id" span="8">
              <category-list-cell class="cell" :category="category"></category-list-cell>
            </iv-col>
          </iv-row>
        </div>
      </iv-col>
      <iv-col :xs="0" :sm="0" :md="0" :lg="7">
        <div class="layout-right">
          <recommend></recommend>
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">
import Recommend from '@/components/Recommend'
import CategoryListCell from '@/components/category/CategoryListCell'
import SectionTitle from '@/components/SectionTitle/SectionTitle'
import { getAll } from '@/api/category'

export default {
  components: {
    'recommend': Recommend,
    'category-list-cell': CategoryListCell,
    'section-title': SectionTitle
  },
  data() {
    return {
      categoryList: [
        {
          id: 1,
          name: '哈哈',
          count: 1
        },
        {
          id: 2,
          name: '呵呵',
          count: 1
        },
        {
          id: 3,
          name: '呃呃',
          count: 1
        }
      ]
    }
  },
  created() {
    this.listArticle()
  },
  methods: {
    listArticle() {
      getAll().then(response => {
        console.log(response)
        this.categoryList = response.data
      })
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.category-list
  width auto
  min-height calc(100vh - 308px)
  @media only screen and (max-width: 768px)
    margin 5px 5px 0 5px
  @media screen and (min-width: 768px)
    margin 10px 10px 0 10px
  @media screen and (min-width: 992px)
    margin 15px 35px 0 35px
  @media screen and (min-width: 1200px)
    width 1200px
    margin 15px auto 0
    margin-bottom 200px

  .layout-left, .layout-right
    padding 0
    @media only screen and (max-width: 768px)
      padding 0
    @media screen and (min-width: 768px)
      padding 0
    @media screen and (min-width: 992px)
      padding 0 10px
    @media screen and (min-width: 1200px)
      padding 0 10px

.cell {
  margin auto
  display table
}
</style>
