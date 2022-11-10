package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;



@Path("/buchung")
@Tag(name = "Members", description = "Handling of Buchungen")
public class BuchungController {
  
  @Inject
  BuchungService buchungService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all Buchungen.", 
      description = "Returns a list of all Buchungen."
  )
  public List<Buchung> index() {
      return buchungService.findAll();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Creates a new Buchung.", 
      description = "Creates a new Buchung and returns the newly added Buchung."
  )
  @PermitAll
  public Buchung create(Buchung buchung) {
     return buchungService.createBuchung(buchung);
  }

  @Path("/{id}")
  @DELETE
  @Operation(
      summary = "Deletes a Buchung.",
      description = "Deletes a Buchung by its id."
  )
  public void delete(@PathParam("id") Long id) {
      buchungService.deleteBuchung(id);
  }

  @Path("/{id}")
  @PUT
  @Operation(
      summary = "Updates a Buchung.",
      description = "Updates a Buchung by its id."
  )
  public Buchung update(@PathParam("id") Long id, Buchung buchung) {
      return buchungService.updateBuchung(id, buchung);
  }
}
