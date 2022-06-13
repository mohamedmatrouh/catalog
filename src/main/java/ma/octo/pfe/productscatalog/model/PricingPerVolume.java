package ma.octo.pfe.productscatalog.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingPerVolume extends PricingBo {
    private Double volume;
    private VolumeUnit unit;
}
