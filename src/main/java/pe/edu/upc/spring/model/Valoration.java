package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="valoracion")
public class Valoration implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_valoracion;
	
	@Column(name="comentario", nullable=false, length=200)
	private String comment;
	
	@Column(name="calificacion", nullable=false)
	private int calification;
	
	@ManyToOne
	@JoinColumn(name="id_client", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_company_service", nullable=false)
	private CompanyService company_service;

	public Valoration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valoration(int id_valoracion, String comment, int calification, Client client,
			CompanyService company_service) {
		super();
		this.id_valoracion = id_valoracion;
		this.comment = comment;
		this.calification = calification;
		this.client = client;
		this.company_service = company_service;
	}

	public int getId_valoracion() {
		return id_valoracion;
	}

	public void setId_valoracion(int id_valoracion) {
		this.id_valoracion = id_valoracion;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCalification() {
		return calification;
	}

	public void setCalification(int calification) {
		this.calification = calification;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CompanyService getCompany_service() {
		return company_service;
	}

	public void setCompany_service(CompanyService company_service) {
		this.company_service = company_service;
	}

	
	
		
}
