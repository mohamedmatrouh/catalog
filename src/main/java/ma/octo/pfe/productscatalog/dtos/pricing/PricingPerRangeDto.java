package ma.octo.pfe.productscatalog.dtos.pricing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PricingPerRangeDto extends PricingDto {
    @NotNull(message = "{range.min.null.error}")
    private Double min;

    @NotNull(message = "{range.max.null.error}")
    private Double max;
}
