package ch.zli.m223.model;

import javax.validation.constraints.NotBlank;

public class Credential {

  @NotBlank
  private String email;

  @NotBlank
  private String passwort;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return passwort;
  }

  public void setPassword(String password) {
    this.passwort = password;
  }

}
