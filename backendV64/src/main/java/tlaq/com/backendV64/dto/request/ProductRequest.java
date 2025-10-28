package tlaq.com.backendV64.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    String name;
    String description;
    BigDecimal price;
    String status;
    boolean sex;
    String color;
    int quantity;
    String typeProductId;
    ProductDetailsRequest productDetails;
}