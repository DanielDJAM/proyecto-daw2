import { User } from "./userType";

export interface Product {
  productId?: string,
  name: string,
  stock: number,
  price: number,
  description: string,
  image: File,
  categories?: Array<Category>,
  userId?: number
}