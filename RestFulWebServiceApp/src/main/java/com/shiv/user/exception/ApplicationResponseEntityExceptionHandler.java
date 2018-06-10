package com.shiv.user.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ApplicationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler( Exception.class )
    public ResponseEntity<Object> handleApplicationException( Exception ex,
                                                              WebRequest request ) throws Exception
    {
        System.out.println( "############### Inside handleApplicationException" );
        ApplicationException exception = new ApplicationException( new Date(), ex.getMessage(), "SHiva Here" );

        return new ResponseEntity( exception, HttpStatus.INTERNAL_SERVER_ERROR );

    }

    @ExceptionHandler( UserNotForndException.class )
    public ResponseEntity<Object> userNotFoundApplicationException( Exception ex,
                                                                    WebRequest request ) throws Exception
    {
        System.out.println( "############### Inside userNotFoundApplicationException" );

        ApplicationException exception = new ApplicationException( new Date(), ex.getMessage(), "SHiva Here" );

        return new ResponseEntity( exception, HttpStatus.INTERNAL_SERVER_ERROR );

    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex,
                                                                HttpHeaders headers,
                                                                HttpStatus status,
                                                                WebRequest request )
    {

        ApplicationException exception = new ApplicationException( new Date(), ex.getMessage(), ex.getBindingResult().toString() );

        return new ResponseEntity( exception, HttpStatus.BAD_REQUEST );
    }

}
