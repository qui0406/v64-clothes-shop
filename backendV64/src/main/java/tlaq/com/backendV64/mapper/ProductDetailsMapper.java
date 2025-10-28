package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import tlaq.com.backendV64.dto.request.ProductDetailsRequest;
import tlaq.com.backendV64.dto.response.ProductDetailsResponse;
import tlaq.com.backendV64.entity.ProductDetails;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductDetailsMapper {
    @Mapping(source = "product", target = "productResponse")
    ProductDetailsResponse toProductDetailsResponse(ProductDetails response);

}
