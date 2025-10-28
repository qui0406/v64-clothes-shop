package tlaq.com.backendV64.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.response.ProductDetailsResponse;
import tlaq.com.backendV64.services.ProductService;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductDetailsController {
    ProductService productService;

    @GetMapping("/details/{id}")
    public ApiResponse<ProductDetailsResponse> getProductDetails(@PathVariable String id) {
        return ApiResponse.<ProductDetailsResponse>builder()
                .result(productService.getProductDetails(id))
                .build();

    }
}
