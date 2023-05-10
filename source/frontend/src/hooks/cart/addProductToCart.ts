import axios from "axios";
import AuthService from "../user/authentication";
import { Cart, CartProduct } from "../../types/cartType";
import { Product } from "../../types/productType";
import { API_BASE_URL } from "../../globals";
import { getProductById } from "../product/getProductById";

export const saveCartToLocalStorage = (cart: Cart) => {
  localStorage.setItem('cart', JSON.stringify(cart));
}

export const getCartFromLocalStorage = (): Cart | null => {
  const cartJSON = localStorage.getItem('cart');

  if (cartJSON) {
    return JSON.parse(cartJSON);
  }

  return null;
}

const addProductToCart = async (productId: string, quantity: number = 1) => {
  let cart: Cart | null = getCartFromLocalStorage();
  if (!cart) {
    return;
  }

  try {
    const product = await getProductById(productId);

    const cartProductIndex = cart.cartProducts.findIndex(cp => cp.product.productId === product.productId);

    if (cartProductIndex !== -1) {
      cart.cartProducts[cartProductIndex].quantity += quantity;
    } else {
      const cartProduct: CartProduct = { product, quantity };
      cart.cartProducts.push(cartProduct);
    }

    cart.totalPrice += product.price * quantity;

    saveCartToLocalStorage(cart);
  } catch (error) {
    console.log(error);
  }
};

export const removeProductFromCart = async (productId: string) => {
  let cart: Cart | null = getCartFromLocalStorage();
  if (!cart) {
    return;
  }
  try {
    const product = await getProductById(productId);

    const cartProductIndex = cart.cartProducts.findIndex(cp => cp.product.productId === product.productId);

    if (cartProductIndex !== -1) {
      const cartProduct = cart.cartProducts[cartProductIndex];
      cart.totalPrice -= cartProduct.product.price * cartProduct.quantity;
      cart.cartProducts.splice(cartProductIndex, 1);
      saveCartToLocalStorage(cart);
    }
  } catch (error) {
    console.log(error);
  }
};

export const clearCart = () => {
  let cart: Cart | null = getCartFromLocalStorage();
  if (!cart) {
    return;
  }
  cart.cartProducts = [];
  cart.totalPrice = 0;
  saveCartToLocalStorage(cart);
}

const buyProductsFromCart = async (id: number) => {
  let cart: Cart | null = getCartFromLocalStorage();
  if (!cart) {
    return;
  }
  return await axios
    .post(API_BASE_URL + "/buyproducts", cart)
    .then((response) => {
      if (response.data.accessToken) {
        console.log(response);
        clearCart();
      }
      return response.data;
    });
}

const CartService = {
  addProductToCart,
  buyProductsFromCart,
  clearCart,
  removeProductFromCart
}

export default CartService;