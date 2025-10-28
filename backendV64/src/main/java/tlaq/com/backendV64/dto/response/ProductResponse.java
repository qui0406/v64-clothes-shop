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
public class ProductResponse {
    String id;
    String name;
    BigDecimal price;
    int quantity;
    Color color;
    boolean sex;
    Status status;
    TypeProductResponse typeProductResponse;
    List<ProductImageResponse> images;
}
