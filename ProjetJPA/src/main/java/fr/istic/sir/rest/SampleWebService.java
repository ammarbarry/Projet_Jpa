package fr.istic.sir.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.Device;
import domain.EquipElectronic;
import domain.Personne;
import domain.Residence;

@Path("/hello")
public class SampleWebService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		//EntityTransaction tx = manager.getTransaction();
		
		String s = "SELECT e FROM Personne as e";
		
		Query q = manager.createQuery(s,Personne.class);
		//q.setParameter("name", "name1"); 
		
		@SuppressWarnings("unchecked")
		List<Personne> res = q.getResultList();
		StringBuilder result = new StringBuilder();
		for(Personne p : res){
			result.append(p.getId()+": name : "+p.getName()+" lastname : "+p.getLastname());
		}
		
		return result.toString();
	}
	
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Residence getResidence() {
		Residence h = new Residence();
		h.setTaille(5);
		Device h1 = new Chauffage();
		h1.setConsoMoyenne("500w");
		Device h2 = new EquipElectronic();
		h2.setConsoMoyenne("600w");
		//h.addDevice(h1);
		//h.addDevice(h2);
		return h;
	}

}

