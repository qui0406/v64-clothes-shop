package tlaq.com.backendV64.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tlaq.com.backendV64.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "type_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    String description;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> products;

}
