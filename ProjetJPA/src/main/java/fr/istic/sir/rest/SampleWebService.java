package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.Device;
import domain.EquipElectronic;
import domain.Residence;

@Path("/hello")
public class SampleWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
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

