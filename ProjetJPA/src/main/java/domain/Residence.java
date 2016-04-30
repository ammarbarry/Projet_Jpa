package domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Residence {
	
	private long id;
	private double taille;
	private int nbrePiece;
	private Set<Device> devices;
	private Personne personne;
	
	public Residence(){
		//this.devices = new HashSet<>();
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
		this.personne = personne;
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
	
	@Override
	public String toString() {
		return "Residence [taille=" + taille + ", nbrePiece=" + nbrePiece + "]";
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PERSON_ID")
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Set<Device> getDevices() {
		return devices;
	}

	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	public void addDevice(Device d) {
		devices.add(d);
	}
}
