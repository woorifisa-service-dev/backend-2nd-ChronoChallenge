<template>
  <v-app-bar flat>
    <v-app-bar-title>
      <router-link to="/">
        <v-icon icon="mdi-circle-slice-6" />
        Late Pass
      </router-link>
    </v-app-bar-title>
    <div class="user-box" v-if="userStore.user.name">
      <span> {{ userStore.user.name }} 님 </span>
      <v-btn
        icon="mdi-account"
        size="x-small"
        @click="handleClickAccount"
      ></v-btn>
      <v-btn outlined @click="handleClickLogout"> Logout </v-btn>
    </div>
    <div class="user-box" v-else>
      <v-btn outlined color="primary">
        <router-link to="/login">Login</router-link>
      </v-btn>
    </div>
  </v-app-bar>
</template>

<script setup>
import router from "@/router";
import { useUserStore } from "@/store/useUserStore";
import axios from "axios";
import { ref } from "vue";

const userStore = useUserStore();
const isTeacher = ref(false);

const handleClickAccount = () => {
  isTeacher ? router.push("/admin") : router.push("/mypage");
};

const handleClickLogout = async () => {
  try {
    await axios({
      url: "http://localhost:8080/auth/logout",
      method: "post",
    });
    userStore.resetUser();
  } catch (error) {
    console.log(error);
  }
};
</script>

<style scoped>
.user-box {
  display: flex;
  align-items: center;
}
</style>
