package cl.tavi.backofice.models.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4219939141208645207L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100)
	private String username;
	
	@Column(length=100)
	private String name;
	
	@Column(unique=true, length=100)
	private String email;
	
	@Column(length=1000)
	private String password;
	
	//private List<Telefono> phones;
	
	//private List<Roles> roles;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", name=" + name + ", email=" + email + ", password="
				+ password + "]";
	}

	

	


}
