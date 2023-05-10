import { useEffect, useState } from "react";
import { getAllUsers } from "../../hooks/user/getAllUsers";
import { User } from "../../types/userType";
import Loader from "../../components/Loader/Loader";
import EditButton from "../../components/EditButton/EditButton";
import StatusAlert from "../../components/StatusAlert/StatusAlert";

interface AppState {
  users: User[];
}

const UserList = () => {
  const [users, setUsers] = useState<AppState["users"]>([]);
  const [loading, setLoading] = useState<boolean>();

  useEffect(() => {
    setLoading(true);
    getAllUsers().then(response => {
      setUsers(response);
      setLoading(false);
    });
  }, []);

  return (
    <main className="container">
      <h1>Lista de usuarios</h1>
      {loading ? <Loader /> :
        users ? (
          users.length > 0 ? (
            <table className="table table-striped">
              <thead>
                <tr>
                  <th scope="col">DNI</th>
                  <th scope="col">Usuario</th>
                  <th scope="col">Email</th>
                  <th scope="col">Nombre completo</th>
                  <th scope="col">Dirección</th>
                  <th scope="col">Editar</th>
                </tr>
              </thead>
              <tbody>
                {users.map((user) => (
                  <tr key={user.userId}>
                    <td>{user.dni.dni}</td>
                    <td>{user.username}</td>
                    <td>{user.email}</td>
                    <td>{user.dni.name} {user.dni.surname}</td>
                    <td>{user.dni.addressId.street}, {user.dni.addressId.postalCode}, {user.dni.addressId.city}, {user.dni.addressId.country}</td>
                    <td><EditButton path={`/users/${user.userId}`} /></td>
                  </tr>
                ))}
              </tbody>
            </table>
          ) : (
            <StatusAlert statusClass="alert-warning" statusDescription="La lista de usuarios está vacía" />
          )
        ) : (
          <StatusAlert statusClass="alert-danger" statusDescription="No se ha podido obtener la lista de usuarios" />
        )
      }
    </main>
  );
};

export default UserList;