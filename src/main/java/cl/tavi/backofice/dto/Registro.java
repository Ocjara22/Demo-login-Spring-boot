package cl.tavi.backofice.dto;

import java.io.Serializable;
import java.util.List;

import cl.tavi.backofice.models.entity.Telefono;

public class Registro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4643461790890373452L;
	private String userName;
	private String email;
	private String password;
	
	private List<Telefono> phones;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
	
	
}
