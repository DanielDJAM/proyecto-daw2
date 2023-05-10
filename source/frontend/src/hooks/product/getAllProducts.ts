import { API_BASE_URL } from '../../globals';
import { Product } from "../../types/productType";
import axios from "axios";
import AuthService from "../user/authentication";

export const getAllProducts = (): Promise<Array<Product>> => {
  const token = AuthService.getToken();
  return axios.get(API_BASE_URL + "/products", {
    headers: {
      Authorization: token,
    },
  }).then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};