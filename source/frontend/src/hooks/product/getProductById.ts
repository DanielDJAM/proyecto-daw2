import { API_BASE_URL } from "../../globals";
import AuthService from "../user/authentication";
import { Product } from "../../types/productType";
import axios from "axios";

export const getProductById = (
  id: string | undefined
): Promise<Product> => {
  const token = AuthService.getToken();
  return axios
    .get(API_BASE_URL + `/products/${id}`, {
      headers: {
        Authorization: token,
      },
    })
    .then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};