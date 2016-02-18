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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Residence {
	
	private long id;
	private double taille;
	private int nbrePiece;
	private Set<Chauffage> chauffages;
	private Set<EquipElectronic> equipElectronics;
	private Personne pers;
	
	public Residence(){
	}

	/**
	 * 
	 * @param taille
	 * @param nbrePiece
	 * @param chauffages
	 * @param equipElectronics
	 * @param personne
	 */
	public Residence(double taille, int nbrePiece, Personne personne) {
		super();
		this.taille = taille;
		this.nbrePiece = nbrePiece;
		this.pers = personne;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public int getNbrePiece() {
		return nbrePiece;
	}

	public void setNbrePiece(int nbrePiece) {
		this.nbrePiece = nbrePiece;
	}
	
	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Set<Chauffage> getChauffages() {
		return chauffages;
	}

	public void setChauffages(Set<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}
	
	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Set<EquipElectronic> getEquipElectronics() {
		return equipElectronics;
	}

	public void setEquipElectronics(Set<EquipElectronic> equipElectronics) {
		this.equipElectronics = equipElectronics;
	}

	@Override
	public String toString() {
		return "Residence [taille=" + taille + ", nbrePiece=" + nbrePiece + "]";
	}
	
	@ManyToOne
	public Personne getPersonne() {
		return pers;
	}

	public void setPersonne(Personne personne) {
		this.pers = personne;
	}

	
	
	

}