<template>
  <div v-if="quiz.id !== 0">
    <v-card class="mx-auto" width="80%" min-width="300">
      <v-card-text style="font-size: 20px">
        <p class="question">{{ quiz.question }}</p>
      </v-card-text>
      <v-container fluid>
        <v-radio-group v-model="radios" row>
          <v-radio :value="1">
            <template v-slot:label>
              <div>
                {{ quiz.multipleCandidate1 }}
              </div>
            </template>
          </v-radio>
          <v-radio :value="2">
            <template v-slot:label>
              <div>
                {{ quiz.multipleCandidate2 }}
              </div>
            </template>
          </v-radio>
          <v-radio :value="3">
            <template v-slot:label>
              <div>
                {{ quiz.multipleCandidate3 }}
              </div>
            </template>
          </v-radio>
          <v-radio :value="4">
            <template v-slot:label>
              <div>
                {{ quiz.multipleCandidate4 }}
              </div>
            </template>
          </v-radio>
        </v-radio-group>
      </v-container>
      <v-card-actions style="display: flex; justify-content: end">
        <v-btn
          style="color: #fff; background-color: #2d4356"
          @click="submitAnswer"
        >
          정답제출
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import { onBeforeMount, ref } from "vue";
import axiosInstance from "@/utils/axiosInstance";
import { AxiosError } from "axios";
import { useUserStore } from "@/store/useUserStore";
import router from "@/router";

const userStore = useUserStore();
const radios = ref("");
const quiz = ref({
  id: 0,
  question: "",
  answer: 0,
  multipleCandidate1: "",
  multipleCandidate2: "",
  multipleCandidate3: "",
  multipleCandidate4: "  ",
  // 필요한 다른 필드들을 추가할 수 있습니다.
});

const message = ref("");
const code = ref(-1);

const fetchQuiz = async () => {
  try {
    const { data } = await axiosInstance.get("/quizs/submit");
    quiz.value = {
      id: data[0].id,
      question: data[0].question,
      answer: data[0].answer,
      multipleCandidate1: data[0].multipleCandidate1,
      multipleCandidate2: data[0].multipleCandidate2,
      multipleCandidate3: data[0].multipleCandidate3,
      multipleCandidate4: data[0].multipleCandidate4,
    };
  } catch (error) {
    if (error instanceof AxiosError) {
      alert(error.response.data.message);
    }
  }
  if (quiz.value.id === 0) {
    alert("활성화된 문제가 없습니다.");
    router.push("/");
  }
};

onBeforeMount(fetchQuiz);

const submitAnswer = async () => {
  if (userStore.user.authority) {
    alert("관리자는 문제를 풀 수 없습니다.");
    return;
  }
  if (!quiz.value.id) {
    alert("오류: ID가 유효하지 않습니다.");
    return;
  }

  try {
    const { data } = await axiosInstance({
      url: `/quizs/${quiz.value.id}/answer`,
      method: "post",
      data: JSON.stringify({
        id: userStore.user.id,
        answer: radios.value, // 현재 선택된 radio의 값
      }),
    });
    message.value = data.message;
    code.value = data.code;
  } catch (error) {
    if (error instanceof AxiosError) {
      alert(error.response.data.message);
    }
  }

  alert(message.value);
  router.push("/");
};
</script>

<style scoped>
.question {
  font-size: 30px;
  font-weight: 600;
  padding: 20px 0;
}
</style>
