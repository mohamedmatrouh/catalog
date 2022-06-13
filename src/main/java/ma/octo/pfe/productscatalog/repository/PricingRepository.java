package ma.octo.pfe.productscatalog.repository;

import ma.octo.pfe.productscatalog.model.PricingBo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<PricingBo, Long> {
}
