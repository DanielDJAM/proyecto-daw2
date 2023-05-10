import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import AuthService from "../../hooks/user/authentication";
import { Product } from "../../types/productType";
import AddButton from "../AddButton/AddButton";
// import AddButton from "../AddButton/AddButton";
// import DeleteButtonDB from "../DeleteButtonDB/DeleteButtonDB";

interface AppState {
  product: Product;
}

const ProductCard = ({ product }: AppState) => {
  // const [imageUrl, setImageUrl] = useState<string | null>(null);

  // useEffect(() => {
  //   if (product.image) {
  //     const blob = new Blob([product.image], { type: 'image/png' });
  //     const imageUrl = URL.createObjectURL(blob);
  //     setImageUrl(imageUrl);
  //   }
  // }, [product.image]);

  const [imageUrl, setImageUrl] = useState<string | ArrayBuffer | null>(null);

  useEffect(() => {
    if (product.image) {
      const reader = new FileReader();
      reader.readAsDataURL(new Blob([product.image], { type: 'image/jpeg' }));
      reader.onloadend = () => {
        setImageUrl(reader.result);
      };
    }
  }, [product.image]);

  return (
    <Link className="card product-card" to={`/products/${product.productId}`}>
      <img src={imageUrl || require("../../assets/images/default.jpg")} className="card-img-top" alt={product.name} />
      <div className="card-body">
        <h5 className="card-title">{product.name}</h5>
        <p className="card-text">{product.description}</p>
      </div>
      <ul className="list-group list-group-flush">
        <li className="list-group-item">Precio: {product.price}€</li>
        <li className="list-group-item">Disponibles: {product.stock}</li>
      </ul>
      <div className="card-body">
        <AddButton id={product.productId} />
      </div>
    </Link>
  );
};

export default ProductCard;
