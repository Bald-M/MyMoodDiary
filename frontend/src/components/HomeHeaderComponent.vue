<script setup lang="ts">
import { ref, onMounted, watch } from 'vue'
import { useRoute, useRouter } from 'vue-router'

// Create router instances
const route = useRoute()
const router = useRouter()
// Reactive current route name
const currentRoute = ref()

// Initialize current route on mount
onMounted(() => {
  currentRoute.value = route.name
})

// Watch for route changes
watch(route, (route, prevRoute) => {
  currentRoute.value = route.name
})

// Navigation handler
const goTo = (url: string) => {
  router.push(url)
}

</script>

<template>
  <div class="home-header-component-container">
    <!-- Application title -->
    <div>
      <p>My Mood Diary</p>
    </div>

    <!-- Navigation menu -->
    <div>
      <!-- Dynamic active class based on current route -->
      <p :class="{ active: currentRoute === 'home' }" @click="goTo('/home')">Home</p>
      <p :class="{ active: currentRoute === 'newDiary' }" @click="goTo('/newDiary')">New Diary</p>
      <p :class="{ active: currentRoute === 'moodData' }" @click="goTo('/moodData')">Mood Data</p>
    </div>
  </div>

</template>

<style scoped>
.home-header-component-container {
  background-color: #4860E8;
  padding: 0 10rem;
  display: flex;
  justify-content: space-between;
}

.home-header-component-container > :first-child {
  color: #CCD5F8;
  font-weight: bold;
}

.home-header-component-container > :last-child {
  display: flex;
  align-items: center;
}

.home-header-component-container > :last-child > p {
  margin: 0 1.25rem;
  color: #CCD5F8;
}

.home-header-component-container > :last-child > p:hover {
  color: #788BF6;
  cursor: pointer;
}

.active {
  border: 1px solid orange;
  border-radius: 5px;
  width: 100px;
  height: 30px;
  line-height: 30px;
  text-align: center;
  background-color: orange;
  color: white !important;
  font-weight: bold;
}

</style>