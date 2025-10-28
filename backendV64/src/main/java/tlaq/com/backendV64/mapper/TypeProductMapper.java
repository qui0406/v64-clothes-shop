package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import tlaq.com.backendV64.dto.request.TypeProductRequest;
import tlaq.com.backendV64.dto.response.TypeProductResponse;
import tlaq.com.backendV64.entity.TypeProduct;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeProductMapper {
    TypeProductResponse toTypeProductResponse(TypeProduct typeProduct);
    TypeProduct toTypeProduct(TypeProductRequest request);

    List<TypeProductResponse> toListTypeProductResponse(List<TypeProduct> typeProducts);
}
