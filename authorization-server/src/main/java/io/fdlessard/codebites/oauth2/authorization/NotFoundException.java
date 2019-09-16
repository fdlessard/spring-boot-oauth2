package io.fdlessard.codebites.oauth2.authorization;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}