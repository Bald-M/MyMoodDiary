<!-- Main layout component containing header and content area -->
<script setup lang="ts">
// Import header component
import Header from '@/components/HomeHeaderComponent.vue'
</script>

<template>
  <!-- Root layout container -->
  <div>
    <!-- Root layout container -->
    <Header />
    <!-- Content wrapper for route components -->
    <div class="body-wrapper-container">
      <!-- Dynamic content area based on current route -->
      <RouterView />
    </div>
  </div>

</template>

<style scoped>
.body-wrapper-container {
  display: flex;
  justify-content: center;
  padding-top: 2rem;
}
</style>