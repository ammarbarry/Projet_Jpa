/*******************************************************************************
 * Copyright (c) 2016 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.Chauffage;
import domain.Device;
import domain.EquipElectronic;
import domain.Personne;
import domain.Residence;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			Personne p1 = new Personne("name1", "lastname1", "mail1");
			Personne p2 = new Personne("name2", "lastname2", "mail2");
			Personne p3 = new Personne("name3", "lastname3", "mail3");
			manager.persist(p1);
			manager.persist(p2);
			manager.persist(p3);
			
			Residence r1 = new Residence(12, 1, p1);
			Residence r2 = new Residence(35, 2, p2);
			Residence r3 = new Residence(60, 5, p3);
			manager.persist(r1);
			manager.persist(r2);
			manager.persist(r3);
			
			Device c = new Chauffage();
			c.setConsoMoyenne("500kw/h");
			c.setResidence(r1);
			manager.persist(c);
			
			Device e = new EquipElectronic();
			e.setConsoMoyenne("600kw/h");
			e.setResidence(r2);
			manager.persist(e);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		String s = "SELECT e FROM Personne as e where e.name=:name";
		
		Query q = manager.createQuery(s,Personne.class);
		q.setParameter("name", "name1"); 
		
		@SuppressWarnings("unchecked")
		List<Personne> res = q.getResultList();
		
		System.err.println(res.size());
		System.err.println(res.get(0).getName());
//		
		manager.close();
		factory.close();
	}

}
