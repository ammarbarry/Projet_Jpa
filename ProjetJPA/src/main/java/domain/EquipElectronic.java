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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EquipElectronic {

	private long id;
	private String consoMoyenne;
	private Residence residence;
	
	public EquipElectronic(){
	}
	
	/**
	 * 
	 * @param consoMoyenne
	 * @param residence
	 */
	public EquipElectronic(String consoMoyenne, Residence residence) {
		super();
		this.consoMoyenne = consoMoyenne;
		this.residence = residence;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConsoMoyenne() {
		return consoMoyenne;
	}

	public void setConsoMoyenne(String consoMoyenne) {
		this.consoMoyenne = consoMoyenne;
	}
	
	@ManyToOne
	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

}
