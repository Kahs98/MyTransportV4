package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Vehicle;

public interface iVehicleService {
	
	public boolean createProperty(Vehicle vehicle);
	public void deleteProperty(int idVehicle);
	public Optional<Vehicle> findById(int idVehicle);
	public List<Vehicle> findByClientId (int idClient);
}
