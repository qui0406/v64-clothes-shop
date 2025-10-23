import "./../../styles/Profile.css";
import { MyUserContext, MyDispatchContext } from "../../configs/MyContexts";
import { Link, NavLink, useNavigate, useLocation } from 'react-router-dom';
import React, { useState, useEffect, useRef, useContext } from 'react';

const ProfileSection = () => {
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);
    const nav = useNavigate();
    const location = useLocation();
  
  const logout = () => {
    dispatch({ type: "logout" });
    nav("/login");
  };

  return (
    <div className="profile-container">
      <div className="sidebar">
        <div className="user-info">
          <div className="avatar">QT</div>
          <div>
            <p className="user-name">Quí Trân</p>
            <p className="user-email">anhqui04062004@gmail.com</p>
          </div>
        </div>
        <div className="menu">
          <a href="#" className="menu-item">Đăng tin</a>
          <a href="#" className="menu-item">Đánh giá đơn hàng</a>
          <a href="#" className="menu-item">Địa chỉ</a>
          <a href="#" className="menu-item">Sản phẩm yêu thích</a>
          <Link to="/" onClick={logout} className="menu-item">Đăng xuất</Link>
        </div>
      </div>
      <div className="content">
        <h2 className="section-title">Thông tin tài khoản</h2>
        <div className="info-section">
          <div className="info-item">
            <label className="info-label">Họ tên:</label>
            <p>Quí Trân</p>
          </div>
          <div className="info-item">
            <label className="info-label">Email:</label>
            <p>anhqui04062004@gmail.com</p>
          </div>
          <div className="info-item">
            <label className="info-label">Số điện thoại:</label>
            <p>Không</p>
          </div>
          <div className="info-item">
            <label className="info-label">Địa chỉ:</label>
            <p>Không</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ProfileSection;