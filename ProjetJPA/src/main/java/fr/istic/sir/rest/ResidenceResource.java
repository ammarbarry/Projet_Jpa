package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONException;
import jpa.ResidenceDAO;

@Path("/residence") 
public class ResidenceResource {
	
	@GET
	@Path("/api/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() throws JSONException{
		return new ResidenceDAO().getResidenceAll().toString();
	}
	
	@GET
	@Path("/api/get/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") long id) throws JSONException{
		return new ResidenceDAO().getResidenceById(id).toString();
	}
	
	@GET
	@Path("/api/get/personne/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByPersonneId(@PathParam("id") long id) throws JSONException{
		return new ResidenceDAO().getResidenceByPersonneId(id).toString();
	}
	

}
