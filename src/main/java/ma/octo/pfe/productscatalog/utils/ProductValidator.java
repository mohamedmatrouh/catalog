package ma.octo.pfe.productscatalog.utils;

import ma.octo.pfe.productscatalog.exceptions.BusinessException;
import ma.octo.pfe.productscatalog.model.ProductBo;
import org.springframework.stereotype.Component;

import static ma.octo.pfe.productscatalog.holders.BusinessErrorCodes.*;

@Component
public class ProductValidator {
    public void validateProduct(ProductBo productBo){
        if (productBo.getName() == null || productBo.getName().isBlank())
            throw new BusinessException(PRODUCT_NAME_NOT_PROVIDED_EXCEPTION.getMessageKey(), PRODUCT_NAME_NOT_PROVIDED_EXCEPTION.getCode());

        if (productBo.getPeriodicPrice() == null)
            throw new BusinessException(PRODUCT_PERIODIC_PRICE_NOT_PROVIDED_EXCEPTION.getMessageKey(), PRODUCT_PERIODIC_PRICE_NOT_PROVIDED_EXCEPTION .getCode());

    }
}
