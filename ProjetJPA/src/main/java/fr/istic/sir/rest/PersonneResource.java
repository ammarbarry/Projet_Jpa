package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;

import jpa.PersonneDAO;

@Path("/personne") 
public class PersonneResource {
	
	@GET
	@Path("/api/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() throws JSONException{
		return new PersonneDAO().getPersonneAll().toString();
	}
	
	

}
