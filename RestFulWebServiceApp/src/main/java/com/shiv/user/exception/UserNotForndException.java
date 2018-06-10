package com.shiv.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND )
public class UserNotForndException extends RuntimeException
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public UserNotForndException( String message )
    {
        super( message );
        System.out.println( "############### Inside UserNotForndException" );
    }

}
