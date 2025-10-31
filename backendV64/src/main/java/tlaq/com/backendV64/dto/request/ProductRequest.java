package tlaq.com.backendV64.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tlaq.com.backendV64.entity.ColorProduct;

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
    boolean sex;
    String colorProductId;
    int quantity;
    String typeProductId;
    ProductDetailsRequest productDetails;
}