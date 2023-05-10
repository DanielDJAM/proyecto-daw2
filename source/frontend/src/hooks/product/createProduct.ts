import axios from "axios";
import AuthService from "../user/authentication";
import { API_BASE_URL } from "../../globals";
import { Product } from "../../types/productType";

const createProduct = async (
  product: Product
) => {
  const token = AuthService.getToken();
  return axios.post(API_BASE_URL + "/products", {
    headers: {
      Authorization: token,
    },
    data: {
      product
    },
  }).then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};

export default createProduct;