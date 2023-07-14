<template>
  <ul>
    <li v-for="quiz in quizList" :key="quiz.id">
      <QuizCard
        :setDialog="() => setDialog(quiz)"
        :isComplete="false"
        :quiz="quiz"
      />
    </li>
  </ul>
  <Modal :dialog="dialog" :setDialog="setDialog" :currentQuiz="currentQuiz" />
</template>

<script setup>
import Modal from "@/components/Modal.vue";
import { onBeforeMount, ref } from "vue";
import QuizCard from "@/components/QuizCard.vue";
import axiosInstance from "@/utils/axiosInstance";

const dialog = ref(false);
const currentQuiz = ref(0);
const quizList = ref([]);
const setDialog = (quiz) => {
  dialog.value = !dialog.value;
  currentQuiz.value = quiz;
};

onBeforeMount(async () => {
  const { data } = await axiosInstance.get("/quizs");
  quizList.value = data.filter((quiz) => quiz.status === "RESOLVED");
});
</script>

<style scoped>
ul {
  padding: 20px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
}

li {
  list-style: none;
}

.complete-quiz {
  background: lightgray;
}
.card-top {
  display: flex;
  justify-content: space-between;
}
</style>
