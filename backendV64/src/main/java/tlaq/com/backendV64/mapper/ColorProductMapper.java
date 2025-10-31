package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import tlaq.com.backendV64.dto.request.ColorProductRequest;
import tlaq.com.backendV64.dto.response.ColorProductResponse;
import tlaq.com.backendV64.entity.ColorProduct;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorProductMapper {
    ColorProductResponse toProductResponse(ColorProduct product);
    ColorProduct toProduct(ColorProductRequest request);

    List<ColorProductResponse> toListProductResponse(List<ColorProduct> products);
}
