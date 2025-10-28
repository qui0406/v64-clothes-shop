package tlaq.com.backendV64.services;

import tlaq.com.backendV64.dto.request.TypeProductRequest;
import tlaq.com.backendV64.dto.response.TypeProductResponse;

import java.util.List;

public interface TypeProductService {
    TypeProductResponse create(TypeProductRequest request);
    List<TypeProductResponse> getAllProducts();
    void delete(String typeProductId);

}
