package tlaq.com.backendV64.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tlaq.com.backendV64.entity.ProductDetails;

import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, String> {
    Optional<ProductDetails> findByProductId(String productId);
}
