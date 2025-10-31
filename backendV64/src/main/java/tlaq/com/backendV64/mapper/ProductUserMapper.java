package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import tlaq.com.backendV64.dto.request.ProductUserRequest;
import tlaq.com.backendV64.dto.response.ProductUserResponse;
import tlaq.com.backendV64.entity.ProductUser;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, UserMapper.class})
public interface ProductUserMapper {
    @Mappings({
            @Mapping(source = "product", target = "productResponse"),
            @Mapping(source = "user", target = "userResponse")
    })
    ProductUserResponse toProductUserResponse(ProductUser productUser);
    ProductUser toProductUser(ProductUserRequest request);
}
