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

import domain.Personne;

public class PersonneDAO {
	
	EntityManagerFactory factory;
	EntityManager manager; 
	EntityTransaction tx; 
	
	public PersonneDAO() {
		factory = Persistence.createEntityManagerFactory("dev");
		manager = factory.createEntityManager();
		tx = manager.getTransaction();	
	}
	
	public JSONObject get(Personne personne){
		try {
			return new JSONObject()
					.put("id", personne.getId())
					.put("name", personne.getName())
					.put("lastname", personne.getLastname())
					.put("mail", personne.getMail())
					.put("residences", "null");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return toutes les personnes de la base de donn�es
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getPersonneAll() throws JSONException{
		
		String s = "SELECT e FROM Personne as e";
		Query q = manager.createQuery(s,Personne.class);
		List<Personne> res = q.getResultList();
		if (res.isEmpty()) {
			return null;
		} else {
			JSONArray json = new JSONArray();
			for(Personne p : res){
				json.put(get(p));
			}
			return json;
		}
		
	}
	
	
	
	

}
