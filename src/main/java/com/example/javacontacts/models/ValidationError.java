package com.example.javacontacts.models;

/**
 * A model to report a validation error
 */
public class ValidationError {
    /**
     * The code (String) for the validation error
     */
    private String Code;

    /**
     * The message (String) fro the validation error
     */
    private String message;

    //Getters and Setters
    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Displays the current validation error
     *
     * @return The current validation error as a String
     */
    @Override
    public String toString() {
        return "ValidationError{" + "Code='" + Code + '\'' + ", message='" + message + '\'' + '}';
    }
}
