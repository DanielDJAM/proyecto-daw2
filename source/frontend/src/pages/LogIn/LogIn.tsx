import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { useForm } from "react-hook-form";
import AuthService from "../../hooks/user/authentication";
import { yupResolver } from "@hookform/resolvers/yup";
import * as Yup from "yup";
import PasswordButton from "../../components/PasswordButton/PasswordButton";

export interface AppState {
  email: string;
  password: string;
}

const validationSchema = Yup.object().shape({
  email: Yup.string()
    .required("El email es requerido")
    .email("El email es inválido")
    .trim(),
  password: Yup.string()
    .required("La contreseña es requerida")
    /* .min(8, "La contraseña debe tener al menos 8 carácteres")
    .matches(
      /(?=.*[!@#$%^&*])/,
      "La contraseña debe contener al menos un carácter especial"
    )
    .matches(
      /(?=.*[0-9])/,
      "La contraseña debe contener al menos un carácter numérico"
    )
    .matches(
      /(?=.*[a-z])/,
      "La contraseña debe contener al menos un carácter en minúscula"
    )
    .matches(
      /(?=.*[A-Z])/,
      "La contraseña debe contener al menos un carácter en mayúscula"
    )
    .trim() */,
})

const LogIn = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<AppState>({
    resolver: yupResolver(validationSchema),
  });

  const onSubmit = async (data: AppState) => {
    handleLogIn(data.email, data.password);
  };

  const [errorLogIn, setErrorLogIn] = useState("");
  const navigate = useNavigate();

  const handleLogIn = async (email: string, password: string) => {
    try {
      await AuthService.login(email, password).then(
        () => {
          navigate("/");
          window.location.reload();
        },
        (error: any) => {
          setErrorLogIn("Error en la autenticación del usuario");
        }
      );
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <main className="container">
      <h1>Iniciar sesión</h1>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="row g-3">
          <div className="col-12">
            <label htmlFor="email" className="form-label"></label>
            Email
            <input type="text" id="email" className={`form-control ${errors.email ? "is-invalid" : ""}`} {...register("email")} placeholder="Email" />
            <div className="invalid-feedback">{errors.email?.message}</div>
          </div>
          <div className="col-12">
            <label htmlFor="password" className="form-label">
              Contraseña</label>
            <PasswordButton id="password" name="password" className={`form-control ${errors.password ? "is-invalid" : ""}`}
              placeholder="Contraseña" register={register("password")} />
            <div className="invalid-feedback">{errors.password?.message}</div>
            <div className="invalid-feedback">
              {errorLogIn !== "" ? errorLogIn : ""}
            </div>
          </div>
          <div className="col-12">
            <button className="btn btn-primary" type="submit">
              <i className="bi bi-box-arrow-in-right"></i> Iniciar sesión
            </button>
          </div>
          <div className="col-12">
            <Link className="signup" to="/signup">
              ¿No tienes cuenta? Regístrate aquí
            </Link>
          </div>
        </div>
      </form>
    </main>
  );
};

export default LogIn;
