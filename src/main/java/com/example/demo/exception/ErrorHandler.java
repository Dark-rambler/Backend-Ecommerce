package com.example.demo.exception;

import com.example.demo.exception.response.ErrorResponse;
import com.example.demo.exception.response.FieldErrorModel;
import com.example.demo.exception.response.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ErrorHandler {

    /*
     * Error for Method not supported (Code: 405)
     * */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupportedException(HttpServletRequest req, Exception ex){
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        ErrorResponse response = new ErrorResponse(status.value(), status.name(), ex.getMessage(), req.getRequestURI() );
        return ResponseEntity.status(status).body(response);
    }

    /*
     * Error for message not readable  (Code: 400)
     * */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public  ResponseEntity<ErrorResponse> handlerMessageNotReadableException(HttpServletRequest req, Exception ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = new ErrorResponse(status.value(), status.name(), ex.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }

    /*
     *
     * */
    @ExceptionHandler(EntityNotFoundException.class)
    public  ResponseEntity<ErrorResponse> handlerEntityNotFoundException(HttpServletRequest req, Exception ex){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse response = new ErrorResponse(status.value(), status.name(), ex.getMessage(), req.getRequestURI());
        return ResponseEntity.status(status).body(response);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidException(
            MethodArgumentNotValidException ex) {

        List<FieldErrorModel> errors = ex.getBindingResult().getAllErrors().stream().map(fieldError -> {
            FieldErrorModel fieldErrorModel = new FieldErrorModel();
            fieldErrorModel.setCode(fieldError.getCode());
            fieldErrorModel.setMessage(fieldError.getDefaultMessage());
            fieldErrorModel.setField(((FieldError) fieldError).getField());
            return fieldErrorModel;
        }).toList();

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setCode(status.value());
        response.setErrors(errors);

        return ResponseEntity.status(status).body(response);
    }
}
