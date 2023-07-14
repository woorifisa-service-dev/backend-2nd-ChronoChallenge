import { defineStore } from "pinia";

export const useCheckLogin = defineStore("checkLogin", {
  state: () => {
    return {
      code: 0,
    };
  },
  actions: {
    setIsLogin(status) {
      this.code = status;
    },
  },
});
