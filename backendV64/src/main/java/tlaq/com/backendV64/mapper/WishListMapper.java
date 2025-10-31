package tlaq.com.backendV64.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tlaq.com.backendV64.dto.request.WishListRequest;
import tlaq.com.backendV64.dto.response.WishListResponse;
import tlaq.com.backendV64.entity.WishList;

import java.util.List;

@Mapper(componentModel = "spring", uses= {ProductMapper.class})
public interface WishListMapper {
    @Mapping(source = "product", target = "productResponse")
    WishListResponse toWishListResponse(WishList wishList);
    WishList toWishList(WishListRequest request);

    @Mapping(source = "product", target = "productResponse")
    List<WishListResponse> toWishListResponse(List<WishList> wishLists);
}
