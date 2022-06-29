<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app',
  metaInfo: {
    title: 'K-Blog', // set a title
    meta: [
      {
        // set meta
        name: 'K-Blog',
        content: 'K-Blog，欢迎大家交流学习'
      }
    ],
    link: [
      {
        // set link
        rel: 'asstes',
        href: 'http://www.mfx.ink'
      }
    ]
  }
}
</script>

<style>
@import "assets/css/reset.css";
</style>
