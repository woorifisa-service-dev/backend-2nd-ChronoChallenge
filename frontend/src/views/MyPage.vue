<template>
  <section>
    <h2>{{ userData.name }} 님 안녕하세요</h2>
    <ul class="info-list">
      <li>
        <h5>포인트</h5>
        <p>{{ userData.point }}</p>
      </li>
      <li>
        <h5>지각 면제권</h5>
        <p>{{ userData.passTicket }}</p>
      </li>
    </ul>
  </section>
</template>

<script setup>
import { useUserStore } from "@/store/useUserStore";
import { onBeforeMount, ref } from "vue";
import axiosInstance from "@/utils/axiosInstance";
import { useCheckLogin } from "@/store/useCheckLogin";
import router from "@/router";

const userStore = useUserStore();
const isLogin = useCheckLogin();
const userData = ref({});
onBeforeMount(async () => {
  if (isLogin.code === 0) {
    alert("로그인 상태가 아닙니다.");
    router.push("/login");
    return;
  }
  const { data } = await axiosInstance.get(`/member/${userStore.user.id}`);
  userData.value = { ...data };
});
</script>

<style scoped>
section {
  padding: 20px;
}

.info-list {
  display: flex;
  width: 100%;
  justify-content: space-between;
  margin: 20px 0;
}

li {
  list-style: none;
  text-align: center;
  width: calc(100% / 2);
}

li + li {
  border-left: 1px solid #000;
}

li h5 {
  font-size: 20px;
}
</style>
