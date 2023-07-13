<template>
  <section>
    <ul>
      <li>
        <v-btn color="main" width="300" height="200" @click="handleClickGoQuiz"
          >퀴즈 풀기</v-btn
        >
      </li>
      <li>
        <v-btn
          color="main"
          width="300"
          height="200"
          @click="handleClickGoQuizList"
        >
          지난 퀴즈 보러가기</v-btn
        >
      </li>
    </ul>
  </section>
</template>

<script setup>
import router from "@/router";
import VueCookies from "vue-cookies";

const handleClickGoQuiz = () => {
  router.push("/quiz");
};
const handleClickGoQuizList = () => {
  router.push("/quizList");
};
</script>

<style scoped>
section {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
ul {
  display: flex;
  gap: 50px;
}
li {
  display: flex;
  align-items: center;
  list-style: none;
}
li button {
  font-size: 25px;
  font-weight: 600;
  color: #fff;
}
</style>
