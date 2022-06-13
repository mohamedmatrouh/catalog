package ma.octo.pfe.productscatalog.repository;

import ma.octo.pfe.productscatalog.model.ProductBo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductBo, Long> {
    @Override
    Page<ProductBo> findAll(Pageable pageable);
}
