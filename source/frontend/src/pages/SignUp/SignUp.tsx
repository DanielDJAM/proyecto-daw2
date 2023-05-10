import { useState } from "react";
import AuthService from "../../hooks/user/authentication";
import { useNavigate } from "react-router-dom";
import { useForm } from 'react-hook-form';
import PasswordButton from "../../components/PasswordButton/PasswordButton";
import { yupResolver } from "@hookform/resolvers/yup";
import * as Yup from "yup";
import { User } from "../../types/userType";

export interface AppState {
  name: string,
  surname: string,
  age: number,
  dni: string,
  username: string,
  email: string,
  password: string,
  passwordConfirmation: string,
  country: string,
  city: string,
  state: string,
  street: string,
  dataResidence: string,
  postalCode: string,
}

const validationSchema = Yup.object().shape({
  name: Yup.string()
    .required("El nombre es requerido")
    .min(2, "El nombre debe tener al menos 2 caracteres"),
  surname: Yup.string()
    .required("Los apellidos son requeridos")
    .min(2, "Los apellidos deben tener al menos 2 caracteres"),
  age: Yup.number()
    .typeError("La edad debe ser un número")
    .required("La edad es requerida")
    .integer("La edad debe ser un número entero")
    .positive("La edad debe ser un número positivo")
    .max(99, "La edad debe ser menor que 99"),
  dni: Yup.string()
    .required("El DNI/NIE es requerido")
    .matches(/^([0-9]{8}[A-Z])|([XYZ][0-9]{7}[A-Z])$/, "El DNI/NIE es inválido"),
  username: Yup.string()
    .required("El nombre de usuario es requerido")
    .min(6, "El nombre de usuario debe tener al menos 6 caracteres"),
  email: Yup.string()
    .required("El email es requerido")
    .email("El email es inválido"),
  password: Yup.string()
    .required("La contreseña es requerida")
    // .min(8, "La contraseña debe tener al menos 8 carácteres")
    // .matches(
    //   /(?=.*[!@#$%^&*])/,
    //   "La contraseña debe contener al menos un carácter especial"
    // )
    // .matches(
    //   /(?=.*[0-9])/,
    //   "La contraseña debe contener al menos un carácter numérico"
    // )
    // .matches(
    //   /(?=.*[a-z])/,
    //   "La contraseña debe contener al menos un carácter en minúscula"
    // )
    // .matches(
    //   /(?=.*[A-Z])/,
    //   "La contraseña debe contener al menos un carácter en mayúscula"
    // ),
  // passwordConfirmation: Yup.string()
  //   .oneOf([Yup.ref("password")], "Las contraseñas deben coincidir")
    ,
  country: Yup.string().required("El país es requerido"),
  city: Yup.string().required("La ciudad es requerida"),
  state: Yup.string().required("La provincia/estado es requerido"),
  street: Yup.string().required("La calle es requerida"),
  dataResidence: Yup.string(),
  postalCode: Yup.string().required("El código postal es requerido")
})

