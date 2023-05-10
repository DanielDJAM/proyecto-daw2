import axios from "axios";
import { API_BASE_URL } from "../../globals";
import { User } from "../../types/userType";
import AuthService from "../user/authentication";

export const getAllUsers = (): Promise<Array<User>> => {
  const token = AuthService.getToken();
  return axios.get(API_BASE_URL + "/users", {
    headers: {
      Authorization: token,
    },
  }).then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};