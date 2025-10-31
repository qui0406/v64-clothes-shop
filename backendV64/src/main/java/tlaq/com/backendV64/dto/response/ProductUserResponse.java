package tlaq.com.backendV64.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUserResponse {
    ProductResponse productResponse;
    UserResponse userResponse;
    String fullName;
    String email;
    String national;
    String phoneNumber;
    String addressDetails;
    String address;
    int quantity;
    LocalDateTime createdAt;
}
