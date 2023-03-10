package enoca.task.enocatask.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.badRequest()
                .body(errors);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleException(GenericException exception) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getErrorMessage());

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(errors);
    }

    @ExceptionHandler(CompanyEmployeeNotFoundException.class)
    public ResponseEntity<?> handleException(CompanyEmployeeNotFoundException exception) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getErrorMessage());

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(errors);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<?> handleException(CompanyNotFoundException exception) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("message", exception.getErrorMessage());

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(errors);
    }
}