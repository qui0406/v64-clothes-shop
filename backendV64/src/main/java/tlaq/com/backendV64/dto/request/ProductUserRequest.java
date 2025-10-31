package tlaq.com.backendV64.dto.request;

import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUserRequest {
    String fullName;
    String email;
    String national;
    String phoneNumber;
    String addressDetails;
    String address;
    String productId;

    @Min(1)
    int quantity;
}
