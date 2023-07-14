// Composables
import { createRouter, createWebHistory } from "vue-router";
import Login from "@/views/Login";
import MyPage from "@/views/MyPage";
import Admin from "@/views/Admin";
import QuizList from "@/views/QuizList";
import Quiz from "@/views/Quiz";
import CreateAndEditQuiz from "@/views/createAndEditQuiz";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "Home",
        component: () =>
          import(/* webpackChunkName: "home" */ "@/views/Home.vue"),
      },
      {
        path: "/login",
        name: "Login",
        component: Login,
      },
      {
        path: "/mypage",
        name: "mypage",
        component: MyPage,
      },
      {
        path: "/admin",
        name: "admin",
        component: Admin,
      },
      {
        path: "/quizList",
        name: "quizList",
        component: QuizList,
      },
      {
        path: "/quiz",
        name: "quiz",
        component: Quiz,
      },
      {
        path: "/createAndEditQuiz",
        name: "createAndEditQuiz",
        component: CreateAndEditQuiz,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
