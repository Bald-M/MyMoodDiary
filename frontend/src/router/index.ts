import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/home',
      component: () => import('@/views/LayoutView.vue'),
      children: [
        {
          path: '/home',
          name: 'home',
          component: () => import('@/views/HomeView.vue')
        },
        {
          path: '/newDiary',
          name: 'newDiary',
          component: () => import('@/views/NewDiaryView.vue')
        },
        {
          path: '/moodData',
          name: 'moodData',
          component: () => import('@/views/MoodDataView.vue')
        }
      ]
    },
  ],
})

export default router
