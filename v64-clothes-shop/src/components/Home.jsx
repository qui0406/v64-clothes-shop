import React, { useState } from 'react';
import { ShoppingBag, User, Heart, Search, Menu, X } from 'lucide-react';

const HomePage = () => {
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);

  const products = [
    {
      id: 1,
      name: 'Denim Cơ Bản',
      image: 'https://file.hstatic.net/1000210295/file/v64_home_cat01a.jpg'
    },
    {
      id: 2,
      name: 'Denim Cá Tính',
      image: 'https://file.hstatic.net/1000210295/file/v64_home_cat02.jpg'
    },
    {
      id: 3,
      name: 'Váy Denim Nữ',
      image: 'https://file.hstatic.net/1000210295/file/v64_home_cat03.jpg'
    },
    {
      id: 4,
      name: 'Denim Phối Mặc Đẹp',
      image: 'https://file.hstatic.net/1000210295/file/v64_home_cat04.jpg'
    }
  ];

  return (
    <div className="website-container">
      <section className="hero-section">
        <video
          className="hero-video"
          autoPlay
          loop
          muted
          playsInline
        >
          <source src="https://file.hstatic.net/1000210295/file/video-homepage1.mp4" type="video/mp4" />
          Trình duyệt của bạn không hỗ trợ video.
        </video>
        <div className="hero-overlay"></div>
        <div className="hero-content">
          <h1 className="hero-title">#V-SIXTYFOUR - SẢN PHẨM ĐẾN TỪ THIÊN NHIÊN</h1>
          <button className="hero-btn">Xem Thêm</button>
        </div>
      </section>

      {/* Campaign Section */}
      <section className="campaign-section">
        <div className="campaign-image">
            <img 
              src="https://file.hstatic.net/1000210295/file/cover_web_816e81f25d604e7fb5cbc24868ba28c6.jpg" 
              alt="Denim Fashion Collection"
            />
          </div>
      </section>

      {/* Fashion Categories Banner */}
      <section className="fashion-banner">
        <div className="fashion-banner-grid">
          {/* Thời trang nam */}
          <div className="banner-item">
            <img
              src="https://file.hstatic.net/1000210295/file/home_banner-01.jpg"
              alt="Thời trang nam"
            />
            <h3 className="banner-label">Thời Trang Nam</h3>
          </div>

          {/* Thời trang nữ */}
          <div className="banner-item">
            <img
              src="https://file.hstatic.net/1000210295/file/home_banner_02.jpg"
              alt="Thời trang nữ"
            />
            <h3 className="banner-label">Thời Trang Nữ</h3>
          </div>
        </div>
      </section>

      {/* Products Grid Section */}
      <section className="products-section">
        <div className="products-container">
          <div className="product-grid">
            {products.map((product) => (
              <div key={product.id} className="product-card">
                <div className="product-image-wrapper">
                  <img 
                    src={product.image}
                    alt={product.name}
                    className="product-image"
                  />
                  <div className="overlay"></div>
                </div>
                <h3 className="product-name">{product.name}</h3>
              </div>
            ))}
          </div>
        </div>
      </section>


      
      <style>{`
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap');

        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
        }

        .website-container {
          font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
          color: #1f2937;
          background: #ffffff;
        }

        /* Top Banner */
        .top-banner {
          background: #1a1a1a;
          color: white;
          text-align: center;
          padding: 12px 20px;
          font-size: 13px;
          font-weight: 500;
          letter-spacing: 0.5px;
        }

        /* Header */
        .header {
          background: white;
          box-shadow: 0 2px 8px rgba(0,0,0,0.08);
          position: sticky;
          top: 0;
          z-index: 1000;
        }

        .header-container {
          max-width: 1280px;
          margin: 0 auto;
          padding: 0 24px;
          display: flex;
          justify-content: space-between;
          align-items: center;
          height: 70px;
        }

        .logo {
          font-size: 22px;
          font-weight: 700;
          letter-spacing: 1.5px;
          color: #1a1a1a;
          cursor: pointer;
        }

        .nav-menu {
          display: flex;
          gap: 36px;
          align-items: center;
        }

        .nav-link {
          text-decoration: none;
          color: #4b5563;
          font-weight: 500;
          font-size: 14px;
          letter-spacing: 0.3px;
          transition: color 0.3s ease;
        }

        .nav-link:hover {
          color: #1a1a1a;
        }

        .header-icons {
          display: flex;
          gap: 16px;
          align-items: center;
        }

        .icon-btn {
          background: none;
          border: none;
          cursor: pointer;
          position: relative;
          padding: 8px;
          color: #4b5563;
          transition: color 0.3s ease;
          display: flex;
          align-items: center;
          justify-content: center;
        }

        .icon-btn:hover {
          color: #1a1a1a;
        }

        .icon-badge {
          position: absolute;
          top: 2px;
          right: 2px;
          background: #1a1a1a;
          color: white;
          font-size: 10px;
          font-weight: 600;
          border-radius: 50%;
          width: 16px;
          height: 16px;
          display: flex;
          align-items: center;
          justify-content: center;
        }

        .mobile-menu-btn {
          display: none;
          background: none;
          border: none;
          cursor: pointer;
          color: #1a1a1a;
          padding: 8px;
        }

        /* Hero Section */
        .hero-section {
          position: relative;
          height: 500px;
          overflow: hidden;
          display: flex;
          align-items: center;
          justify-content: center;
          background: #1e3a8a;
        }

        .hero-video {
          position: absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
          min-width: 100%;
          min-height: 100%;
          width: auto;
          height: auto;
          object-fit: cover;
          z-index: 0;
        }

        .hero-overlay {
          position: absolute;
          inset: 0;
          background: rgba(0, 0, 0, 0.35);
          z-index: 1;
        }

        .hero-content {
          position: relative;
          z-index: 2;
          text-align: center;
          color: white;
          padding: 0 24px;
          max-width: 900px;
        }

        .hero-title {
          font-size: 44px;
          font-weight: 300;
          line-height: 1.3;
          margin-bottom: 32px;
          letter-spacing: 1px;
        }

        .hero-btn {
          padding: 14px 48px;
          background: transparent;
          border: 2px solid white;
          color: white;
          font-size: 15px;
          font-weight: 500;
          letter-spacing: 0.5px;
          cursor: pointer;
          transition: all 0.3s ease;
        }

        .hero-btn:hover {
          background: white;
          color: #1e3a8a;
          transform: translateY(-2px);
        }



        .campaign-container {
          max-width: 1280px;
          margin: 0 auto;
          display: grid;
          grid-template-columns: 1fr 1fr;
          gap: 60px;
          align-items: center;
        }

        .campaign-image img {
          width: 100%;
          height: auto;
          border-radius: 12px;
          box-shadow: 0 20px 40px rgba(0,0,0,0.12);
        }

        .campaign-content {
          text-align: center;
          padding: 0 20px;
        }

        .campaign-subtitle {
          font-size: 100px;
          font-weight: 300;
          color: #e5e7eb;
          margin-bottom: 16px;
          line-height: 1;
          letter-spacing: -2px;
        }

        .campaign-title {
          font-size: 56px;
          font-weight: 700;
          color: #1f2937;
          margin-bottom: 24px;
          line-height: 1.2;
          letter-spacing: -1px;
        }

        .campaign-text {
          color: #6b7280;
          font-size: 18px;
          margin-bottom: 8px;
          font-weight: 400;
        }

        .shop-btn {
          margin-top: 32px;
          padding: 16px 52px;
          background: #1a1a1a;
          color: white;
          border: none;
          font-size: 15px;
          font-weight: 600;
          letter-spacing: 1px;
          cursor: pointer;
          transition: all 0.3s ease;
        }

        .shop-btn:hover {
          background: #333;
          transform: translateY(-2px);
          box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }

        /* Fashion Banner */
        .fashion-banner {
          width: 100%;
          height: 100%;
          overflow: hidden;
        }

        .fashion-banner-grid {
          display: grid;
          grid-template-columns: 1fr 1fr;
          height: 100%;
        }

        .banner-item {
          position: relative;
          overflow: hidden;
          cursor: pointer;
          transition: transform 0.3s ease;
        }

        .banner-item img {
          width: 100%;
          height: 100%;
          object-fit: cover;
          transition: transform 0.5s ease;
        }

        .banner-item:hover img {
          transform: scale(1.05);
        }

        .banner-label {
          position: absolute;
          top: 20px;
          left: 20px;
          font-size: 18px;
          color: #000;
          background-color: rgba(255, 255, 255, 0.7);
          padding: 8px 16px;
          border-radius: 4px;
          font-weight: 500;
        }


        /* Promo Banner */
        .promo-banner {
          background: #f3f4f6;
          padding: 14px 24px;
          text-align: center;
        }

        .promo-banner p {
          font-size: 13px;
          font-weight: 600;
          color: #1f2937;
          letter-spacing: 0.5px;
        }

        /* Products Section */
        .products-section {
          width: 100%;
          padding: 0;
          background-color: #fff;
        }

        .products-container {
          margin: 0 auto;
          padding: 0;
        }

        .product-grid {
          display: grid;
          grid-template-columns: repeat(4, 1fr);
          gap: 0;
        }

        .product-card {
          position: relative;
          overflow: hidden;
          text-align: left;
          cursor: pointer;
          border-right: 1px solid #f2f2f2;
        }

        .product-card:last-child {
          border-right: none;
        }

        .product-image-wrapper {
          position: relative;
          width: 100%;
          height: 100%;
        }

        .product-image {
          width: 100%;
          height: 100%;
          object-fit: cover;
          transition: transform 0.5s ease;
        }

        .product-card:hover .product-image {
          transform: scale(1.05);
        }

        .overlay {
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: 100%;
          background-color: rgba(108, 148, 255, 0.2);
          opacity: 0;
          transition: opacity 0.4s ease;
        }

        .product-card:hover .overlay {
          opacity: 1;
        }

        .product-name {
          position: absolute;
       
          font-size: 14px;
          color: #000;
          font-weight: 500;
          z-index: 2;
        } 
        
      `}</style>
    </div>
  );
};

export default HomePage;