const Signup = () => {
  const { register, handleSubmit, formState: { errors } } = useForm<AppState>({
    resolver: yupResolver(validationSchema)
  });

  const onSubmit = async (data: AppState) => {
    handleSignUp(data);
  };

  const [errorSignUp, setErrorSignUp] = useState("");
  const navigate = useNavigate();

  const handleSignUp = async (data: AppState) => {
    const user: User = {
      userId: '',
      dni: {
        dni: data.dni,
        addressId: {
          addressId: '',
          country: data.country,
          city: data.city,
          state: data.state,
          street: data.street,
          dataResidence: data.dataResidence,
          postalCode: data.postalCode
        },
        age: data.age,
        name: data.name,
        surname: data.surname
      },
      username: data.username,
      email: data.email,
      password: data.password
    };
    try {
      await AuthService.signup(user).then(
        () => {
          navigate("/");
          window.location.reload();
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
      <h1>Crear cuenta</h1>
      <form onSubmit={handleSubmit(onSubmit)} >
        <div className="row g-3">
          <div className="col-6">
            <label htmlFor="name" className="form-label">
              Nombre</label>
            <input className="form-control" {...register('name')} type="text" name="name" id="name" placeholder="Nombre" />
            <div className="invalid-feedback">{errors.name?.message}</div>
          </div>
          <div className="col-6">
            <label htmlFor="surname" className="form-label">
              Apellidos</label>
            <input className="form-control" {...register('surname')} type="text" name="surname" id="surname" placeholder="Apellidos" />
            <div className="invalid-feedback">{errors.surname?.message}</div>
          </div>
          <div className="col-2">
            <label htmlFor="age" className="form-label">
              Edad</label>
            <input className="form-control" {...register('age')} type="number" name="age" id="age" placeholder="Edad" min={1} max={99} />
            <div className="invalid-feedback">{errors.age?.message}</div>
          </div>
          <div className="col-10">
            <label htmlFor="dni" className="form-label">
              DNI/NIE</label>
            <input className="form-control" {...register('dni')} type="text" name="dni" id="dni" placeholder="DNI/NIE" />
            <div className="invalid-feedback">{errors.dni?.message}</div>
          </div>
          <div className="col-12">
            <label htmlFor="username" className="form-label">
              Nombre de usuario</label>
            <input className="form-control" {...register('username')} type="text" name="username" id="username" placeholder="Nombre de usuario" />
            <div className="invalid-feedback">{errors.username?.message}</div>
          </div>
          <div className="col-12">
            <label htmlFor="email" className="form-label">
              Email</label>
            <input className="form-control" {...register('email')} type="email" name="email" id="email" placeholder="Email" />
            <div className="invalid-feedback">{errors.email?.message}</div>
          </div>
          <div className="col-6">
            <label htmlFor="password" className="form-label">
              Contraseña</label>
            <PasswordButton className="form-control" register={register("password")} name="password" id="password" placeholder="Contraseña" />
            <div className="invalid-feedback">{errors.password?.message}</div>
          </div>
          <div className="col-6">
            <label htmlFor="passwordConfirmation" className="form-label">
              Confirmar contraseña</label>
            <PasswordButton className="form-control" register={register("passwordConfirmation")} name="passwordConfirmation" id="passwordConfirmation" placeholder="Confirmar contraseña" />
            <div className="invalid-feedback">{errors.passwordConfirmation?.message}</div>
          </div>
          <div className="col-4">
            <label htmlFor="country" className="form-label">
              País</label>
            <input className="form-control" {...register('country')} type="text" name="country" id="country" placeholder="País" />
            <div className="invalid-feedback">{errors.country?.message}</div>
          </div>
          <div className="col-4">
            <label htmlFor="city" className="form-label">
              Ciudad</label>
            <input className="form-control" {...register('city')} type="text" name="city" id="city" placeholder="Ciudad" />
            <div className="invalid-feedback">{errors.city?.message}</div>
          </div>
          <div className="col-4">
            <label htmlFor="state" className="form-label">
              Provincia</label>
            <input className="form-control" {...register('state')} type="text" name="state" id="state" placeholder="Provincia" />
            <div className="invalid-feedback">{errors.state?.message}</div>
          </div>
          <div className="col-8">
            <label htmlFor="street" className="form-label">
              Calle</label>
            <input className="form-control" {...register('street')} type="text" name="street" id="street" placeholder="Calle" />
            <div className="invalid-feedback">{errors.street?.message}</div>
          </div>
          <div className="col-2">
            <label htmlFor="dataResidence" className="form-label">
              Piso/Puerta</label>
            <input className="form-control" {...register('dataResidence')} type="text" name="dataResidence" id="data-residence" placeholder="Piso/Puerta" />
            <div className="invalid-feedback">{errors.dataResidence?.message}</div>
          </div>
          <div className="col-2">
            <label htmlFor="postalCode" className="form-label">
              Código postal</label>
            <input className="form-control" {...register('postalCode')} type="text" name="postalCode" id="postal-code" placeholder="Código postal" />
            <div className="invalid-feedback">{errors.postalCode?.message}</div>
          </div>
          <div className="col-12">
            <button className="btn btn-primary form-button" type="submit"><i className="bi bi-person-add"></i> Registrarse</button>
          </div>
        </div>
      </form>
    </main>
  );
};

export default Signup;