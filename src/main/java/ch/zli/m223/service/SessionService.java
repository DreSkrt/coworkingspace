package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Benutzer;
import ch.zli.m223.model.Credential;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class SessionService {

  @Inject
  BenutzerService benutzerService;

  public Response authenticate(Credential credential) {
    Optional<Benutzer> principal = benutzerService.findByEmail(credential.getEmail());
    try {
      if (principal.isPresent() && principal.get().getPasswort().equals(credential.getPassword())) {
        String token;
        if (this.benutzerService.findAll().size()<= 1){
        token = Jwt
            .issuer("https://zli.example.com/")
            .upn(credential.getEmail())
            .groups(new HashSet<>(Arrays.asList("User", "Admin")))
            .expiresIn(Duration.ofHours(12))
            .sign();
        }else{
        token = Jwt
            .issuer("https://zli.example.com/")
            .upn(credential.getEmail())
            .groups(new HashSet<>(Arrays.asList("Member")))
            .expiresIn(Duration.ofHours(12))
            .sign();
      }
        return Response
            .ok(principal.get())
            .cookie(new NewCookie("coworkingspace", token))
            .header("Authorization", "Bearer " + token)
            .build();
      }
    }
     catch (Exception e) {
      System.err.println("Couldn't validate password.");
    }

    return Response.status(Response.Status.FORBIDDEN).build();
  }
}
