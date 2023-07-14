import { BASE_URL } from "@/consts";
import axios from "axios";

const axiosInstance = axios.create({
  baseURL: BASE_URL,
  withCredentials: true,
  headers: {
    "Content-Type": "application/json",
  },
});

axiosInstance.interceptors.request.use(async function (config) {
  return config;
});
axiosInstance.interceptors.response.use(function (response) {
  return response;
});
export default axiosInstance;
