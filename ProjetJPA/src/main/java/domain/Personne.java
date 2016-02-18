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
package domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {
	
		
		private long id;
		private String name;
		private String lastname;
		private String mail;
		private Set<Residence> residence;

		public Personne() {
		}
		
		/**
		 * 
		 * @param name
		 * @param lastname
		 * @param mail
		 * @param residence
		 */
		public Personne(String name, String lastname, String mail) {
			super();
			this.name = name;
			this.lastname = lastname;
			this.mail = mail;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		@OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
		@Column
		@ElementCollection(targetClass=Residence.class)
		public Set<Residence> getResidences() {
			return residence;
		}

		public void setResidences(Set<Residence> residences) {
			this.residence = residences;
		}

		@Override
		public String toString() {
			return "Personne [id=" + id + ", name=" + name + ", lastname=" + lastname + ", mail=" + mail
					+ "]";
		}

		

}
