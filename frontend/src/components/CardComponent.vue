<script setup lang="ts">
// Component props definition
defineProps<{
  themeColour?: string
  month: string
  date: string
  mood?: string
  heading?: string
  content?: string
}>()

</script>

<template>
  <!-- Main card container with dynamic theme color -->
  <div class="card-component-container" :style="{ '--theme-colour': themeColour }">
    <!-- Top section containing date and mood icon -->
    <div>
      <div class="date-wrapper">
        <div>
          <div>{{ month }}</div>
          <div>{{ date }}</div>
        </div>
      </div>
      <!-- Mood icon display -->
      <div class="mood-wrapper">
        <font-awesome-icon :icon="['fas', mood]" class="icon" />
      </div>
    </div>
    <!-- Card title section -->
    <div class="heading-wrapper">
      <div>{{ heading }}</div>
    </div>
    <!-- Diary content section -->
    <div class="content-wrapper">
      <div>{{ content }}</div>
    </div>
  </div>
</template>

<style scoped>
.card-component-container {
  border: 3px solid var(--theme-colour);
  border-radius: 8px;
  padding: 1.25rem;
  width: 400px;
  height: 400px;
}

.card-component-container> :first-child {
  display: flex;
  justify-content: center;
  gap: 2.5rem;
}

.card-component-container:hover .delete-btn {
  opacity: 1;
  right: -14px;
  top: -14px;
}

.date-wrapper {
  border: 3px solid var(--theme-colour);
  border-radius: 8px;
  background-color: var(--theme-colour);
  width: 100px;
  height: 100px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.date-wrapper>div> :first-child {
  color: white;
  font-size: 1rem;
}

.date-wrapper>div> :last-child {
  color: white;
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
}

.mood-wrapper {
  display: flex;
  align-items: center;
}

.icon {
  width: 80px;
  height: 80px;
  color: var(--theme-colour);
}

.heading-wrapper {
  margin-top: 5rem;
  height: 3.75rem;
}

.heading-wrapper>div {
  font-weight: bold;
  font-size: 1.5rem;
  text-align: center;
}

.content-wrapper {
  margin-top: 2rem;
  font-size: 1rem;
  text-align: center;
}
</style>