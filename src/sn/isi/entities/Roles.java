package sn.isi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Roles.findAll",query="SELECT r FROM Roles r"),
	@NamedQuery(name="Roles.findById",query="SELECT r FROM Roles r WHERE r.id=:id")
})
public class Roles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=200)
	private String nom;
	@ManyToMany(mappedBy="role")
	List<User> user=new ArrayList<>();
	public Roles() {
		super();
	}
	public Roles(int id, String nom, List<User> user) {
		super();
		this.id = id;
		this.nom = nom;
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	

}
