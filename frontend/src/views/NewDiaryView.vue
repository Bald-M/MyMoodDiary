<script setup lang="ts">
import { ref, reactive, inject } from 'vue'
import { useRouter } from 'vue-router'
import type { AxiosInstance } from 'axios'
import type { FormProps } from 'element-plus'
import { ElMessage } from 'element-plus'

// Initialize router and axios
const router = useRouter()
const axios: AxiosInstance = inject('$axios') as AxiosInstance
const labelPosition = ref<FormProps['labelPosition']>('top')

// Reactive form data model
const form = reactive({
  date: '',
  mood: '',
  themeColour: '',
  heading: '',
  content: ''
})

// Mood icon selection options
const moodIconOptions = [
  {
    id: 1,
    value: 'face-laugh',
    icon: 'face-laugh'
  },
  {
    id: 2,
    value: 'face-smile',
    icon: 'face-smile'
  },
  {
    id: 3,
    value: 'face-meh',
    icon: 'face-meh'
  },
  {
    id: 4,
    value: 'face-frown',
    icon: 'face-frown'
  },
  {
    id: 5,
    value: 'face-sad-cry',
    icon: 'face-sad-cry'
  }
]


// Inspiration prompt options
const moodOptions = ref([
  {
    id: 1,
    value: 'What did I accomplish today?',
    label: 'What did I accomplish today?',
  },
  {
    id: 2,
    value: 'Did I work out today?',
    label: 'Did I work out today?',
  },
  {
    id: 3,
    value: 'What did I learn today?',
    label: 'What did I learn today?',
  },
  {
    id: 4,
    value: 'What\'s my growth lesson today?',
    label: 'What\'s my growth lesson today?',
  }
])

// Form submission handler
const handleSubmit = (card: any) => {
  // Process date into month/day format
  const month = new Date(card.date).toString().split(' ')[1].toUpperCase()
  const dayOfMonth = new Date(card.date).getDate().toString()
  // Submit data to API endpoint
  axios({
    url: '/api/moodCards',
    method: 'post',
    data: {
      month,
      dayOfMonth,
      themeColour: card.themeColour,
      mood: card.mood,
      heading: card.heading,
      content: card.content,
    },
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(res => {
    console.log(res)
    // Success notification
    ElMessage.success('Congrats, new diary added.')
    // Redirect to home after submitting successfully
    router.push('/')
  })
}

</script>

<template>
  <div class="body-wrapper">
    <el-form :model="form" :label-position="labelPosition" style="width: 100%;">
      <!-- Date picker section -->
      <el-form-item label="Choose the date to record your mood!">
        <el-date-picker v-model="form.date" placeholder="Please pick a date" style="width: 100%;" />
      </el-form-item>

      <!-- Theme color input -->
      <el-form-item label="What's your favourite colour?">
        <el-input v-model="form.themeColour" placeholder="Please input" />
      </el-form-item>

      <!-- Mood selection with icons -->
      <el-form-item label="How are you feeling on this day?">
        <el-segmented v-model="form.mood" :options="moodIconOptions" size="large">
          <template #default="scope">
            <div>
              <font-awesome-icon :icon="['fas', scope.item.icon]" class="icon" />
            </div>
          </template>
        </el-segmented>
      </el-form-item>

      <!-- Inspiration prompt selection -->
      <el-form-item label="Choose an inspiration to record your mood">
        <el-select v-model="form.heading">
          <el-option v-for="mood in moodOptions" :key="mood.id" :label="mood.label" :value="mood.value" />
        </el-select>
      </el-form-item>

      <!-- Diary content input -->
      <el-form-item>
        <el-input v-model="form.content" :rows="5" type="textarea" placeholder="Let's start writting..." />
      </el-form-item>

      <!-- Submission button -->
      <el-form-item>
        <el-button type="primary" size="large" @click="handleSubmit(form)">Submit</el-button>
      </el-form-item>

    </el-form>
  </div>

</template>

<style scoped>
.body-wrapper {
  width: 50rem;
}
</style>
