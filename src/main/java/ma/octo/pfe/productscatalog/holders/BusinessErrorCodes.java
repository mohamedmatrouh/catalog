package ma.octo.pfe.productscatalog.holders;

public enum BusinessErrorCodes implements KeyValueError {

    PRODUCT_NOT_FOUND_EXCEPTION(1, "product.not.found.exception"),
    PRICE_NOT_PROVIDED_EXCEPTION(2, "price.not.provided.exception"),
    PRODUCT_NAME_NOT_PROVIDED_EXCEPTION(3, "product.name.not.provided.exception"),
    PRODUCT_PERIODIC_PRICE_NOT_PROVIDED_EXCEPTION(4, "product.periodic.price.not.provided.exception"),
    ;

    private final Integer code;
    private final String messageKey;

    BusinessErrorCodes(Integer code, String messageKey) {
        this.code = code;
        this.messageKey = messageKey;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessageKey() {
        return messageKey;
    }
}