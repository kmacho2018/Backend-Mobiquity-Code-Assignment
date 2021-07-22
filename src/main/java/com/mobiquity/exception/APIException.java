package com.mobiquity.exception;

/**
 * @author Juan Camacho
 * API Exception Class
 */
public class APIException extends Exception {

  public APIException(String message, Exception e) {
    super(message, e);
  }

  public APIException(String message) {
    super(message);
  }
}
