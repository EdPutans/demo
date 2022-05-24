package com.hoxton.maven_spring_boot_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// Send a Response with an error, stacktrace and status.
public class QuoteError {
  public static ResponseEntity<Exception> create(String message, HttpStatus status){
      return ResponseEntity
      .status(status)
      .body(new Exception(message));
    }
}
