package com.bitlord.pos.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class EntryNotFoundException extends RuntimeException {


    public EntryNotFoundException( String message ) {
        super( message );
    }


    public EntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
