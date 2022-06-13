package ma.octo.pfe.productscatalog.dtos.exceptions;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubErrorResponseDto implements Serializable {

    private String object;
    private String parent;
    private String field;
    private String rejectedValue;
    private String message;

    public SubErrorResponseDto(String message, String parent) {
        this.parent = parent;
        this.message = message;
    }
}
