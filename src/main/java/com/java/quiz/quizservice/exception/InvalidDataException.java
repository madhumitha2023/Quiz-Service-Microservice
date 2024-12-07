package com.java.quiz.quizservice.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String questionNotFound) {
        super(questionNotFound);
    }
}
