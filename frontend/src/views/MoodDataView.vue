<script setup lang="ts">
// Vue reactivity imports
import { ref, computed } from 'vue'
// State management
import { useCardStore } from '@/stores/card'
// Initialize store
const cardStore = useCardStore()
// Create reactive variable month
const month = ref('JAN')

const monthOptions = ref([
  {
    id: 1,
    value: 'JAN',
    label: 'January'
  },
  {
    id: 2,
    value: 'FEB',
    label: 'February'
  },
  {
    id: 3,
    value: 'MAR',
    label: 'March'
  },
  {
    id: 4,
    value: 'APR',
    label: 'April'
  },
  {
    id: 5,
    value: 'MAY',
    label: 'May'
  },
  {
    id: 6,
    value: 'JUN',
    label: 'June'
  },
  {
    id: 7,
    value: 'JUL',
    label: 'July'
  },
  {
    id: 8,
    value: 'AUG',
    label: 'August'
  },
  {
    id: 9,
    value: 'SEP',
    label: 'September'
  },
  {
    id: 10,
    value: 'OCT',
    label: 'October'
  },
  {
    id: 11,
    value: 'NOV',
    label: 'November'
  },
  {
    id: 12,
    value: 'DEC',
    label: 'December'
  }
])

// Mood statistics calculation
const countMoodsByMonth = (moods: any[], month: string) => {
  // Filter and count moods for selected month
  return moods
    .filter(mood => mood.month === month)
    .reduce((acc: any, card) => {
      const { mood } = card
      acc[mood] = (acc[mood] || 0) + 1
      return acc
    }, {})
}


const currentMonthStats = computed(() => {
  return countMoodsByMonth(cardStore.cards, month.value)
})

// Mood counters
const happy = computed(() => currentMonthStats.value['face-laugh'] || 0)
const smile = computed(() => currentMonthStats.value['face-smile'] || 0)
const meh = computed(() => currentMonthStats.value['face-meh'] || 0)
const frown = computed(() => currentMonthStats.value['face-frown'] || 0)
const cry = computed(() => currentMonthStats.value['face-sad-cry'] || 0)

const handleMonthChange = () => {
  console.log('Selected month:', month.value)
  console.log(cardStore.cards)
}


</script>

<template>
  <div class="body-wrapper">
    <!-- Month selection section -->
    <div>
      <div>
        <el-select v-model="month" placeholder="Select" size="large" @change="handleMonthChange()">
          <!-- Loop month options from JAN to DEC -->
          <el-option v-for="item in monthOptions" :key="item.id" :label="item.label" :value="item.value" />
        </el-select>
      </div>

      <div>
        <el-text size="large">My mood of the month</el-text>
      </div>
    </div>

    <div class="statistic-wrapper">
      <!-- Mood statistic components -->
      <el-statistic title="Number of laughs" :value="happy">
        <template #suffix>
          <font-awesome-icon :icon="['fas', 'face-laugh']" class="icon" />
        </template>
      </el-statistic>

      <el-statistic title="Number of smiles" :value="smile">
        <template #suffix>
          <font-awesome-icon :icon="['fas', 'face-smile']" class="icon" />
        </template>
      </el-statistic>

      <el-statistic title="Number of mehs" :value="meh">
        <template #suffix>
          <font-awesome-icon :icon="['fas', 'face-meh']" class="icon" />
        </template>
      </el-statistic>

      <el-statistic title="Number of frowns" :value="frown">
        <template #suffix>
          <font-awesome-icon :icon="['fas', 'face-frown']" class="icon" />
        </template>
      </el-statistic>

      <el-statistic title="Number of crys" :value="cry">
        <template #suffix>
          <font-awesome-icon :icon="['fas', 'face-sad-cry']" class="icon" />
        </template>
      </el-statistic>
    </div>
  </div>
</template>

<style scoped>
.body-wrapper {
  width: 50rem;
}

.body-wrapper> :first-child {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 7rem;
}

.el-select {
  width: 10rem;
}

.statistic-wrapper {
  margin-top: 5rem;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
}
</style>