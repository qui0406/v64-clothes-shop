package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tlaq.com.backendV64.dto.request.ProductImageRequest;
import tlaq.com.backendV64.dto.request.ProductRequest;
import tlaq.com.backendV64.dto.response.ProductImageResponse;
import tlaq.com.backendV64.dto.response.ProductResponse;
import tlaq.com.backendV64.entity.Product;
import tlaq.com.backendV64.entity.ProductImage;

import java.util.List;

@Mapper(componentModel = "spring", uses = { TypeProductMapper.class, ProductImageMapper.class })
public interface ProductMapper {

    @Mapping(source = "typeProduct", target = "typeProductResponse")
    @Mapping(source = "images", target = "images")
    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductRequest request);

    List<ProductResponse> toListProductResponse(List<Product> products);
}
