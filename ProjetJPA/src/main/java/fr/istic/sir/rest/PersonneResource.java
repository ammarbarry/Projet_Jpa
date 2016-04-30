package fr.istic.sir.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;

import domain.Personne;
import jpa.PersonneDAO;

@Path("/personne") 
public class PersonneResource {
	
	@GET
	//@Path("/api/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne>/*String*/ getAll() throws JSONException{
		//return new PersonneDAO().getPersonneAll().toString();
		PersonneDAO personDao = new PersonneDAO();
		return personDao.getPersonAll();
	}
	
	@GET
	@Path("/api/get/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") long id) throws JSONException{
		return new PersonneDAO().getPersonneById(id).toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Personne add(Personne person){
		System.out.println(person);
		PersonneDAO dao = new PersonneDAO();
		return dao.add(person);
	}
	
	

}
