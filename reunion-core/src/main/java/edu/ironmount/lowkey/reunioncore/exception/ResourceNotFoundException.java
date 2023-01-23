package edu.ironmount.lowkey.reunioncore.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String content) {
        super(content);
    }
}
