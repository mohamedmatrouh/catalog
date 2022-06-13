package ma.octo.pfe.productscatalog.holders;

public enum CommonApiErrorCodes implements KeyValueError {

    MISSING_FIELD_ERROR(0, "field.missing.error"),
    TECHNICAL_ERROR(500, "technical.error"),
    FIELD_VALIDATION_ERROR(1, "field.validation.error"),
    ;

    private final Integer code;
    private final String messageKey;

    CommonApiErrorCodes(Integer code, String messageKey) {
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