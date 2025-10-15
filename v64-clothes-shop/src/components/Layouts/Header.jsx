import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import "./../../styles/Header.css";

const Header = () => {
  const [dropdowns, setDropdowns] = useState({
    nu: false,
    nam: false,
    phukien: false,
    bosuutap: false,
    cuahang: false
  });

  const handleMouseEnter = (item) => {
    setDropdowns(prevState => ({
      nu: false,
      nam: false,
      phukien: false,
      bosuutap: false,
      cuahang: false,
      [item]: true
    }));
  };

  const handleMouseLeave = () => {
    setDropdowns({
      nu: false,
      nam: false,
      phukien: false,
      bosuutap: false,
      cuahang: false
    });
  };

  return (
    <header className="header">
      <Link to="/" className="logo">V-SIXTYFOUR</Link>
      <nav className="nav-menu">
        <ul>
          <li className="dropdown"
              onMouseEnter={() => handleMouseEnter('nu')}
              onMouseLeave={handleMouseLeave}>
            <Link to="#nu">Nữ</Link>
            {dropdowns.nu && (
              <ul className="dropdown-menu">
                <li><Link to="/tat-ca-san-pham-nu">Tất cả sản phẩm</Link></li>
                <li><Link to="#nusub2">Áo</Link>
                  {dropdowns.nusub2 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#nu-sub2-sub1">Áo khoác</Link></li>
                      <li><Link to="#nu-sub2-sub2">Áo sơ mi</Link></li>
                      <li><Link to="#nu-sub2-sub3">Áo kiểu</Link></li>
                      <li><Link to="#nu-sub2-sub4">Áo thun</Link></li>
                    </ul>
                  )}
                </li>
                <li><Link to="#nusub3">Quần</Link>
                  {dropdowns.nusub3 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#nu-sub3-sub1">Quần dài</Link></li>
                      <li><Link to="#nu-sub3-sub2">Quần lửng</Link></li>
                      <li><Link to="#nu-sub3-sub3">Quần ngắn</Link></li>
                    </ul>
                  )}
                </li>
                <li><Link to="#nu-sub4">Vấy</Link>
                  {dropdowns.nusub4 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#nu-sub4-sub1">Vấy dài</Link></li>
                      <li><Link to="#nu-sub4-sub2">Vấy lửng</Link></li>
                      <li><Link to="#nu-sub4-sub3">Vấy ngắn</Link></li>
                    </ul>
                  )}
                </li>
                <li><Link to="#nu-sub5">Đầm</Link></li>
                <li><Link to="#nu-sub6">Yếm</Link></li>
              </ul>
            )}
          </li>
          <li className="dropdown"
              onMouseEnter={() => handleMouseEnter('nam')}
              onMouseLeave={handleMouseLeave}>
            <Link to="#nam">Nam</Link>
            {dropdowns.nam && (
              <ul className="dropdown-menu">
                <li><Link to="#nam-sub1">Tất cả sản phẩm</Link></li>
                <li><Link to="#nam-sub2">Áo</Link>
                  {dropdowns.namsub2 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#nam-sub2-sub1">Áo khoác</Link></li>
                      <li><Link to="#nam-sub2-sub2">Áo sơ mi</Link></li>
                      <li><Link to="#nam-sub2-sub4">Áo thun</Link></li>
                    </ul>
                  )}
                </li>
                <li><Link to="#nam-sub3">Quần</Link>
                  {dropdowns.namsub3 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#nam-sub3-sub1">Quần dài</Link></li>
                      <li><Link to="#nam-sub3-sub2">Quần ngắn</Link></li>
                    </ul>
                  )}
                </li>
              </ul>
            )}
          </li>
          <li className="dropdown"
              onMouseEnter={() => handleMouseEnter('phukien')}
              onMouseLeave={handleMouseLeave}>
            <Link to="#phukien">Phụ Kiện</Link>
            {dropdowns.phukien && (
              <ul className="dropdown-menu">
                <li><Link to="#phukien-sub1">Nón</Link></li>
                <li><Link to="#phukien-sub2">Túi</Link></li>
                <li><Link to="#phukien-sub3">Khẩu trang</Link></li>
              </ul>
            )}
          </li>
          <li className="dropdown"
              onMouseEnter={() => handleMouseEnter('bosuutap')}
              onMouseLeave={handleMouseLeave}>
            <Link to="#bosuutap">Bộ Sưu Tập</Link>
            {dropdowns.bosuutap && (
              <ul className="dropdown-menu">
                <li><Link to="#bosuutapsub1">SS25</Link>
                  {dropdowns.bosuutapsub1 && (
                    <ul className="dropdown-menu">
                      <li><Link to="#bosuutapsub1sub1">Nam</Link></li>
                      <li><Link to="#bosuutapsub1sub1">Nữ</Link></li>
                    </ul>
                  )}
                </li>
                <li><Link to="#bosuutap-sub2">FW24</Link></li>
                <li><Link to="#bosuutap-sub3">SS24</Link></li>
              </ul>
            )}
          </li>
          <li className="dropdown"
              onMouseEnter={() => handleMouseEnter('cuahang')}
              onMouseLeave={handleMouseLeave}>
            <Link to="/pages/he-thong-cua-hang-v-sixtyfour">Cửa Hàng</Link>
          </li>
        </ul>
      </nav>
      <div className="icons">
        <Link to="#search" className="icon">🔍</Link>
        <Link to="#profile" className="icon">👤</Link>
        <Link to="#wishlist" className="icon">❤️<span>0</span></Link>
        <Link to="#cart" className="icon">🛒<span>0</span></Link>
      </div>
    </header>
  );
};

export default Header;