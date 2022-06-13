package ma.octo.pfe.productscatalog.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.octo.pfe.productscatalog.model.PricingBo;
import ma.octo.pfe.productscatalog.repository.PricingRepository;
import ma.octo.pfe.productscatalog.services.PricingService;
import ma.octo.pfe.productscatalog.utils.PricingValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PricingServiceImpl implements PricingService {

    private final PricingRepository pricingRepository;
    private final PricingValidator pricingValidator;

    @Override
    public PricingBo addPricing(PricingBo pricingBo) {

        pricingValidator.validatePricing(pricingBo);

        log.info(String.format("save pricing %s", pricingBo.getType().name()));
        return pricingRepository.save(pricingBo);
    }
}
