import { defineStore } from "pinia";

const initialUser = {
  id: 0,
  name: "",
  authority: false,
};
export const useUserStore = defineStore("user", {
  state: () => {
    return {
      user: { ...initialUser },
    };
  },
  actions: {
    setUser(userData) {
      this.user = userData;
    },
  },
  persist: {
    enabled: true,
  },
});
