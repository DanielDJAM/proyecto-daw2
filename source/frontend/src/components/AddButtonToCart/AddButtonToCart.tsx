import { useNavigate } from "react-router-dom";
import CartService from "../../hooks/cart/addProductToCart";
import AuthService from "../../hooks/user/authentication";

interface AppState {
  id: string | undefined;
}

const AddButtonToCart = ({ id }: AppState) => {

  const navigate = useNavigate();
  const onSubmit = async () => {
    try {
      if (id !== undefined) {
        await CartService.addProductToCart(id).then(
          (response) => {
            navigate("/cart");
            window.location.reload();
          },
          (error) => {
            console.log(error)
          }
        );
      }
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <button className="btn btn-success" onClick={onSubmit}><i className="bi bi-bag-plus-fill"></i> Añadir al carrito</button>
  );
}

export default AddButtonToCart;