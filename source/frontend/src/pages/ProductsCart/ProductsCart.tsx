import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthService from "../../hooks/user/authentication";
import Loader from "../../components/Loader/Loader";
import StatusAlert from "../../components/StatusAlert/StatusAlert";
import { Cart } from "../../types/cartType";
// import DeleteButtonCart from "../../components/DeleteButtonCart/DeleteButtonCart";
// import ClearCartButton from "../../components/ClearCartButton/ClearCartButton";

interface AppState {
  cart: Cart;
}

const ListCart = () => {
  const [cart, setCart] = useState<AppState["cart"]>();
  const [loading, setLoading] = useState<boolean>();

  // const navigate = useNavigate();
  // useEffect(() => {
  //   getCart().then(
  //     (response) => {
  //       if (response.status === 200) {
  //         return setCart(countProducts(response.data));
  //       }
  //     },
  //     (error) => {
  //       if (error) {
  //         console.log(error);
  //         AuthService.logout();
  //         navigate("/login");
  //         window.location.reload();
  //       }
  //     }
  //   );
  // }, []);

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
                      {/* <DeleteButtonCart id={product._id}/> */}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table><p>Total: {cart.totalPrice.toFixed(2)}</p></>
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

export default ListCart;