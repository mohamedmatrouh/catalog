package ma.octo.pfe.productscatalog.dtos.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResponseDto implements Serializable {

    private Integer code;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private List<SubErrorResponseDto> subErrors;

    public ErrorResponseDto() {timestamp = new Date();}

    public ErrorResponseDto(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = new Date();
    }

}