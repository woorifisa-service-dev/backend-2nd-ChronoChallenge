<template>
  <v-card
    class="mx-auto"
    width="100%"
    min-width="300"
    :class="{ 'complete-quiz': isComplete }"
  >
    <v-card-text>
      <span> 📝 {{ new Date(quiz.createdAt).toLocaleDateString() }}</span>
      <span> 🪙 {{ quiz.point }} </span>
      <p class="text-h5 text--primary">{{ props.quiz.question }}</p>
    </v-card-text>
    <v-card-actions>
      <v-btn
        variant="text"
        color="deep-purple-accent-4"
        @click="props.setDialog"
      >
        문제보기
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
