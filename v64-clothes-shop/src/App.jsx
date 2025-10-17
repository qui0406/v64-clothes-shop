import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";


import Footer from "./components/Layouts/Footer";
import Header from "./components/Layouts/Header";

import Register from "./components/Auth/Register"
import Login from "./components/Auth/Login"
import Profile from "./components/Auth/Profile"

import Home from "./components/Home"
import AboutShop from "./components/AboutShop"

import Form from "./components/Ui/Form"
import AllProductByWomen from "./components/Products/AllProductByWomen"
import AllProductByMen from "./components/Products/AllProductByMen"
import BagProduct from "./components/Products/BagProduct"
import HatProduct from "./components/Products/HatProduct"
import MaskProduct from "./components/Products/MaskProduct"


import Cart from "./components/Cart"
import WishList from "./components/WishList"
import ProductDetails from "./components/Products/ProductDetails"




function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/pages/he-thong-cua-hang-v-sixtyfour" element= {<AboutShop/>} />

        <Route path="/account/register" element ={<Register />} />
        <Route path="/account/login" element ={<Login />} />
        <Route path="/account" element = {<Profile />} />

        <Route path="/form" element= {<Form />} />
        <Route path="/tat-ca-san-pham-nu" element= {<AllProductByWomen/>} />
        <Route path="/tat-ca-san-pham-nam" element= {<AllProductByMen />} />
        <Route path="/collections/tui-denim" element= {<BagProduct />} />
        <Route path="/collections/non-jeans" element= {<HatProduct />} />
        <Route path="/collections/khau-trang" element= {<MaskProduct />} />

        <Route path="/cart" element= {<Cart />} />
        <Route path="/wishlist" element= {<WishList/>} />

        <Route path="/product-details" element = {<ProductDetails />} />
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
