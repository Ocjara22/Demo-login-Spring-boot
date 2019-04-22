package cl.tavi.backofice.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="telefonos")
public class Telefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5861859538488776507L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=50)
	private String number;
	
	@Column(length=10)
    private String citycode;
	
	@Column(length=10)
    private String contrycode;
    
	@Column()
    private Long idusuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdUsuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	@Override
	public String toString() {
		return "Telefono [id=" + id + ", number=" + number + ", citycode=" + citycode + ", contrycode=" + contrycode
				+ ", idusuario=" + idusuario + "]";
	} 
    
    
    

}
