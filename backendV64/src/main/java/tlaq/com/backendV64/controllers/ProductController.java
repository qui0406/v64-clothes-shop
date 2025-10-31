package tlaq.com.backendV64.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.request.ProductRequest;
import tlaq.com.backendV64.dto.response.ProductResponse;
import tlaq.com.backendV64.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductController {
    ProductService productService;

    @GetMapping("/get-all-products")
    public ApiResponse<List<ProductResponse>> getAllProducts(){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.getAllProduct())
                .build();
    }

    @GetMapping("/filter-products")
    public ApiResponse<List<ProductResponse>> getFilterProduct(@RequestParam boolean sex,
                                                               @RequestParam String typeNameProduct){
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.getFilterProductBySexAndTypeNameProduct(sex, typeNameProduct))
                .build();
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<ProductResponse> createProduct(@ModelAttribute ProductRequest request,
                                                      @RequestParam("images") @Valid
                                                      List<MultipartFile> images){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request, images))
                .build();
    }

    @DeleteMapping("/delete/{productId}")
    public ApiResponse<Void> delete(@PathVariable String productId){
        productService.delete(productId);
        return ApiResponse.<Void>builder()
                .message("Product deleted")
                .build();
    }

}
