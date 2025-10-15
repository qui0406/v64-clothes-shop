import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";


import Footer from "./components/Layouts/Footer";
import Header from "./components/Layouts/Header";

import Home from "./components/Home"
import AboutShop from "./components/AboutShop"

import Form from "./components/Ui/Form"
import AllProduct from "./components/Products/AllProducts"


function App() {
  return (
    <BrowserRouter>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/pages/he-thong-cua-hang-v-sixtyfour" element= {<AboutShop/>} />

        <Route path="/form" element= {<Form />} />
        <Route path="/tat-ca-san-pham-nu" element= {<AllProduct/>} />
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
