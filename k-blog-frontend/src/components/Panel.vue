<template>
  <div class="panel">
    <h3>{{ title }}</h3>
    <slot name="content" />
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  props: {
    title: ''
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
@import "../common/stylus/theme.styl";

.panel
  position relative
  background #fff
  border-left 1px solid $color-border

  h3
    font-size 21px
    font-weight bold
    padding 13px 20px 13px
    line-height 18px
    text-align left
    border-left 5px solid $default-link-hover-color
</style>
