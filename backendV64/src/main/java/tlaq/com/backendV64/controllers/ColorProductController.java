package tlaq.com.backendV64.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tlaq.com.backendV64.dto.ApiResponse;
import tlaq.com.backendV64.dto.request.ColorProductRequest;
import tlaq.com.backendV64.dto.response.ColorProductResponse;
import tlaq.com.backendV64.services.ColorProductService;

import java.util.List;

@RestController
@RequestMapping("/color-products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ColorProductController {
    ColorProductService colorProductService;

    @PostMapping("/create")
    public ApiResponse<ColorProductResponse> create(@RequestBody ColorProductRequest request){
        return ApiResponse.<ColorProductResponse>builder()
                .result(colorProductService.create(request))
                .build();
    }

    @GetMapping("/get-all")
    public ApiResponse<List<ColorProductResponse>> getAll(){
        return ApiResponse.<List<ColorProductResponse>>builder()
                .result(colorProductService.getAll())
                .build();
    }

    @DeleteMapping("/delete/{colorProductId}")
    public ApiResponse<Void> delete(String colorProductId){
        colorProductService.delete(colorProductId);
        return ApiResponse.<Void>builder()
                .message("Successfully deleted")
                .build();
    }
}
