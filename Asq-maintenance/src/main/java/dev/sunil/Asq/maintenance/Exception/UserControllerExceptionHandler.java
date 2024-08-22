package dev.sunil.Asq.maintenance.Exception;

import dev.sunil.Asq.maintenance.dto.ExceptionHandlerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ExceptionHandlerDto> handleEmailAlreadyException(EmailAlreadyExistException e){
        ExceptionHandlerDto exceptionHandlerDto = new ExceptionHandlerDto(
                e.getMessage(),
               409
        );

        return new ResponseEntity<>(exceptionHandlerDto,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ExceptionHandlerDto> handleInvalidCredentialsException(InvalidCredentialsException e){
        ExceptionHandlerDto exceptionHandlerDto = new ExceptionHandlerDto(
                e.getMessage(),
                401
        );
        return  new ResponseEntity<>(exceptionHandlerDto,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidQuesAndAnswerDetails.class)
    public ResponseEntity<ExceptionHandlerDto> handleInvalidQnAException(InvalidQuesAndAnswerDetails e){
        ExceptionHandlerDto exceptionHandlerDto = new ExceptionHandlerDto(
                e.getMessage(),
                400
        );
        return  new ResponseEntity<>(exceptionHandlerDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionHandlerDto> handleUserNotFoundException(UserNotFoundException e){
        ExceptionHandlerDto exceptionHandlerDto = new ExceptionHandlerDto(
                e.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionHandlerDto,HttpStatus.NOT_FOUND);
    }
}
