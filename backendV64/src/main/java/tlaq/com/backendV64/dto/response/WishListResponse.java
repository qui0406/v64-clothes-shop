package tlaq.com.backendV64.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WishListResponse {
    ProductResponse productResponse;
    boolean like;
    LocalDateTime createdAt;
}
