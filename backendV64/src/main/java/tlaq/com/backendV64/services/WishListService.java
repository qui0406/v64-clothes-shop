package tlaq.com.backendV64.services;

import tlaq.com.backendV64.dto.request.WishListRequest;
import tlaq.com.backendV64.dto.response.WishListResponse;

import java.util.List;

public interface WishListService {
    WishListResponse create(WishListRequest request);
    void delete(String wishListId);
    List<WishListResponse> getWishListByUserId(String userId);
}
