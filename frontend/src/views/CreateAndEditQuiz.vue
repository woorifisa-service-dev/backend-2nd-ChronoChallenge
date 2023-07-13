<template>
  <form @submit.prevent="submit">
    <v-text-field
      v-model="title.value.value"
      :counter="100"
      :error-messages="title.errorMessage.value"
      label="title"
    ></v-text-field>

    <v-text-field
      v-for="num in 4"
      :key="num"
      v-model="answer[num - 1].value.value"
      :counter="100"
      :error-messages="
        () => {
          if (value?.length >= 2) return true;
          return 'Field needs to be at least 2 characters.';
        }
      "
      :label="`answer${num}`"
    ></v-text-field>
    <v-checkbox
      v-model="checkbox.value.value"
      :error-messages="checkbox.errorMessage.value"
      value="1"
      label="Active(활성화여부)"
      type="checkbox"
    ></v-checkbox>

    <v-btn class="me-4" type="submit"> submit </v-btn>

    <v-btn @click="handleReset"> clear </v-btn>
  </form>
</template>
<script setup>
import { useField, useForm } from "vee-validate";

const { handleSubmit, handleReset } = useForm({
  validationSchema: {
    title(value) {
      if (value?.length >= 2) return true;
      return "Field needs to be at least 2 characters.";
    },
  },
});
const title = useField("title");

const answer = [
  useField("answer1"),
  useField("answer2"),
  useField("answer3"),
  useField("answer4"),
];

const checkbox = useField("checkbox");

const submit = handleSubmit((values) => {
  const checkNullValue = Object.values(values)
    .slice(0, 4)
    .filter((v) => !v);
  if (checkNullValue.length > 0) {
    alert("필드를 다 채워주세요");
  }
});
</script>
