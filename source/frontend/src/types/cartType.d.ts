import { User } from "./userType";
import { Product } from "./productType";

export interface Cart {
  // userId: User,
  cartProducts: Array<CartProduct>,
  totalPrice: number
}

export interface CartProduct {
  product: Product,
  quantity: number
}