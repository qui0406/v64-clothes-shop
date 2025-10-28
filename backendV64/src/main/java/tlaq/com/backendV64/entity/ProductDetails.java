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
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String description;

    String material;

    String design;
    String standard;

    @Column(name = "size_standard")
    String sizeStandard;

    Float eo;
    Float mong;
    Float lai;

    @Column(name = "suon_trong")
    Float suonTrong;

    @Column(name = "suon_ngoai")
    Float suonNgoai;

    @OneToOne(mappedBy = "productDetails")
    Product product;

}
