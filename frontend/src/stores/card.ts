import { ref } from 'vue'
import { defineStore } from 'pinia'

// Type definition for Mood Card
interface Card {
  id: number
  month: string
  dayOfMonth: string
  themeColour?: string
  mood?: string
  heading?: string
  content?: string
}

// Pinia store for managing mood cards
export const useCardStore = defineStore('card', () => {
  // Reactive array of cards with demo data
  const cards = ref(<Card[]>[
    {
      id: 1,
      themeColour: 'Blue',
      month: 'JAN',
      dayOfMonth: '21',
      mood: 'face-laugh',
      heading: 'You can say anything here',
      content: 'I am happy today, I learned a new frontend framework - Vuejs ...',
    },
  ])

  // Initialize cards with new data
  const initCard = (newCards: Card[]) => {
    cards.value = newCards
  }

  // Expose state and methods
  return { cards, initCard }
})