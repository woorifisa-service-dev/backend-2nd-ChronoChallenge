import { BASE_URL } from "@/consts";
import axios from "axios";

const loginCheck = async () => {
  const { data } = await axios({
    url: `${BASE_URL}/auth/login_check`,
    method: "get",
  });
  return data.code;
};

export default loginCheck;
