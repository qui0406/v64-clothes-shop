package tlaq.com.backendV64.services;

import org.springframework.web.multipart.MultipartFile;
import tlaq.com.backendV64.dto.request.ProductRequest;
import tlaq.com.backendV64.dto.response.ProductDetailsResponse;
import tlaq.com.backendV64.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request, List<MultipartFile> images);
    List<ProductResponse> getAllProduct();
    List<ProductResponse> getAllProductByCategory(String category);
    ProductResponse update(ProductRequest request, String productId);
    void delete(String productId);

    ProductDetailsResponse getProductDetails(String productId);

    List<ProductResponse> getFilterProductBySexAndTypeNameProduct(boolean sex, String typeNameProduct);
}
