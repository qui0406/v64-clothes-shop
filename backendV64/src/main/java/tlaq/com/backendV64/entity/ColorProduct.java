package tlaq.com.backendV64.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "color_product")
public class ColorProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
}
