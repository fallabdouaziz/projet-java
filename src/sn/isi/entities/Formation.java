package sn.isi.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Formation.findAll",query="SELECT f FROM Formation f"),
	@NamedQuery(name="Formation.findById",query="SELECT f FROM Formation f WHERE f.id=:id")
})
public class Formation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column
	private int duree;
	@ManyToMany(mappedBy="formations")
	private List<Lieu> lieux= new ArrayList<>();
	@ManyToOne
	private User user=new User();
	public Formation() {
		super();
	}
	public Formation(int id, String nom, Date dateDebut, int duree, List<Lieu> lieux, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.lieux = lieux;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public List<Lieu> getLieux() {
		return lieux;
	}
	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
