package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import tlaq.com.backendV64.dto.response.ProductImageResponse;
import tlaq.com.backendV64.entity.ProductImage;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {
    ProductImageResponse toProductImageResponse(ProductImage productImage);
}
