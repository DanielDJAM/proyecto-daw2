import { User } from "./userType";

export interface Product {
  productId?: string,
  name: string,
  stock: number,
  price: number,
  description: string,
  image: string,
  userId: number
}