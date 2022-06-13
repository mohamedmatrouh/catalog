package ma.octo.pfe.productscatalog.dtos.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.octo.pfe.productscatalog.model.VolumeUnit;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingPerVolumeDto extends PricingDto  {
    @NotNull(message = "{volume.null.error}")
    private Double volume;

    @NotNull(message = "{volume.unit.null.error}")
    private VolumeUnit unit;
}
