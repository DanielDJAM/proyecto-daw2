import { useNavigate } from "react-router-dom";
// import { addProductToCart } from "../../hooks/cart/addProductToCart";
import AuthService from "../../hooks/user/authentication";

interface AppState {
  id: string | undefined;
}

const AddButton = ({ id }: AppState) => {

  const navigate = useNavigate();
  const onSubmit = async () => {
    try {
      if (id !== undefined) {
        // await addProductToCart(id).then(
        //   (response: any) => {
        //     if (response.status === 200) {

        //     }
        //   },
        //   (error: any) => {
        //     if (error) {
        //       AuthService.logout();
        //       navigate("/login"); 
        //       window.location.reload();
        //     }
        //   }
        // );
      }
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <button className="btn btn-success" onClick={onSubmit}><i className="bi bi-bag-plus-fill"></i> Añadir</button>
  );
}

export default AddButton;