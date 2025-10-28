package tlaq.com.backendV64.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tlaq.com.backendV64.entity.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
}
