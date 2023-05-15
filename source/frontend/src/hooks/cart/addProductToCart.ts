import axios from "axios";
import AuthService from "../user/authentication";
import { Cart, CartProduct } from "../../types/cartType";
import { Product } from "../../types/productType";
import { API_BASE_URL } from "../../globals";
import { getProductById } from "../product/getProductById";

const saveCartToLocalStorage = (cart: Cart) => {
  localStorage.setItem('cart', JSON.stringify(cart));
}

export const getCartFromLocalStorage = async (): Promise<Cart> => {
  const cartJSON = localStorage.getItem('cart');

  if (cartJSON) {
    return JSON.parse(cartJSON);
  }

  return {
    cartProducts: [],
    totalPrice: 0
  };
}

const addProductToCart = async (productId: string, quantity: number = 1) => {
  let cart: Cart = await getCartFromLocalStorage();

  try {
    const product = await getProductById(productId);
    console.log(product)
    const cartProductIndex = cart.cartProducts.findIndex(cp => cp.product.productId === product.productId);

    if (cartProductIndex !== -1) {
      cart.cartProducts[cartProductIndex].quantity += quantity;
    } else {
      const cartProduct: CartProduct = { product, quantity };
      cart.cartProducts.push(cartProduct);
    }

    cart.totalPrice += product.price * quantity;
    console.log(cart)

    saveCartToLocalStorage(cart);
  } catch (error) {
    console.log(error);
  }
};

const removeProductFromCart = async (productId: string) => {
  let cart: Cart = await getCartFromLocalStorage();
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

const clearCart = async () => {
  let cart: Cart = await getCartFromLocalStorage();
  if (!cart) {
    return;
  }
  cart.cartProducts = [];
  cart.totalPrice = 0;
  saveCartToLocalStorage(cart);
}

const buyProductsFromCart = async () => {
  let cart: Cart = await getCartFromLocalStorage();
  if (!cart) {
    return;
  }
  return await axios
    .post(API_BASE_URL + "/buyproducts", cart)
    .then((response) => {
      if (response.data.accessToken) {
        clearCart();
      }
      return response.data;
    });
}

const CartService = {
  getCartFromLocalStorage,
  addProductToCart,
  buyProductsFromCart,
  clearCart,
  removeProductFromCart
}

export default CartService;