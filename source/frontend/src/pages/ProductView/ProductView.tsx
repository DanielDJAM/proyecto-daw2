import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import AddButton from "../../components/AddButtonToCart/AddButtonToCart";
import { getProductById } from "../../hooks/product/getProductById";
import { Product } from "../../types/productType";
import Loader from "../../components/Loader/Loader";
import AuthService from "../../hooks/user/authentication";

interface AppState {
  product: Product;
}

const ProductView = () => {
  let { id } = useParams();
  const [product, setProduct] = useState<AppState["product"]>();
  const [imageUrl, setImageUrl] = useState<string | ArrayBuffer | null>(null);
  const [loading, setLoading] = useState<boolean>();

  useEffect(() => {
    setLoading(true);
    getProductById(id).then((response) => {
      setProduct(response);
      setLoading(false);

      if (response.image) {
        const reader = new FileReader();
        reader.readAsDataURL(new Blob([response.image], { type: 'image/jpeg' }));
        reader.onloadend = () => {
          setImageUrl(reader.result);
        };
      }
    });
  }, [id]);


  return (
    <main>
      {loading ? (
        <Loader />
      ) : (
        <section className="product-view">
          <img src={product?.image || require("../../assets/images/default.jpg")} className="card-img-top" alt={product?.name} />
          <div className="product-view__info">
            <div className="data">
              <h1 className="name">{product?.name}</h1>
              {/* <p className="category">{product?.categ?.name}</p> */}
              <p className="description">{product?.description}</p>
              {/* <p className="ingredients">{product?.ingrs?.map(ing => ing.name).join(" - ")}</p> */}
              <h3 className="price">{product?.price}€</h3>
            </div>
            <div className="buttons">
              <AddButton id={id} />
            </div>
          </div>
        </section>
      )}
    </main>
  );
};

export default ProductView;