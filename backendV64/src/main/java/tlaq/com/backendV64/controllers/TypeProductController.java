package tlaq.com.backendV64.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.request.TypeProductRequest;
import tlaq.com.backendV64.dto.response.TypeProductResponse;
import tlaq.com.backendV64.services.TypeProductService;

import java.util.List;

@RestController
@RequestMapping("/type-product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TypeProductController {
    TypeProductService typeProductService;

    @GetMapping("/get-all-type-products")
    public ApiResponse<List<TypeProductResponse>> getAllTypeProducts() {
        return ApiResponse.<List<TypeProductResponse>>builder()
                .result(typeProductService.getAllProducts())
                .build();
    }

    @PostMapping("/create")
    public ApiResponse<TypeProductResponse> create(@RequestBody TypeProductRequest request) {
        return ApiResponse.<TypeProductResponse>builder()
                .result(typeProductService.create(request))
                .build();
    }

    @DeleteMapping("/delete/{typeProductId}")
    public ApiResponse<Void> delete(@PathVariable String typeProductId) {
        typeProductService.delete(typeProductId);
        return ApiResponse.<Void>builder()
                .code(1000)
                .message("Success")
                .build();
    }

}
