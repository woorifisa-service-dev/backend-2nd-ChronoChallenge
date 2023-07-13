import { defineStore } from "pinia";

const initialUser = {
  id: 0,
  name: "",
  authority:0
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
    resetUser() {
      this.user = { ...initialUser };
    },
  },
  persist: {
    enabled: true,
  },
});
