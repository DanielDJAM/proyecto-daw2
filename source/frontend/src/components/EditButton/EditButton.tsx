import { useNavigate } from 'react-router-dom';

interface EditIconProps {
  path: string;
}

function EditButton( { path }: EditIconProps ) {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(path);
  };

  return (
    <i className="bi bi-pencil-square" onClick={handleClick}></i>
  );
}

export default EditButton;