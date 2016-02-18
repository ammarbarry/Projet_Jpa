package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
public abstract class Device {
	
	private long id;
	private String consoMoyenne;
	private Residence residence;

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
