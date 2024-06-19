package com.example.demo.exception;

import com.example.demo.util.Messages;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String entity, Integer id) {
        super(String.format(Messages.getProperty("exception.entityNotFound.message"), entity, id.toString()));
    }
}

