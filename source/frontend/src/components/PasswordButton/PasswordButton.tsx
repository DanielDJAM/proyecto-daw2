import { useState } from "react";

interface PasswordButtonProps {
  id: string;
  name: string;
  className: string;
  placeholder: string;
  register: any;
}

const PasswordButton = ({ id, name, className, placeholder, register }: PasswordButtonProps) => {
  const [passwordShown, setPasswordShown] = useState(false);

  const togglePassword = () => {
    setPasswordShown(!passwordShown);
  };
  return (
    <div className="input-group">
      <input
        id={`${id}`}
        name={`${name}`}
        className={`${className}`}
        type={passwordShown ? "text" : "password"}
        placeholder={`${placeholder}`}
        {...register}
        aria-describedby="eye"
      />
      <span
        className="input-group-text password-eye"
        id="eye"
        onClick={togglePassword}
      >
        {passwordShown ? (
          <i className="bi bi-eye"></i>
        ) : (
          <i className="bi bi-eye-slash"></i>
        )}
      </span>
    </div>
  );
};

export default PasswordButton;