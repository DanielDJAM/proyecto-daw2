import { API_BASE_URL } from '../../globals';
import { Category } from "../../types/categoryType";
import axios from "axios";
import AuthService from "../user/authentication";

export const getAllCategories = async (): Promise<Array<Category>> => {
  const token = AuthService.getToken();
  return axios.get(API_BASE_URL + "/categories", {
    headers: {
      Authorization: token,
    },
  }).then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};

export default getAllCategories;