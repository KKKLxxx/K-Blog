<template>
  <div class="title-menu-timeline">
    <ul class="list clearfix">
      <li v-for="menuFilter in filterList" :key="menuFilter.name">
        <a :class="menuFilter.active ? 'active' : ''" @click="filterByMenu(menuFilter.type)">{{ menuFilter.name }}</a>
      </li>
    </ul>
    <div class="refresh">
      <a @click="refresh" title="刷新">
        <iv-icon type="refresh" />
      </a>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      menuFilterList: [
        {
          name: '最新',
          type: 'orderByTime',
          active: true
        },
        {
          name: '访问最多',
          type: 'orderByReadCount',
          active: false
        },
        {
          name: '点赞最多',
          type: 'orderByLike',
          active: false
        },
        {
          name: '评论最多',
          type: 'orderByComment',
          active: false
        }
      ]
    }
  },
  computed: {
    filterList() {
      return this.menuFilterList
    }
  },
  methods: {
    refresh() {
      this.$router.go(0)
    },
    filterByMenu(type) {
      this.replaceActive(type)
      let param = {}
      param[type] = true
      this.$emit('filterByMenu', param)
    },
    replaceActive(type) {
      this.menuFilterList.map((menuFilter) => {
        menuFilter.active = menuFilter.type === type
      })
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus" scoped>
@import "../../common/stylus/theme.styl";

.title-menu-timeline
  display flex

  ul
    li
      float left
      margin 0 6px

      a
        padding 6px 0

        &:hover, &.active
          color $color-main-primary
          border-bottom 2px solid $color-main-primary

  .refresh
    margin-left 15px
    line-height inherit

    a
      font-size 20px
      color $color-gradually-gray-41
      cursor pointer

      &:hover
        color $color-main-primary

</style>
