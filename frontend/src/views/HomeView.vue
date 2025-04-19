<script setup lang="ts">
// Component imports
import Card from '@/components/CardComponent.vue'
import { useCardStore } from '@/stores/card'
import { computed, inject, onMounted } from 'vue'
import type { AxiosInstance } from 'axios'

// Axios instance injection
const axios: AxiosInstance = inject('$axios') as AxiosInstance
// State management setup
const cardStore = useCardStore()
const cards = computed(() => cardStore.cards)

// Fetch cards data on component mount
onMounted(() => {
  axios({
    url: '/api/moodCards',
    method: 'get'
  }).then(res => {
    console.log(res.data)
    cardStore.initCard(res.data)
  })
})


</script>

<template>
  <!-- Responsive grid container -->
  <div class="body-wrapper">
    <div v-for="card in cards" :key="card.id">
      <!-- Card iteration with data binding -->
      <Card :themeColour=card.themeColour :month=card.month :date=card.dayOfMonth :heading="card.heading" :content="card.content" :mood="card.mood" />
    </div>
  </div>

</template>

<style scoped>
.body-wrapper {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2.5rem;
}

@media (max-width: 1024px) {
  .body-wrapper {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 600px) {
  .body-wrapper {
    grid-template-columns: repeat(1, 1fr);
  }
}
</style>
