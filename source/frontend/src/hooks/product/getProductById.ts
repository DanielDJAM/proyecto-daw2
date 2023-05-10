import { API_BASE_URL } from "../../globals";
import { Product } from "../../types/productType";
import axios from "axios";

// export const getProductById = (id: string | undefined) => {
//   return fetchProduct(id).then(mapFromApiToProduct);
// };

export const getProductById = (
  id: string | undefined
): Promise<Product> => {
  return axios
    .get(API_BASE_URL + `/products/${id}`)
    .then((response) => response.data)
    .catch((error) => {
      console.log(error);
    });
};

// export const mapFromApiToProduct = (
//   apiResponse: ProductResponseFromApiObject
// ): Product => {
//   const {
//     _id: id,
//     name,
//     description: desc,
//     price,
//     image,
//     ingredients: ingrs,
//     category: categ,
//   } = apiResponse;
//   return {
//     id,
//     name,
//     desc,
//     price,
//     image,
//     categ,
//     ingrs,
//   };
// };