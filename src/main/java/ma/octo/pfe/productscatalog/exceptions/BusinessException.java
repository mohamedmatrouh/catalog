package ma.octo.pfe.productscatalog.exceptions;

import lombok.Getter;

import ma.octo.pfe.productscatalog.dtos.exceptions.ErrorMessage;
import ma.octo.pfe.productscatalog.holders.KeyValueError;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorMessage errorMessage;
    private final List<ErrorMessage> subErrors;

    public BusinessException(){
        super();
        errorMessage = new ErrorMessage();
        subErrors =  new ArrayList<>();
    }

    public BusinessException(KeyValueError keyValueError, String... args) {
        super(keyValueError.getMessageKey());
        errorMessage = new ErrorMessage(keyValueError.getMessageKey(), keyValueError.getCode(), args);
        subErrors =  new ArrayList<>();
    }

    public BusinessException(String key, String... args) {
        super(key);
        errorMessage = new ErrorMessage(key, args);
        subErrors =  new ArrayList<>();
    }

    public BusinessException(String key, Integer code, String... args) {
        super(key);
        errorMessage = new ErrorMessage(key, code, args);
        subErrors =  new ArrayList<>();
    }

    public BusinessException(String key, Integer code, List<ErrorMessage> subErrors,
                                String... args) {
        super(key);
        errorMessage = new ErrorMessage(key, code, args);
        this.subErrors = subErrors;
    }

    public BusinessException(KeyValueError keyValueError, List<ErrorMessage> subErrors,
                                String... args) {
        super(keyValueError.getMessageKey());
        errorMessage = new ErrorMessage(keyValueError.getMessageKey(), keyValueError.getCode(), args);
        this.subErrors = subErrors;

    }

}
