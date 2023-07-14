<template>
  <router-view />
</template>

<script setup>
import { onBeforeMount } from "vue";
import router from "./router";
import loginCheck from "./utils/loginCheck";
import { useCheckLogin } from "@/store/useCheckLogin";
import { useUserStore } from "./store/useUserStore";

const isLogin = useCheckLogin();
const userStore = useUserStore();
onBeforeMount(async () => {
  const code = await loginCheck();
  if (code === 0 && sessionStorage.getItem("user")) {
    router.push("/");
    userStore.$reset();
  }
  isLogin.setIsLogin(code);
});
</script>
