package tlaq.com.backendV64.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailsRequest {
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
}