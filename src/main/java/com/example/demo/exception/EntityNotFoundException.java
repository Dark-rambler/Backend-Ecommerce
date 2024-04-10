package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String entity, Integer id) {
        super(String.format("%s with id %s not found", entity, id.toString()));
    }
}

