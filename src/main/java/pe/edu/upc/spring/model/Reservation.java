package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Reserva")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_reservation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	
	@Column(name="hora_inicio", nullable=false)
	private LocalTime  start_time;
	
	@Column(name="duracion", nullable=false)
	private int duration;
	
	
	@Column(name="estado", nullable=false)
	private String state;
	
	
	@ManyToOne
	@JoinColumn(name="id_company_service", nullable=false)
	private CompanyService companyService;
	
	@ManyToOne
	@JoinColumn(name="id_vehiculo", nullable=false)
	private Vehicle vehicle;
	
	@Transient
	private List<DetailReservation> listDetails;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int id_reservation, Date date, LocalTime start_time, int duration, String state,
			CompanyService companyService, Vehicle vehicle, List<DetailReservation> listDetails) {
		super();
		this.id_reservation = id_reservation;
		this.date = date;
		this.start_time = start_time;
		this.duration = duration;
		this.state = state;
		this.companyService = companyService;
		this.vehicle = vehicle;
		this.listDetails = listDetails;
	}

	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<DetailReservation> getListDetails() {
		return listDetails;
	}

	public void setListDetails(List<DetailReservation> listDetails) {
		this.listDetails = listDetails;
	}

	

	

}
