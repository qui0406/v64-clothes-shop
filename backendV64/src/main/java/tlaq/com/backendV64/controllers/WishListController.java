package tlaq.com.backendV64.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.request.WishListRequest;
import tlaq.com.backendV64.dto.response.WishListResponse;
import tlaq.com.backendV64.services.WishListService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/wish-list")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class WishListController {
    WishListService wishListService;

    @PostMapping("/create")
    public ApiResponse<WishListResponse> create(@RequestBody WishListRequest wishListRequest) {
        return ApiResponse.<WishListResponse>builder()
                .result(wishListService.create(wishListRequest))
                .build();
    }

    @DeleteMapping("/delete/{wishListId}")
    public ApiResponse<Void> delete(String wishListId) {
        wishListService.delete(wishListId);
        return ApiResponse.<Void>builder()
                .message("Successfully deleted WishList")
                .build();
    }

    @GetMapping("/get-wish-list")
    public ApiResponse<List<WishListResponse>> getWishListByUserId(Principal principal) {
        return ApiResponse.<List<WishListResponse>>builder()
                .result(wishListService.getWishListByUserId(principal.getName()))
                .build();
    }
}
