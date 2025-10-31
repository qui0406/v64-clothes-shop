package tlaq.com.backendV64.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.request.ProductUserRequest;
import tlaq.com.backendV64.dto.response.ProductUserResponse;
import tlaq.com.backendV64.services.ProductUserService;

@RestController
@RequestMapping("/product-users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductUserController {
    ProductUserService productUserService;

    @PostMapping("/create")
    public ApiResponse<ProductUserResponse> create(@RequestBody ProductUserRequest request){
        return ApiResponse.<ProductUserResponse>builder()
            .result(productUserService.create(request))
            .build();
    }

    @GetMapping("/get/{productId}")
    public ApiResponse<ProductUserResponse> get(@PathVariable String productId){
        return ApiResponse.<ProductUserResponse>builder()
                .result(productUserService.getProductUser(productId))
                .build();
    }

    @DeleteMapping("/delete/{productId}")
    public ApiResponse<Void> delete(String productId){
        productUserService.delete(productId);
        return ApiResponse.<Void>builder()
                .message("Product user has been deleted")
                .build();
    }
}
