<template>
  <div class="create-quiz-btn">
    <v-btn
      style="background-color: #2d4356; color: #fff; width: 70%"
      size="x-large"
      @click="handleClickToCreateQuiz"
      >퀴즈 만들기</v-btn
    >
  </div>
  <h2>퀴즈</h2>
  <v-table>
    <thead>
      <tr>
        <th class="text-center">No.</th>
        <th class="text-center">Question</th>
        <th class="text-center">Created At</th>
        <th class="text-center">Modified At</th>
        <th class="text-center">Status</th>
        <th class="text-center">Answer Member</th>
        <th class="text-center">Edit</th>
        <th class="text-center">Delete</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(quiz, idx) in quizList" :key="quiz.id">
        <td class="text-center">{{ idx + 1 }}</td>
        <td class="text-center">
          {{ quiz.question }}
        </td>

        <td class="text-center">
          {{
            new Date(quiz.createdAt).toLocaleDateString() +
            " " +
            new Date(quiz.createdAt).toLocaleTimeString()
          }}
        </td>
        <td class="text-center">
          {{
            new Date(quiz.modifiedAt).toLocaleDateString() +
            " " +
            new Date(quiz.modifiedAt).toLocaleTimeString()
          }}
        </td>
        <td class="text-center">{{ quiz.status }}</td>
        <td class="text-center">
          {{ quiz.answerMember ? quiz.answerMember.name : "" }}
        </td>
        <td align="center">
          <v-btn @click="() => handleClickToEditQuiz(quiz.id)">Edit</v-btn>
        </td>
        <td align="center">
          <v-btn @click="() => handleClickToDeleteQuiz(quiz.id)">Delete</v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import router from "@/router";
import { onBeforeMount, ref } from "vue";
import axiosInstance from "@/utils/axiosInstance";

const quizList = ref([]);
const getQuizList = async () => {
  const { data } = await axiosInstance.get("/quizs");
  quizList.value = data;
};

onBeforeMount(async () => {
  await getQuizList();
});

const handleClickToCreateQuiz = () => {
  router.push("/createAndEditQuiz");
};
const handleClickToEditQuiz = (id) => {
  router.push({
    path: "/createAndEditQuiz",
    query: {
      id,
    },
  });
};
const handleClickToDeleteQuiz = async (id) => {
  try {
    await axiosInstance.delete(`/quizs/${id}`);
    await getQuizList();
  } catch (error) {
    console.log(error);
  }
};
</script>

<style scoped>
h2 {
  text-align: center;
}
.create-quiz-btn {
  display: flex;
  justify-content: center;
  margin: 40px 0;
}
</style>
