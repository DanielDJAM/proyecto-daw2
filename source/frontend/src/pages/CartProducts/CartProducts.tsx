import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../../hooks/user/authentication";
import Loader from "../../components/Loader/Loader";
import StatusAlert from "../../components/StatusAlert/StatusAlert";
import { Cart } from "../../types/cartType";
import CartService from "../../hooks/cart/addProductToCart"
import DeleteButtonCart from "../../components/DeleteButtonFromCart/DeleteButtonFromCart";
import AddButtonToCart from "../../components/AddButtonToCart/AddButtonToCart";

interface AppState {
  cart: Cart;
}

const CartProducts = () => {
  const [cart, setCart] = useState<AppState["cart"]>();
  const [loading, setLoading] = useState<boolean>();

  useEffect(() => {
    setLoading(true);
    CartService.getCartFromLocalStorage().then(response => {
      setCart(response ? response : undefined);
      setLoading(false);
    });
  }, []);

  const [errorLogIn, setErrorLogIn] = useState("");
  const navigate = useNavigate();

  const handleBuyProducts = async () => {
    try {
      await CartService.buyProductsFromCart().then(
        () => {
          navigate("/");
          window.location.reload();
        },
        (error: any) => {
          setErrorLogIn("Error al comprar productos del carrito");
        }
      );
    } catch (err) {
      console.log(err);
    }
  };

  const handleClearCart = async () => {
    try {
      await CartService.clearCart().then(
        () => {
          navigate("/");
          window.location.reload();
        },
        (error: any) => {
          setErrorLogIn("Error al vaciar productos del carrito");
        }
      );
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <main className="container">
      <h1>Carrito de la compra</h1>
      {loading ? <Loader /> :
        cart ? (
          cart.cartProducts.length > 0 ? (
            <><table className="table table-striped">
              <thead>
                <tr>
                  <th scope="col">Producto</th>
                  <th scope="col">Cantidad</th>
                  <th scope="col">Precio</th>
                  <th scope="col">Total</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody>
                {cart.cartProducts.map((cartProduct) => (
                  <tr key={cartProduct.product.productId}>
                    <td>{cartProduct.product.name}</td>
                    <td>{cartProduct.quantity}</td>
                    <td>{cartProduct.product.price}</td>
                    <td>{cartProduct.quantity * cartProduct.product.price}</td>
                    <td>
                      <AddButtonToCart id={cartProduct.product.productId} />
                    </td>
                    <td>
                      <DeleteButtonCart id={cartProduct.product.productId} />
                    </td>
                  </tr>
                ))}
                <tr>
                  <td colSpan={6}>Total: {cart.totalPrice.toFixed(2)}</td>
                </tr>
              </tbody>
            </table>
              <button className="btn btn-danger" onClick={() => handleClearCart()} >
                <i className="bi bi-cart-x-fill"></i> Limpiar carrito
              </button>
              <button className="btn btn-success" onClick={() => handleBuyProducts()} >
                <i className="bi bi-cart-check-fill"></i> Comprar productos
              </button>
            </>
          ) : (
            <StatusAlert statusClass="alert-warning" statusDescription="El carrito de copmpra está vacío" />
          )
        ) : (
          <StatusAlert statusClass="alert-danger" statusDescription="No se ha podido obtener el carrito de compra" />
        )
      }
    </main>
  );
};

export default CartProducts;