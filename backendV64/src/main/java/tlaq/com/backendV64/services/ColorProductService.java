package tlaq.com.backendV64.services;

import tlaq.com.backendV64.dto.request.ColorProductRequest;
import tlaq.com.backendV64.dto.response.ColorProductResponse;

import java.util.List;

public interface ColorProductService {
    ColorProductResponse create(ColorProductRequest request);
    List<ColorProductResponse> getAll();
    void delete(String colorProductId);
}
