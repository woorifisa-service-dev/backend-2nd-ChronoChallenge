<template>
  <v-card
    class="mx-auto"
    width="100%"
    min-width="300"
    :class="{ 'complete-quiz': isComplete }"
  >
    <v-card-text>
      <span> 📝 2023-07-12</span>
      <span> 🪙 30 </span>
      <p class="text-h5 text--primary">{{ props.quiz.question }}</p>
    </v-card-text>
    <v-card-actions>
      <v-btn
        variant="text"
        color="deep-purple-accent-4"
        @click="props.setDialog"
      >
        문제풀기
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup>
const props = defineProps({
  setDialog: Function,
  isComplete: Boolean,
  quiz: Object,
});
</script>
