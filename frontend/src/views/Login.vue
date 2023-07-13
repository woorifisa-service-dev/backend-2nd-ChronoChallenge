<template>
  <h1>Login</h1>
  <v-form @submit.prevent>
    <v-container style="width: 60%">
      <v-row style="flex-direction: column">
        <v-col cols="12" md="4" style="max-width: 100%">
          <v-text-field
            v-model="name"
            :rules="nameRules"
            :counter="10"
            label="Name"
            required
          ></v-text-field>
        </v-col>

        <v-col cols="12" md="4" style="max-width: 100%">
          <v-text-field
            v-model="password"
            :counter="10"
            label="Password"
            type="password"
            required
          ></v-text-field>
        </v-col>
      </v-row>
      <v-btn
        type="submit"
        block
        class="mt-2"
        style="padding: 30px 0; font-size: 20px"
        @click="handleClickLogin"
        >Login</v-btn
      >
    </v-container>
  </v-form>
</template>
<script setup>
import { ref } from "vue";
import axios, { AxiosError } from "axios";
import { useUserStore } from "@/store/useUserStore";

import router from "@/router";
const userStore = useUserStore();
const name = ref("");
const password = ref("");
const nameRules = [
  (value) => {
    if (value) return true;
    return "Name is required.";
  },
  (value) => {
    if (value?.length <= 10) return true;
    return "Name must be less than 10 characters.";
  },
];

const handleClickLogin = async () => {
  try {
    const { data } = await axios({
      url: "http://localhost:8080/auth/login",
      method: "post",
      headers: {
        "Content-Type": "application/json",
      },
      data: JSON.stringify({
        name: name.value,
        password: password.value,
      }),
    });
    userStore.setUser(data);
    router.push("/");
  } catch (error) {
    if (error instanceof AxiosError) {
      alert(error.response.data.message);
    }
  }
};
</script>
<style scoped>
h1 {
  text-align: center;
}

form {
  padding: 20px;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
