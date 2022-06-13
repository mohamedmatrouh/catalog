package ma.octo.pfe.productscatalog.dtos.exceptions;

import lombok.*;
import ma.octo.pfe.productscatalog.holders.KeyValueError;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage implements Serializable {


    private String key = null;
    private Integer code = null;
    private String parent = null;
    private String[] parameters = null;


    public ErrorMessage(String key) {
        this.key = key;
    }

    public ErrorMessage(String key, String... parameters) {
        this.key = key;
        this.parameters = parameters;
    }

    public ErrorMessage(String key, Integer code) {
        this.key = key;
        this.code = code;
    }

    public ErrorMessage(KeyValueError keyValueError, String... parameters) {
        this.key = keyValueError.getMessageKey();
        this.code =  keyValueError.getCode();
        this.parameters = parameters;
    }

    public ErrorMessage(String key, Integer code, String... parameters) {
        this.key = key;
        this.code = code;
        this.parameters = parameters;
    }

}