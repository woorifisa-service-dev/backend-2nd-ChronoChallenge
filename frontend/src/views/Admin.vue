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
        <th class="text-center">Edit</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(quiz,idx) in quizList" :key="quiz.id">
        <td class="text-center">{{ idx + 1 }}</td>
        <td>
          {{
            quiz.question
          }}
        </td>

        <td class="text-center">{{ new Date(quiz.createdAt).toLocaleDateString() }}</td>
        <td class="text-center">{{new Date( quiz.modifiedAt).toLocaleDateString()}}</td>
        <td class="text-center">{{quiz.status}}</td>
        <td align="center">
          <v-btn @click="() => handleClickToEditQuiz(quiz.id)">Edit</v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import router from "@/router";
import {onBeforeMount, ref} from "vue";
import axios from "axios";

const quizList = ref([]);

onBeforeMount(async () => {
  const { data } = await axios({
    url: "http://localhost:8080/quizs",
  });
  quizList.value = data;
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
