package tlaq.com.backendV64.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tlaq.com.backendV64.dto.request.TypeProductRequest;
import tlaq.com.backendV64.dto.response.TypeProductResponse;
import tlaq.com.backendV64.entity.TypeProduct;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.TypeProductMapper;
import tlaq.com.backendV64.repository.TypeProductRepository;
import tlaq.com.backendV64.services.TypeProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TypeProductServiceImpl implements TypeProductService {
    TypeProductMapper typeProductMapper;
    TypeProductRepository typeProductRepository;

    @Override
    public TypeProductResponse create(TypeProductRequest request) {
        TypeProduct typeProduct = typeProductMapper.toTypeProduct(request);
        typeProductRepository.save(typeProduct);
        return typeProductMapper.toTypeProductResponse(typeProduct);
    }

    @Override
    public List<TypeProductResponse> getAllProducts() {
        List<TypeProduct> typeProducts = typeProductRepository.findAll();
        return typeProductMapper.toListTypeProductResponse(typeProducts);
    }

    @Override
    public void delete(String typeProductId) {
        TypeProduct  typeProduct = typeProductRepository.findById(typeProductId)
                .orElseThrow(() -> new AppException(ErrorCode.TYPE_PRODUCT_NOT_FOUND));
        typeProductRepository.delete(typeProduct);
    }
}
