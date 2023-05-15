import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useForm } from 'react-hook-form';
import Loader from "../../components/Loader/Loader";
import PasswordButton from "../../components/PasswordButton/PasswordButton";
import { yupResolver } from "@hookform/resolvers/yup";
import * as Yup from "yup";
import { Product } from "../../types/productType";
import { Category } from "../../types/categoryType";
import createProduct from "../../hooks/product/createProduct";
import getAllCategories from "../../hooks/product/getAllCategories";

export interface AppState {
  name: string,
  stock: number,
  price: number,
  description: string,
  image: FileList,
  categories: Array<Category>,
  allCategories: Array<Category>
}

const validationSchema = Yup.object().shape({
  name: Yup.string().required('El nombre es obligatorio'),
  // stock: Yup.number()
  //   .typeError('El stock debe ser un número')
  //   .integer('El stock debe ser un número entero')
  //   .min(0, 'El stock mínimo es 0')
  //   .required('El stock es obligatorio'),
  // price: Yup.number()
  //   .typeError('El precio debe ser un número')
  //   .min(0, 'El precio mínimo es 0')
  //   .required('El precio es obligatorio'),
  // description: Yup.string().required('La descripción es obligatoria'),
  // image: Yup.string().url('La imagen debe ser una URL válida').required('La imagen es obligatoria'),
})

const CreateProduct = () => {
  const [allCategories, setAllCategories] = useState<AppState["allCategories"]>([]);
  const [selectedCategories, setSelectedCategories] = useState<AppState["categories"]>([]);
  const [loadingCategories, setLoadingCategories] = useState<boolean>();
  const [errorSignUp, setErrorSignUp] = useState("");
  const navigate = useNavigate();

  const { register, handleSubmit, formState: { errors } } = useForm<AppState>({
    resolver: yupResolver(validationSchema)
  });

  const handleSelectChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedOptions = Array.from(event.target.selectedOptions);
    const selectedCategories = selectedOptions.map((option) => allCategories.find((category) => category.categoryId.toString() === option.value)!);
    setSelectedCategories(selectedCategories);
  };

  useEffect(() => {
    setLoadingCategories(true);
    getAllCategories().then(response => {
      setAllCategories(response);
      setLoadingCategories(false);
    });
  }, []);

  const onSubmit = async (data: AppState) => {
    handleCreateProduct(data);
  };

  const handleCreateProduct = async (data: AppState) => {
    const product: Product = {
      productId: undefined,
      name: data.name,
      stock: data.stock,
      price: data.price,
      description: data.description,
      image: data.image[0],
      categories: selectedCategories.map((categoryId) => categoryId)
    };
    try {
      await createProduct(product).then(
        () => {
          // navigate("/");
          // window.location.reload();
        },
        (error) => {
          console.log(error);
        }
      );
    } catch (err) {
      console.log(err);
    }
  }

  return (
    <main className="container">
      <h1>Crear producto</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="row g-3">
          <div className="col-6">
            <label htmlFor="name" className="form-label">
              Nombre
            </label>
            <input
              className="form-control"
              {...register('name')}
              type="text"
              name="name"
              id="name"
              placeholder="Nombre"
            />
            <div className="invalid-feedback">{errors.name?.message}</div>
          </div>
          <div className="col-3">
            <label htmlFor="stock" className="form-label">
              Stock
            </label>
            <input
              className="form-control"
              {...register('stock')}
              type="number"
              name="stock"
              id="stock"
              placeholder="Stock"
            />
            <div className="invalid-feedback">{errors.stock?.message}</div>
          </div>
          <div className="col-3">
            <label htmlFor="price" className="form-label">
              Precio
            </label>
            <input
              className="form-control"
              {...register('price')}
              type="number"
              name="price"
              id="price"
              placeholder="Precio"
            />
            <div className="invalid-feedback">{errors.price?.message}</div>
          </div>
          {loadingCategories ? <Loader /> :
            <div className="col-12">
              <label htmlFor="categories" className="form-label">
                Categorias
              </label>
              <select className="form-control" name="categories" id="categories" multiple onChange={handleSelectChange}>
                {allCategories && allCategories.map((category) => (
                  <option key={category.categoryId} value={category.categoryId}>{category.name}</option>
                ))}
              </select>
            </div>
          }
          <div className="col-12">
            <label htmlFor="description" className="form-label">
              Descripción
            </label>
            <textarea
              className="form-control"
              {...register('description')}
              name="description"
              id="description"
              placeholder="Descripción"
            />
            <div className="invalid-feedback">{errors.description?.message}</div>
          </div>
          <div className="col-12">
            <label htmlFor="image" className="form-label">
              Imagen
            </label>
            <input
              className="form-control"
              {...register('image')}
              type="file"
              name="image"
              id="image"
              placeholder="Imagen"
            />
            <div className="invalid-feedback">{errors.image?.message}</div>
          </div>
          <div className="col-12">
            <button type="submit" className="btn btn-primary">
              Crear producto
            </button>
          </div>
        </div>
      </form>
    </main>
  );
};

export default CreateProduct;