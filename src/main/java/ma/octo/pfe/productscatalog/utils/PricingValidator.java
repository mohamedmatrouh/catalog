package ma.octo.pfe.productscatalog.utils;

import ma.octo.pfe.productscatalog.exceptions.BusinessException;
import ma.octo.pfe.productscatalog.model.PricingBo;
import org.springframework.stereotype.Component;

import static ma.octo.pfe.productscatalog.holders.BusinessErrorCodes.PRICE_NOT_PROVIDED_EXCEPTION;

@Component
public class PricingValidator {
    public void validatePricing(PricingBo pricingBo){
        if (pricingBo.getPrice() == null)
            throw new BusinessException(PRICE_NOT_PROVIDED_EXCEPTION.getMessageKey(), PRICE_NOT_PROVIDED_EXCEPTION.getCode());
    }
}
