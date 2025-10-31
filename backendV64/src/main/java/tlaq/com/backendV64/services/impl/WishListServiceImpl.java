package tlaq.com.backendV64.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tlaq.com.backendV64.dto.request.WishListRequest;
import tlaq.com.backendV64.dto.response.WishListResponse;
import tlaq.com.backendV64.entity.WishList;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.WishListMapper;
import tlaq.com.backendV64.repository.WishListRepository;
import tlaq.com.backendV64.services.WishListService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class WishListServiceImpl implements WishListService {
    WishListMapper wishListMapper;
    WishListRepository wishListRepository;

    @Override
    public WishListResponse create(WishListRequest request) {
        WishList wishList = wishListMapper.toWishList(request);
        wishListRepository.save(wishList);
        return wishListMapper.toWishListResponse(wishList);
    }

    @Override
    public void delete(String wishListId) {
        WishList wishList = wishListRepository.findById(wishListId)
                .orElseThrow(() -> new AppException(ErrorCode.WISHLIST_NOT_FOUND));
        wishListRepository.delete(wishList);
    }

    @Override
    public List<WishListResponse> getWishListByUserId(String userId) {
        List<WishList> wishListByUserId = wishListRepository.findByUser_Id(userId);
        return wishListMapper.toWishListResponse(wishListByUserId);
    }
}
