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
        <th class="text-center">Quiz Title</th>
        <th class="text-center">Created At</th>
        <th class="text-center">Last Modified At</th>
        <th class="text-center">Active</th>
        <th class="text-center">Complete Status</th>
        <th class="text-center">Edit</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in 3" :key="item">
        <td class="text-center">{{ item }}</td>
        <td>
          {{
            item === 1 &&
            `Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta
          similique excepturi molestias quidem praesentium, blanditiis commodi
          magni accusantium dignissimos quas. Similique repellat ratione
          pariatur unde atque, dicta harum officiis sed.`
          }}
        </td>
        <td class="text-center">{{ item }}</td>
        <td class="text-center">{{ item }}</td>
        <td class="text-center">{{ item }}</td>
        <td class="text-center">{{ item }}</td>
        <td class="text-center">
          <v-btn @click="() => handleClickToEditQuiz(item)">Edit</v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<script setup>
import router from "@/router";

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
