package com.bitlord.pos.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus( value = HttpStatus.CONFLICT )
public class DuplicateEntryException extends RuntimeException {


    public DuplicateEntryException(String message ) {
        super( message );
    }


    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }

}
