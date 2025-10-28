package tlaq.com.backendV64.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tlaq.com.backendV64.entity.enums.Color;
import tlaq.com.backendV64.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "product")
public class Product {
    @Id
    String id;
    String name;
    String description;
    BigDecimal price;

    @Enumerated(EnumType.STRING)
    Status status;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    boolean sex;

    @Enumerated(EnumType.STRING)
    Color color;
    int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_product_id", nullable = false)
    TypeProduct typeProduct;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    List<ProductImage> images;


    @JoinColumn(name = "product_details")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    ProductDetails productDetails;
}
