package tlaq.com.backendV64.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tlaq.com.backendV64.entity.enums.Color;
import tlaq.com.backendV64.entity.enums.Status;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailsResponse {
    String id;
    String description;
    String material;
    String design;
    String standard;
    String sizeStandard;
    Float eo;
    Float mong;
    Float lai;
    Float suonTrong;
    Float suonNgoai;

    ProductResponse productResponse;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ProductResponse {
        String id;
        String name;
        BigDecimal price;
        Color color;
        boolean sex;
        Status status;
        TypeProductResponse typeProductResponse;
        List<ProductImageResponse> images;
    }
}