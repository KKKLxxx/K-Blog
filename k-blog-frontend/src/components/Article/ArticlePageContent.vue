<template>
<!--  强制刷新组件：https://kalacloud.com/blog/how-to-force-vue-to-re-render-component/#v-if-%E6%96%B9%E6%B3%95 -->
  <MarkdownPreview :initialValue="content" />
</template>

<script>
// vue-md使用指南：https://zhaoxuhui1122.github.io/vue-markdown-docs/
import { MarkdownPreview } from 'vue-meditor'

export default {
  components: {
    MarkdownPreview
  },
  props: {
    content: undefined
  }
}
</script>
