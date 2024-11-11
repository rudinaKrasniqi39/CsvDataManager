package com.example.csvdatamanager.exception;

public class CsvRecordNotFoundException extends RuntimeException {
    public CsvRecordNotFoundException(String message) {
        super(message);
    }
}
