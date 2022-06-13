package ma.octo.pfe.productscatalog.exceptions.handler;

import lombok.RequiredArgsConstructor;
import ma.octo.pfe.productscatalog.dtos.exceptions.ErrorResponseDto;
import ma.octo.pfe.productscatalog.dtos.exceptions.SubErrorResponseDto;
import ma.octo.pfe.productscatalog.exceptions.BusinessException;
import ma.octo.pfe.productscatalog.utils.ApiMessageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.*;

import static ma.octo.pfe.productscatalog.holders.CommonApiErrorCodes.*;


@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    private final ApiMessageSource apiMessageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(BusinessException businessException) {
        logger.info("Handle BusinessException: {} ", businessException.getMessage());
        return ResponseEntity
                .badRequest()
                .body(buildResponseErrorFromBusinessException(businessException));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        logger.info("Handle DataIntegrityViolationException: illegal operation {} ", dataIntegrityViolationException.getMessage());
        return ResponseEntity
                .status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto(TECHNICAL_ERROR.getCode(), apiMessageSource.getMessage(TECHNICAL_ERROR.getMessageKey())));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        logger.info("Handle MethodArgumentNotValidException: {} ", ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(buildResponseErrorFromMethodArgumentNotValidException(ex));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorResponseDto> handleConstraintViolationException(ConstraintViolationException ex) {
        logger.info("Handle ConstraintViolationException: {} ", ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(buildResponseErrorFromConstraintViolationException(ex));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponseDto> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        logger.info("Handle MissingServletRequestParameterException: {} ", ex.getMessage());
        return ResponseEntity
                .badRequest()
                .body(buildResponseErrorFromMissingServletRequestParameterException(ex));
    }

    private ErrorResponseDto buildResponseErrorFromMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return ErrorResponseDto.builder()
                .code(MISSING_FIELD_ERROR.getCode())
                .message(apiMessageSource.getMessage(MISSING_FIELD_ERROR.getMessageKey()))
                .timestamp(new Date())
                .subErrors( new ArrayList<>())
                .build();
    }

    private ErrorResponseDto buildResponseErrorFromConstraintViolationException(ConstraintViolationException ex) {

        return ErrorResponseDto.builder()
                .code(FIELD_VALIDATION_ERROR.getCode())
                .message(apiMessageSource.getMessage(FIELD_VALIDATION_ERROR.getMessageKey()))
                .timestamp(new Date())
                .subErrors( Optional.of(ex.getConstraintViolations()
                                .stream()
                                .map(subError -> SubErrorResponseDto.builder()
                                        .message(subError.getMessage())
                                        .rejectedValue(subError.getInvalidValue() == null ? "null" :subError.getInvalidValue().toString())
                                        .build()
                                )
                                .toList()
                ).orElse(Collections.emptyList()))
                .build();
    }
    private ErrorResponseDto buildResponseErrorFromMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }

        return ErrorResponseDto.builder()
                .code(FIELD_VALIDATION_ERROR.getCode())
                .message(apiMessageSource.getMessage(FIELD_VALIDATION_ERROR.getMessageKey()))
                .timestamp(new Date())
                .subErrors( Optional.of(ex.getBindingResult().getAllErrors()
                        .stream()
                        .map(suberror -> SubErrorResponseDto.builder()
                                .message(suberror.getDefaultMessage())
                                .object(suberror.getObjectName())
                                .field(suberror.getObjectName())
                                .parent(suberror.getObjectName())
                                .rejectedValue(Arrays.toString(suberror.getArguments()))
                                .build()
                        )
                        .toList()
                ).orElse(Collections.emptyList()))
                .build();
    }


    private ErrorResponseDto buildResponseErrorFromBusinessException(BusinessException businessException) {
        return ErrorResponseDto.builder()
                .code(businessException.getErrorMessage().getCode())
                .message(apiMessageSource.getMessage(businessException.getErrorMessage().getKey()))
                .timestamp(new Date())
                .subErrors(
                        Optional.of(
                                businessException.getSubErrors()
                                        .stream()
                                        .map(suberror -> new SubErrorResponseDto(apiMessageSource.getMessage(suberror.getKey()), suberror.getParent()))
                                        .toList()
                        ).orElse(Collections.emptyList()))
                .build();
    }

}
