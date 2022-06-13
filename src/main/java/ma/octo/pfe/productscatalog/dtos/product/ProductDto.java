package ma.octo.pfe.productscatalog.dtos.product;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerRangeDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerVolumeDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    @NotNull(message = "{product.name.blank.error}")
    @NotBlank(message = "{product.name.blank.error}")
    private String name;

    @NotNull(message = "{product.setupPrice.error")
    private Double setupPrice = 0.0;

    @NotNull(message = "{product.pricing.error}")
    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXISTING_PROPERTY,
            property = "type",
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = PricingPerVolumeDto.class, name = "PER_VOLUME"),
            @JsonSubTypes.Type(value = PricingPerRangeDto.class, name = "PER_RANGE"),
            @JsonSubTypes.Type(value = PricingDto.class, name = "FIXED_AMOUNT")
    })
    private PricingDto periodicPrice;
}
