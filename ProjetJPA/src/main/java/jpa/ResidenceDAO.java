package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import domain.Residence;

public class ResidenceDAO {
	EntityManagerFactory factory;
	EntityManager manager; 
	EntityTransaction tx;
	
	public ResidenceDAO() {
		factory = Persistence.createEntityManagerFactory("dev");
		manager = factory.createEntityManager();
		tx = manager.getTransaction();	
	} 
	
	public JSONObject get(Residence residence){
		try {
			return new JSONObject()
					.put("id", residence.getId())
					.put("nbpiece", residence.getNbrePiece())
					.put("taille", residence.getTaille())
					.put("personne_id", residence.getPersonne().getId())
					.put("devices", "null");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getResidenceAll() throws JSONException{
		
		String s = "SELECT r FROM Residence as r";
		Query q = manager.createQuery(s,Residence.class);
		List<Residence> res = q.getResultList();
		if (res.isEmpty()) {
			return null;
		} else {
			JSONArray json = new JSONArray();
			for(Residence residence : res){
				json.put(get(residence));
			}
			return json;
		}
	 }
	
	public JSONArray getResidenceById(long id){
		String s = "SELECT r FROM Residence as r where r.id=:id";
		Query q = manager.createQuery(s,Residence.class);
		q.setParameter("id", id); 
		return new JSONArray().put(get((Residence) q.getSingleResult()));
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getResidenceByPersonneId(long personneId){
		String s = "SELECT r FROM Residence as r";
		Query q = manager.createQuery(s,Residence.class);
		List<Residence> res = q.getResultList();
		if (res.isEmpty()) {
			return null;
		} else {
			JSONArray json = new JSONArray();
			for(Residence residence : res){
				if(residence.getPersonne().getId() == personneId)
					json.put(get(residence));
			}
			return json;
		}
	}
	
	

}
