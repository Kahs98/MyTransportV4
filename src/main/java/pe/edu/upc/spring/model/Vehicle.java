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
@Table(name="Vehiculo")
public class Vehicle implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_vehicle;
	
	@Column(name="nombre", nullable=false, length=150)
	private String nameVehicle;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", nullable=false)
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="id_distrito", nullable=false)
	private District district;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int id_vehicle, String nameVehicle, Client client, District district) {
		super();
		this.id_vehicle = id_vehicle;
		this.nameVehicle = nameVehicle;
		this.client = client;
		this.district = district;
	}

	public int getId_vehicle() {
		return id_vehicle;
	}

	public void setId_vehicle(int id_vehicle) {
		this.id_vehicle = id_vehicle;
	}

	public String getNameVehicle() {
		return nameVehicle;
	}

	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	
}
