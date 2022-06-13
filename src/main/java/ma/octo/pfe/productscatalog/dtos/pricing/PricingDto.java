package ma.octo.pfe.productscatalog.dtos.pricing;

import lombok.*;
import ma.octo.pfe.productscatalog.model.PricingType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricingDto {

    @NotNull(message = "{price.blank.error}")
    private Double price;

    @NotNull(message = "{type.blank.error}")
    @NotBlank(message = "{type.blank.error}")
    private PricingType type;
}
