package {{ global_computed_inputs.base_package }}.infrastructure.exceptions.handler;

import {{ global_computed_inputs.base_package }}.infrastructure.exceptions.general.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                                   HttpServletRequest request) {

        var resourceNotFoundDetails = ResourceNotFoundDetails.builder()
                .title("Resource Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity(resourceNotFoundDetails, null, HttpStatus.NOT_FOUND);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception exception, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var exceptionDetails = ExceptionDetails.builder()
                .title(exception.getCause().getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .detail(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity(exceptionDetails, headers, status);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> unauthorizedException(Exception exception, UnauthorizedException ex) {

        var exceptionDetails = ExceptionDetails.builder()
                .title("Unauthorized")
                .status(HttpStatus.UNAUTHORIZED.value())
                .detail(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ResourceInternalServerErrorException.class)
    public ResponseEntity<Object> internalServerException(Exception exception, UnauthorizedException ex) {

        var exceptionDetails = ExceptionDetails.builder()
                .title("Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .detail(ex.getMessage())
                .timeStamp(LocalDateTime.now())
                .developerMessage(exception.getClass().getName())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
