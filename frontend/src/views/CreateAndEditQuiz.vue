<template>
  <form @submit.prevent="submit">
    <v-text-field
      v-model="question.value.value"
      :counter="100"
      :error-messages="question.errorMessage.value"
      label="question"
    ></v-text-field>

    <v-text-field
      v-model="answer.value.value"
      :counter="100"
      :error-messages="answer.errorMessage.value"
      label="answer"
      type="number"
    ></v-text-field>
    <v-text-field
      v-model="point.value.value"
      :counter="100"
      :error-messages="point.errorMessage.value"
      label="point"
      type="number"
    ></v-text-field>
    <v-text-field
      v-for="num in 4"
      :key="num"
      v-model="multipleCandidate[num - 1].value.value"
      :counter="100"
      :label="`multipleCandidate${num}`"
    ></v-text-field>
    <v-checkbox
      v-model="status.value.value"
      :error-messages="status.errorMessage.value"
      value="1"
      label="Active(활성화여부)"
      type="checkbox"
    ></v-checkbox>

    <v-btn class="me-4" type="submit"> submit</v-btn>

    <v-btn @click="handleReset"> clear</v-btn>
  </form>
</template>
<script setup>
import { useField, useForm } from "vee-validate";
import axiosInstance from "@/utils/axiosInstance";
import router from "@/router";
import { onBeforeMount } from "vue";
import { AxiosError } from "axios";

const {
  query: { id },
} = router.currentRoute.value;
const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    question(value) {
      if (value?.length >= 2) return true;
      return "Field needs to be at least 2 characters.";
    },
  },
});
const question = useField("question");
const answer = useField("answer");
const point = useField("point");
const multipleCandidate = [
  useField("multipleCandidate1"),
  useField("multipleCandidate2"),
  useField("multipleCandidate3"),
  useField("multipleCandidate4"),
];
const status = useField("status");

// 퀴즈 저장
const submit = handleSubmit(async (values) => {
  const checkNullValue = Object.values(values)
    .slice(0, Object.values(values).length - 1)
    .filter((v) => !v);
  if (checkNullValue.length > 0) {
    alert("필드를 다 채워주세요");
    return;
  }

  try {
    await axiosInstance({
      url: id ? `/quizs/${id}` : "/quizs/add",
      method: id ? "put" : "post",

      data: JSON.stringify({
        question: values.question,
        answer: values.answer,
        multipleCandidate1: values.multipleCandidate1,
        multipleCandidate2: values.multipleCandidate2,
        multipleCandidate3: values.multipleCandidate3,
        multipleCandidate4: values.multipleCandidate4,
        point: values.point,
        status: values.status ? "SUBMIT" : "WAIT",
      }),
    });
    router.push("/admin");
  } catch (error) {
    if (error instanceof AxiosError) {
      alert(error.response.data.message);
    }
  }
});
// 수정할 퀴즈 조회
onBeforeMount(async () => {
  try {
    if (id) {
      const { data } = await axiosInstance.get(`/quizs/${id}`);
      question.setValue(data.question);
      answer.setValue(data.answer);
      point.setValue(data.point);
      multipleCandidate[0].setValue(data.multipleCandidate1);
      multipleCandidate[1].setValue(data.multipleCandidate2);
      multipleCandidate[2].setValue(data.multipleCandidate3);
      multipleCandidate[3].setValue(data.multipleCandidate4);
      status.setValue(data.status === "SUBMIT" ? true : false);
    }
  } catch (error) {
    console.log(error);
  }
});
</script>
