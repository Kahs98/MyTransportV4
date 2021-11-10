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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
	
	@Column(name="precio", nullable=false)
	private float price;
	
	@Column(name="hora_inicio", nullable=false)
	private LocalTime  start_time;
	
	@Column(name="duracion", nullable=false)
	private int duration;
	
	@Column(name="kit_limpieza_extra", nullable=false)
	private boolean extra_cleaning_kit;
	
	@Column(name="estado", nullable=false)
	private String state;
	
	@Transient
	private String card_owner_name;
	
	@Transient
	@Min(1111111111111L)
	@Max(9999999999999999L)
	private Long card_number;
	
	@Transient
	@Temporal(TemporalType.DATE)
	private Date expiration_date;
	
	@Transient
	@Size(min=3, max=3)
	private String cvv_card;
	
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

	public Reservation(int id_reservation, Date date, float price, LocalTime start_time, int duration,
			boolean extra_cleaning_kit, String state, String card_owner_name,
			@Min(1111111111111L) @Max(9999999999999999L) Long card_number, Date expiration_date,
			@Size(min = 3, max = 3) String cvv_card, CompanyService companyService, Vehicle vehicle,
			List<DetailReservation> listDetails) {
		super();
		this.id_reservation = id_reservation;
		this.date = date;
		this.price = price;
		this.start_time = start_time;
		this.duration = duration;
		this.extra_cleaning_kit = extra_cleaning_kit;
		this.state = state;
		this.card_owner_name = card_owner_name;
		this.card_number = card_number;
		this.expiration_date = expiration_date;
		this.cvv_card = cvv_card;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public boolean isExtra_cleaning_kit() {
		return extra_cleaning_kit;
	}

	public void setExtra_cleaning_kit(boolean extra_cleaning_kit) {
		this.extra_cleaning_kit = extra_cleaning_kit;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCard_owner_name() {
		return card_owner_name;
	}

	public void setCard_owner_name(String card_owner_name) {
		this.card_owner_name = card_owner_name;
	}

	public Long getCard_number() {
		return card_number;
	}

	public void setCard_number(Long card_number) {
		this.card_number = card_number;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getCvv_card() {
		return cvv_card;
	}

	public void setCvv_card(String cvv_card) {
		this.cvv_card = cvv_card;
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
