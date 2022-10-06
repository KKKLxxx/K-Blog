<template>
<!--  强制刷新组件：https://kalacloud.com/blog/how-to-force-vue-to-re-render-component/#v-if-%E6%96%B9%E6%B3%95 -->
  <viewer v-if="content" :initialValue="content"  />
</template>

<script>
// tui使用指南：https://github.com/nhn/tui.editor/tree/master/apps/vue-editor
import '@toast-ui/editor/dist/toastui-editor-viewer.css'
import { Viewer } from '@toast-ui/vue-editor'

export default {
  components: {
    viewer: Viewer
  },
  props: {
    content: undefined
  }
}
</script>

<!--
<style lang="stylus" rel="stylesheet/stylus">
@import "../../common/stylus/article.styl";

#article-page-content
  padding 55px
</style>
-->
