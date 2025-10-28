package tlaq.com.backendV64.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tlaq.com.backendV64.entity.TypeProduct;

import java.util.Optional;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, String> {
    Optional<TypeProduct> findByName(String name);
}
