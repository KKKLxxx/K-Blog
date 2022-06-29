<template>
  <div class="main-wrapper">
    <SimpleHeader/>
    <router-view/>
    <CommonFooter/>
  </div>
</template>

<script>
import SimpleHeader from '@/components/header/SimpleHeader/SimpleHeader'
import CommonFooter from '@/components/footer/CommonFooter'

export default {
  components: {
    SimpleHeader,
    CommonFooter
  },
  data() {
    return {}
  },

  methods: {}
}

</script>

