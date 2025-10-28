package tlaq.com.backendV64.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tlaq.com.backendV64.dto.request.ProductRequest;
import tlaq.com.backendV64.dto.request.TypeProductRequest;
import tlaq.com.backendV64.dto.response.ProductDetailsResponse;
import tlaq.com.backendV64.dto.response.ProductResponse;
import tlaq.com.backendV64.entity.Product;
import tlaq.com.backendV64.entity.ProductDetails;
import tlaq.com.backendV64.entity.ProductImage;
import tlaq.com.backendV64.entity.TypeProduct;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.ProductDetailsMapper;
import tlaq.com.backendV64.mapper.ProductMapper;
import tlaq.com.backendV64.repository.ProductDetailsRepository;
import tlaq.com.backendV64.repository.ProductImageRepository;
import tlaq.com.backendV64.repository.ProductRepository;
import tlaq.com.backendV64.repository.TypeProductRepository;
import tlaq.com.backendV64.services.ProductService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductServiceImpl implements ProductService {
    ProductMapper productMapper;
    ProductDetailsMapper productDetailsMapper;
    ProductRepository productRepository;
    ProductDetailsRepository productDetailsRepository;
    ProductImageRepository productImageRepository;
    TypeProductRepository typeProductRepository;
    Cloudinary cloudinary;

    @Override
    public ProductResponse create(ProductRequest request, List<MultipartFile> images) {
        Product product = productMapper.toProduct(request);

        TypeProduct typeProduct = typeProductRepository.findById(request.getTypeProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));

        product.setTypeProduct(typeProduct);

        String id = (String.valueOf(System.currentTimeMillis()).substring(3)
                + java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5))
                .toUpperCase();

        product.setId(id);

        List<ProductImage> productImages = new ArrayList<>();

        if (images != null && !images.isEmpty()) {
            for (MultipartFile img : images) {
                try {
                    Map res = cloudinary.uploader().upload(img.getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                    String imageUrl = res.get("secure_url").toString();
                    ProductImage productImage = ProductImage.builder()
                            .image(imageUrl)
                            .build();
                    productImages.add(productImage);
                } catch (IOException ex) {
                    throw new AppException(ErrorCode.IMAGE_UPLOAD_ERROR);
                }
            }
        }else{
            throw new AppException(ErrorCode.IMAGE_IS_EMPTY);
        }

        product.setImages(productImages);
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductDetailsResponse getProductDetails(String productId) {
        ProductDetails productDetails = productDetailsRepository.findByProductId(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        return productDetailsMapper.toProductDetailsResponse(productDetails);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return productMapper.toListProductResponse(products);
    }

    @Override
    public List<ProductResponse> getAllProductByCategory(String category) {
        return List.of();
    }

    @Override
    public ProductResponse update(ProductRequest request, String productId) {
        return null;
    }

    @Override
    public void delete(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }
}
