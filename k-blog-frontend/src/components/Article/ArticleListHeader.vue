<template>
  <div class="article-list-header">
    <section-title :mainTitle="mainTitle" :subTitle="subTitle">
      <title-menu-filter @filterByMenu="filterByMenu" slot="menu"></title-menu-filter>
    </section-title>
  </div>
</template>

<script type="text/ecmascript-6">
import SectionTitle from '@/components/SectionTitle/SectionTitle'
import TitleMenuFilter from '@/components/SectionTitle/TitleMenuFilter'

export default {
  data () {
    return {
      categoryParam: {}
    }
  },
  components: {
    'section-title': SectionTitle,
    'title-menu-filter': TitleMenuFilter
  },
  props: {
    categorys: Array,
    defaultCategory: '',
    mainTitle: '',
    subTitle: ''
  },
  methods: {
    filterByMenu (params) {
      this.$emit('filterByMenu', params)
    },
    filterByCategory (params) {
      this.$emit('filterByCategory', params)
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">

</style>
