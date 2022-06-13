package ma.octo.pfe.productscatalog.startup;

import lombok.RequiredArgsConstructor;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerRangeDto;
import ma.octo.pfe.productscatalog.dtos.pricing.PricingPerVolumeDto;
import ma.octo.pfe.productscatalog.dtos.product.ProductDto;
import ma.octo.pfe.productscatalog.model.*;
import ma.octo.pfe.productscatalog.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Startup implements CommandLineRunner {

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ProductDto product1 = ProductDto.builder()
                .name("product1")
                .setupPrice(0.0)
                .periodicPrice(PricingDto.builder().price(100.0).type(PricingType.FIXED_AMOUNT).build())
                .build();
        productService.saveProduct(product1);

        PricingPerVolumeDto pricing2 = new PricingPerVolumeDto();
        pricing2.setPrice(100.0);
        pricing2.setType(PricingType.PER_VOLUME);
        pricing2.setVolume(10.0);
        pricing2.setUnit(VolumeUnit.GB);
        ProductDto product2 = ProductDto.builder()
                .name("product2")
                .setupPrice(15.2)
                .periodicPrice(pricing2)
                .build();
        productService.saveProduct(product2);

        PricingPerRangeDto pricing3 = new PricingPerRangeDto();
        pricing3.setPrice(100.0);
        pricing3.setType(PricingType.PER_RANGE);
        pricing3.setMax(10.0);
        pricing3.setMin(0.0);
        ProductDto product3 = ProductDto.builder()
                .name("product3")
                .setupPrice(55.3)
                .periodicPrice(pricing3)
                .build();
        productService.saveProduct(product3);
    }

}
