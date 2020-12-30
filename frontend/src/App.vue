<template>
  <div id="app">
    <div id="wrapper">
      <nav id="left">
        <CommonLeft/>
      </nav>
      <div id="page-wrapper" class="gray-bg">
      <div id="header">
        <CommonHeader/>
      </div>
      <router-view/>
      <div id="footer">
        <CommonFooter/>
      </div>
      </div>
    </div>
  </div>
</template>
<script>
import CommonLeft from '@/components/CommonLeft.vue'
import CommonHeader from '@/components/CommonHeader.vue'
import CommonFooter from '@/components/CommonFooter.vue'
export default {
  components: {
    CommonHeader,
    CommonFooter,
    CommonLeft
  }
}
</script>
<style>

</style>
