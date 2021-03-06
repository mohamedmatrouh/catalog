package ma.octo.pfe.productscatalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingPerRangeBo extends PricingBo {
    private Double min;
    private Double max;
}
