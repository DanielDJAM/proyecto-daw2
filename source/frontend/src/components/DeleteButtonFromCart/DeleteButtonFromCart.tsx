import { useNavigate } from "react-router-dom";
import CartService from "../../hooks/cart/addProductToCart";
import AuthService from "../../hooks/user/authentication";

interface AppState {
  id: string | undefined;
}

const DeleteButtonFromCart = ({ id }: AppState) => {
  const navigate = useNavigate();
  if (!id){
    return null;
  }
  const onSubmit = async () => {
    await CartService.removeProductFromCart(id).then(
      (response) => {

      },
      (error) => {
        console.log(error)
      })
  };

  return (
    <button className="btn btn-danger" onClick={onSubmit}>
      <i className="bi bi-trash"></i>
    </button>
  );
};

export default DeleteButtonFromCart;