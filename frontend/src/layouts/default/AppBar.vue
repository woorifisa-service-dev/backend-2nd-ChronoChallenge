<template>
  <v-app-bar flat>
    <v-app-bar-title @click="$router.push('/')" style="cursor: pointer">
      <v-icon icon="mdi-circle-slice-6" />
      Late Pass
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
      <v-btn outlined color="primary" @click="$router.push('/login')">
        Login
      </v-btn>
    </div>
  </v-app-bar>
</template>

<script setup>
import router from "@/router";
import { useCheckLogin } from "@/store/useCheckLogin";
import { useUserStore } from "@/store/useUserStore";
import axiosInstance from "@/utils/axiosInstance";
import loginCheck from "@/utils/loginCheck";

const userStore = useUserStore();
const isLogin = useCheckLogin();

const handleClickAccount = () => {
  userStore.user.authority ? router.push("/admin") : router.push("/mypage");
};

const handleClickLogout = async () => {
  try {
    const code = await loginCheck();
    isLogin.setIsLogin(code);
    if (isLogin.code) {
      await axiosInstance({
        url: "/auth/logout",
        method: "post",
      });
    }
    userStore.$reset();
    router.push("/login");
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
