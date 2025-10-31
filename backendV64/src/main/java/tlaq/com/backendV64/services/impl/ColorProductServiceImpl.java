package tlaq.com.backendV64.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tlaq.com.backendV64.dto.request.ColorProductRequest;
import tlaq.com.backendV64.dto.response.ColorProductResponse;
import tlaq.com.backendV64.entity.ColorProduct;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.ColorProductMapper;
import tlaq.com.backendV64.repository.ColorProductRepository;
import tlaq.com.backendV64.services.ColorProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ColorProductServiceImpl implements ColorProductService {
    ColorProductMapper colorProductMapper;
    ColorProductRepository colorProductRepository;

    @Override
    public ColorProductResponse create(ColorProductRequest request) {
        ColorProduct colorProduct = colorProductMapper.toProduct(request);
        colorProductRepository.save(colorProduct);
        return colorProductMapper.toProductResponse(colorProduct);
    }

    @Override
    public List<ColorProductResponse> getAll() {
        List<ColorProduct> colorProducts = colorProductRepository.findAll();
        return colorProductMapper.toListProductResponse(colorProducts);
    }

    @Override
    public void delete(String colorProductId) {
        ColorProduct colorProduct = colorProductRepository.findById(colorProductId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        colorProductRepository.delete(colorProduct);
    }
}
