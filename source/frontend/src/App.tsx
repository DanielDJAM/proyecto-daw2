import { BrowserRouter, Route, Routes } from "react-router-dom";
import './App.css';

import LogIn from "./pages/LogIn/LogIn";
import SignUp from "./pages/SignUp/SignUp";
import Header from "./components/Header/Header";
import UserList from "./pages/UserList/UserList";
import ProductsCatalogue from "./pages/ProductsCatalogue/ProductsCatalogue";
import CreateProduct from "./pages/CreateProduct/CreateProduct";
import CartProducts from "./pages/CartProducts/CartProducts";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/login" element={<LogIn />} />
          <Route path="/signup" element={<SignUp />} />
          <Route path="/users" element={<UserList />} />
          <Route path="/products" element={<ProductsCatalogue />} />
          <Route path="/cart" element={<CartProducts />} />
          <Route path="/" element={<ProductsCatalogue />} />
          <Route path="/products/create" element={<CreateProduct />} />

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
