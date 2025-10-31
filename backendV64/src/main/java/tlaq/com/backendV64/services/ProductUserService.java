package tlaq.com.backendV64.services;

import tlaq.com.backendV64.dto.request.ProductUserRequest;
import tlaq.com.backendV64.dto.response.ProductUserResponse;

public interface ProductUserService {
    ProductUserResponse create(ProductUserRequest request);
    ProductUserResponse getProductUser(String productId);
    void delete(String productId);
}
