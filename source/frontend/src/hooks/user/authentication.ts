import axios from "axios";
import { API_BASE_URL } from "../../globals";
import { User } from "../../types/userType";

const signup = (
  user: User
) => {
  return axios
    .post(API_BASE_URL + "/auth/register", user)
    .then((response) => {
      if (response.data.accessToken) {
        setToken(JSON.stringify(response.headers.authorization));
      }
    });
};

const update = async (
  user: User
) => {
  const currentUser = await getToken();
  return await axios({
    method: "put",
    url: API_BASE_URL + "/update",
    headers: {
      Authorization: `Bearer ${currentUser.accessToken}`,
    },
    data: {
      user
    },
  })
    .then((response) => {
      if (response.headers.authorization) {        
        setToken(JSON.stringify(response.headers.authorization));
      }
      return response.data;
    });
};

const login = (email: string | undefined, password: string | undefined) => {
  return axios
    .post(API_BASE_URL + "/auth/login", {
      email,
      password,
    })
    .then((response) => {
      if (response.headers.authorization) {
        setToken(JSON.stringify(response.headers.authorization));
      }
    });
};

const logout = () => {
  localStorage.removeItem("token");
};

const getToken = () => {
  const token = localStorage.getItem("token");
  if (token) {
    return JSON.parse(token);
  }
  return null;
};

const setToken = (token: string) => {
  localStorage.setItem("token", token);
};

const AuthService = {
  signup,
  login,
  logout,
  getToken: getToken,
  update,
};

export default AuthService;