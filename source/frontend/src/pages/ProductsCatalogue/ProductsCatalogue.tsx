import { useState, useEffect } from "react";
import { Product } from "../../types/productType";
import { getAllProducts } from "../../hooks/product/getAllProducts";
import ProductCard from "../../components/ProductCard/ProductCard";
import { Link } from "react-router-dom";
import Loader from "../../components/Loader/Loader";
import ImagesCarousel from "../../components/ImagesCarousel/ImagesCarousel";
import StatusAlert from "../../components/StatusAlert/StatusAlert";

interface AppState {
  products: Array<Product>;
}

const ProductsCatalogue = () => {
  const [products, setProducts] = useState<AppState["products"]>([]);
  const [loading, setLoading] = useState<boolean>();

  useEffect(() => {
    setLoading(true);
    getAllProducts().then(response => {
      setProducts(response);
      setLoading(false);
    });
  }, []);

  return (
    <main className="container g-3">
      <h1>Lista de productos</h1>
      <Link to={"/products/create"}>
        <button className="btn btn-primary">
          Crear producto
        </button>
      </Link>
      <ImagesCarousel />
      <div className="row">
      {loading ? <Loader /> :
        products ? (
          products.length > 0 ? (
            products.map((product) => (
              <div className="col-4 mb-3" key={product.productId}>
                <ProductCard product={product} />
              </div>
            ))
          ) : (
            <StatusAlert statusClass="alert-warning" statusDescription="La lista de productos está vacía" />
          )
        ) : (
          <StatusAlert statusClass="alert-danger" statusDescription="No se ha podido obtener el catálogo de productos" />
        )}
        </div>
    </main>
  );
}

export default ProductsCatalogue;