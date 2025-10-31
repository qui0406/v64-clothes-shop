package tlaq.com.backendV64.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tlaq.com.backendV64.dto.request.ProductUserRequest;
import tlaq.com.backendV64.dto.response.ProductUserResponse;
import tlaq.com.backendV64.entity.Product;
import tlaq.com.backendV64.entity.ProductUser;
import tlaq.com.backendV64.entity.User;
import tlaq.com.backendV64.exeptions.AppException;
import tlaq.com.backendV64.exeptions.ErrorCode;
import tlaq.com.backendV64.mapper.ProductUserMapper;
import tlaq.com.backendV64.repository.ProductRepository;
import tlaq.com.backendV64.repository.ProductUserRepository;
import tlaq.com.backendV64.repository.UserRepository;
import tlaq.com.backendV64.services.ProductUserService;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProductUserServiceImpl implements ProductUserService {
    ProductUserMapper productUserMapper;
    ProductUserRepository productUserRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    @Override
    public ProductUserResponse create(ProductUserRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        User user = userRepository.findById(userId).orElseThrow(() ->
                new AppException(ErrorCode.USER_NOT_EXISTED));
        Product product=  productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        ProductUser productUser = ProductUser.builder()
                .user(user)
                .product(product)
                .email(request.getEmail())
                .address(request.getAddress())
                .addressDetails(request.getAddressDetails())
                .phoneNumber(request.getPhoneNumber())
                .fullName(request.getFullName())
                .national(request.getNational())
                .quantity(request.getQuantity())
                .build();
        productUserRepository.save(productUser);
        return productUserMapper.toProductUserResponse(productUser);
    }

    @Override
    public ProductUserResponse getProductUser(String productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        ProductUser productUser = productUserRepository.findById(productId).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_FOUND));

        // Xac thuc ban co phai la nguoi mua don hang do moi duoc xem khong
        if(!productUser.getUser().getId().equals(userId)){
            throw new AppException(ErrorCode.UNAUTHORIZED);
        }

        return productUserMapper.toProductUserResponse(productUser);
    }

    @Override
    public void delete(String productId) {

    }
}
