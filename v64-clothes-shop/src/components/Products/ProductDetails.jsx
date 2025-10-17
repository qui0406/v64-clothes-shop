import React, { useState } from 'react';
import { Heart, ShoppingCart, ChevronDown, ChevronUp, MapPin } from 'lucide-react';

const ProductDetailPage = () => {
  const [selectedImage, setSelectedImage] = useState(0);
  const [selectedColor, setSelectedColor] = useState(0);
  const [selectedSize, setSelectedSize] = useState('S');
  const [quantity, setQuantity] = useState(1);
  const [expandedSections, setExpandedSections] = useState({
    standards: false,
    policy: false,
    stores: true
  });

  const product = {
    name: 'Áo Sơ Mi Denim Nam Họa Tiết Dập Ly Vai Áo Màu Xanh Med Blue - Men\'s Medium Blue Denim Shirt With Pleated Shoulders',
    sku: '125MD4049F1',
    msp: '125MD4049F1950S',
    price: 964000,
    status: 'Còn hàng',
    colors: [
      { name: 'MED BLUE', image: 'https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400&h=500&fit=crop' },
      { name: 'DARK BLUE', image: 'https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400&h=500&fit=crop' }
    ],
    sizes: ['S', 'M', 'L', 'XL'],
    images: [
      'https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=600&h=800&fit=crop',
      'https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=600&h=800&fit=crop'
    ],
    description: 'Denim Shirt With Pleated Shoulders – "chìa khóa thời trang" cho các chàng trai muốn khẳng định phong cách lịch lãm, trẻ trung và hiện đại!',
    features: [
      'Thiết kế đập sóng ly hai bên vai, kết hợp kỹ thuật wash sáng màu, làm nổi bật chất liệu denim.',
      'Túi hộp cách điệu tinh tế, tạo nét nam tính và năng động.'
    ],
    material: [
      'Khuy bấm kim loại phủ hiệu ứng pearl texture',
      '100% Cotton (7,2 OZ)',
      'Vải Denim mềm mịn thoáng mát'
    ],
    madeIn: '* Thiết kế và sản xuất tại Sài Gòn, Việt Nam.\nCrafted with care by Viet Thang Jean, Vietnam.',
    stores: [
      {
        name: 'Hồ Chí Minh',
        address: '38 Quang Trung, Phường Hiệp Phú, Thành phố Thủ Đức',
        hours: 'Mở cửa: 9 giờ 00 - 22 giờ (Các ngày trong tuần)'
      },
      {
        name: 'Hồ Chí Minh',
        address: 'Tầng 3 - TTTM Van Hanh Mall, 11 Sư Vạn Hạnh, Phường 12, Quận 10',
        hours: 'Mở cửa: 9 giờ 00 - 22 giờ (Các ngày trong tuần)'
      }
    ]
  };

  const toggleSection = (section) => {
    setExpandedSections(prev => ({
      ...prev,
      [section]: !prev[section]
    }));
  };

  const formatPrice = (price) => {
    return price.toLocaleString('vi-VN') + 'đ';
  };

  const updateQuantity = (delta) => {
    setQuantity(Math.max(1, quantity + delta));
  };

  return (
    <div className="product-page">
      <div className="breadcrumb">
        <a href="#">Trang chủ</a>
        <span>/</span>
        <a href="#">Áo</a>
        <span>/</span>
        <span>{product.name}</span>
      </div>

      <div className="product-container">
        <div className="product-gallery">
          <div className="main-image">
            <img src={product.images[selectedImage]} alt={product.name} />
          </div>
          <div className="thumbnail-list">
            {product.images.map((img, idx) => (
              <div
                key={idx}
                className={`thumbnail ${selectedImage === idx ? 'active' : ''}`}
                onClick={() => setSelectedImage(idx)}
              >
                <img src={img} alt={`View ${idx + 1}`} />
              </div>
            ))}
          </div>
        </div>

        <div className="product-info">
          <h1 className="product-title">{product.name} - {product.sku}</h1>
          
          <div className="product-price">{formatPrice(product.price)}</div>
          
          <div className="product-meta">
            <div className="meta-item">
              <span className="label">MSP:</span>
              <span className="value">{product.msp}</span>
            </div>
            <div className="meta-item">
              <span className="label">Tình trạng:</span>
              <span className="value status-available">{product.status}</span>
            </div>
          </div>

          <div className="product-options">
            <div className="option-group">
              <label>Màu sắc: {product.colors[selectedColor].name}</label>
              <div className="color-options">
                {product.colors.map((color, idx) => (
                  <div
                    key={idx}
                    className={`color-option ${selectedColor === idx ? 'selected' : ''}`}
                    onClick={() => setSelectedColor(idx)}
                  >
                    <img src={color.image} alt={color.name} />
                  </div>
                ))}
              </div>
            </div>

            <div className="option-group">
              <label>
                Kích thước:
                <a href="#" className="size-guide">📏 Hướng dẫn chọn size</a>
              </label>
              <div className="size-options">
                {product.sizes.map(size => (
                  <button
                    key={size}
                    className={`size-btn ${selectedSize === size ? 'selected' : ''}`}
                    onClick={() => setSelectedSize(size)}
                  >
                    {size}
                  </button>
                ))}
              </div>
            </div>

            <div className="option-group">
              <div className="quantity-actions">
                <div className="quantity-control">
                  <button onClick={() => updateQuantity(-1)}>−</button>
                  <input type="text" value={quantity} readOnly />
                  <button onClick={() => updateQuantity(1)}>+</button>
                </div>
                <button className="btn-add-cart">Thêm vào giỏ</button>
                <button className="btn-buy-now">Mua ngay</button>
              </div>
            </div>
          </div>

          <div className="product-description">
            <p className="desc-highlight">{product.description}</p>
            
            <div className="desc-section">
              <h3>Điểm nổi bật:</h3>
              <ul>
                {product.features.map((feature, idx) => (
                  <li key={idx}>- {feature}</li>
                ))}
              </ul>
            </div>

            <div className="desc-section">
              <p className="made-in">{product.madeIn}</p>
            </div>

            <div className="desc-section">
              <h3>Chất liệu:</h3>
              <ul>
                {product.material.map((item, idx) => (
                  <li key={idx}>- {item}</li>
                ))}
              </ul>
            </div>
          </div>

          <div className="accordion">
            <div className="accordion-item">
              <button
                className="accordion-header"
                onClick={() => toggleSection('standards')}
              >
                <span>Tiêu chuẩn sản phẩm</span>
                {expandedSections.standards ? <ChevronUp size={20} /> : <ChevronDown size={20} />}
              </button>
              {expandedSections.standards && (
                <div className="accordion-content">
                  <p>Thông tin về tiêu chuẩn sản phẩm...</p>
                </div>
              )}
            </div>

            <div className="accordion-item">
              <button
                className="accordion-header"
                onClick={() => toggleSection('policy')}
              >
                <span>Chính sách đổi trả</span>
                {expandedSections.policy ? <ChevronUp size={20} /> : <ChevronDown size={20} />}
              </button>
              {expandedSections.policy && (
                <div className="accordion-content">
                  <p>Thông tin về chính sách đổi trả...</p>
                </div>
              )}
            </div>

            <div className="accordion-item">
              <button
                className="accordion-header"
                onClick={() => toggleSection('stores')}
              >
                <span>Có 7 cửa hàng còn sản phẩm này</span>
                {expandedSections.stores ? <ChevronUp size={20} /> : <ChevronDown size={20} />}
              </button>
              {expandedSections.stores && (
                <div className="accordion-content stores-list">
                  {product.stores.map((store, idx) => (
                    <div key={idx} className="store-item">
                      <div className="store-header">
                        <MapPin size={18} />
                        <strong>{store.name}:</strong>
                      </div>
                      <p className="store-address">{store.address}</p>
                      <p className="store-hours">{store.hours}</p>
                    </div>
                  ))}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>

      <style jsx>{`
        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
        }

        .product-page {
          max-width: 1400px;
          margin: 0 auto;
          padding: 20px 40px;
          font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', sans-serif;
        }

        .breadcrumb {
          font-size: 14px;
          color: #666;
          margin-bottom: 30px;
        }

        .breadcrumb a {
          color: #666;
          text-decoration: none;
        }

        .breadcrumb a:hover {
          color: #c9a76a;
        }

        .breadcrumb span {
          margin: 0 8px;
        }

        .product-container {
          display: grid;
          grid-template-columns: 1fr 1fr;
          gap: 60px;
        }

        .product-gallery {
          display: flex;
          gap: 15px;
        }

        .thumbnail-list {
          display: flex;
          flex-direction: column;
          gap: 10px;
        }

        .thumbnail {
          width: 80px;
          height: 100px;
          cursor: pointer;
          border: 2px solid transparent;
          border-radius: 4px;
          overflow: hidden;
          transition: border-color 0.3s;
        }

        .thumbnail.active {
          border-color: #c9a76a;
        }

        .thumbnail img {
          width: 100%;
          height: 100%;
          object-fit: cover;
        }

        .main-image {
          flex: 1;
          background: #f5f5f5;
          border-radius: 8px;
          overflow: hidden;
        }

        .main-image img {
          width: 100%;
          height: 100%;
          object-fit: cover;
        }

        .product-info {
          display: flex;
          flex-direction: column;
          gap: 25px;
        }

        .product-title {
          font-size: 24px;
          font-weight: 600;
          color: #1a1a1a;
          line-height: 1.4;
        }

        .product-price {
          font-size: 28px;
          font-weight: 700;
          color: #c9a76a;
        }

        .product-meta {
          display: flex;
          flex-direction: column;
          gap: 8px;
        }

        .meta-item {
          display: flex;
          gap: 10px;
          font-size: 14px;
        }

        .meta-item .label {
          font-weight: 600;
          color: #333;
        }

        .meta-item .value {
          color: #666;
        }

        .status-available {
          color: #27ae60 !important;
        }

        .product-options {
          display: flex;
          flex-direction: column;
          gap: 25px;
        }

        .option-group {
          display: flex;
          flex-direction: column;
          gap: 12px;
        }

        .option-group label {
          font-size: 15px;
          font-weight: 600;
          color: #333;
          display: flex;
          align-items: center;
          gap: 10px;
        }

        .size-guide {
          font-size: 13px;
          color: #1a3a52;
          text-decoration: none;
          font-weight: normal;
        }

        .color-options {
          display: flex;
          gap: 12px;
        }

        .color-option {
          width: 70px;
          height: 90px;
          border: 2px solid #ddd;
          border-radius: 6px;
          overflow: hidden;
          cursor: pointer;
          transition: all 0.3s;
        }

        .color-option.selected {
          border-color: #c9a76a;
          box-shadow: 0 0 0 1px #c9a76a;
        }

        .color-option img {
          width: 100%;
          height: 100%;
          object-fit: cover;
        }

        .size-options {
          display: flex;
          gap: 10px;
        }

        .size-btn {
          min-width: 60px;
          padding: 12px 20px;
          border: 1px solid #ddd;
          background: white;
          border-radius: 4px;
          cursor: pointer;
          font-size: 14px;
          font-weight: 500;
          transition: all 0.3s;
        }

        .size-btn:hover {
          border-color: #c9a76a;
        }

        .size-btn.selected {
          background: #c9a76a;
          color: white;
          border-color: #c9a76a;
        }

        .quantity-actions {
          display: flex;
          gap: 12px;
          align-items: center;
        }

        .quantity-control {
          display: flex;
          border: 1px solid #ddd;
          border-radius: 4px;
          overflow: hidden;
        }

        .quantity-control button {
          width: 40px;
          height: 48px;
          border: none;
          background: white;
          cursor: pointer;
          font-size: 18px;
          transition: background 0.3s;
        }

        .quantity-control button:hover {
          background: #f5f5f5;
        }

        .quantity-control input {
          width: 60px;
          height: 48px;
          border: none;
          border-left: 1px solid #ddd;
          border-right: 1px solid #ddd;
          text-align: center;
          font-size: 15px;
        }

        .btn-add-cart {
          flex: 1;
          padding: 14px 24px;
          background: #c9a76a;
          color: white;
          border: none;
          border-radius: 4px;
          font-size: 15px;
          font-weight: 600;
          cursor: pointer;
          transition: background 0.3s;
        }

        .btn-add-cart:hover {
          background: #b89660;
        }

        .btn-buy-now {
          padding: 14px 32px;
          background: white;
          color: #333;
          border: 2px solid #c9a76a;
          border-radius: 4px;
          font-size: 15px;
          font-weight: 600;
          cursor: pointer;
          transition: all 0.3s;
        }

        .btn-buy-now:hover {
          background: #c9a76a;
          color: white;
        }

        .product-description {
          padding-top: 20px;
          border-top: 1px solid #e0e0e0;
          display: flex;
          flex-direction: column;
          gap: 20px;
        }

        .desc-highlight {
          font-size: 15px;
          color: #666;
          font-style: italic;
          line-height: 1.6;
        }

        .desc-section h3 {
          font-size: 16px;
          font-weight: 600;
          color: #333;
          margin-bottom: 10px;
        }

        .desc-section ul {
          list-style: none;
          padding: 0;
        }

        .desc-section li {
          font-size: 14px;
          color: #666;
          line-height: 1.8;
          margin-bottom: 5px;
        }

        .made-in {
          font-size: 14px;
          color: #666;
          line-height: 1.6;
          white-space: pre-line;
        }

        .accordion {
          margin-top: 20px;
          border-top: 1px solid #e0e0e0;
        }

        .accordion-item {
          border-bottom: 1px solid #e0e0e0;
        }

        .accordion-header {
          width: 100%;
          padding: 18px 0;
          display: flex;
          justify-content: space-between;
          align-items: center;
          background: none;
          border: none;
          cursor: pointer;
          font-size: 15px;
          font-weight: 600;
          color: #1a3a52;
          text-align: left;
        }

        .accordion-content {
          padding: 0 0 20px;
          font-size: 14px;
          color: #666;
          line-height: 1.6;
        }

        .stores-list {
          display: flex;
          flex-direction: column;
          gap: 20px;
        }

        .store-item {
          padding: 15px;
          background: #f9f9f9;
          border-radius: 6px;
          border-left: 3px solid #c9a76a;
        }

        .store-header {
          display: flex;
          align-items: center;
          gap: 8px;
          margin-bottom: 8px;
          color: #1a3a52;
        }

        .store-address {
          font-size: 14px;
          color: #666;
          margin-bottom: 5px;
        }

        .store-hours {
          font-size: 13px;
          color: #999;
        }

        @media (max-width: 1024px) {
          .product-container {
            grid-template-columns: 1fr;
            gap: 40px;
          }

          .product-gallery {
            flex-direction: column-reverse;
          }

          .thumbnail-list {
            flex-direction: row;
          }
        }

        @media (max-width: 768px) {
          .product-page {
            padding: 15px 20px;
          }

          .quantity-actions {
            flex-wrap: wrap;
          }

          .btn-buy-now {
            width: 100%;
          }
        }
      `}</style>
    </div>
  );
};

export default ProductDetailPage