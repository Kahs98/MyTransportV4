package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Vehicle;

public interface iVehicleService {
	
	public boolean createVehicle(Vehicle vehicle);
	public void deleteVehicle(int idVehicle);
	public Optional<Vehicle> findById(int idVehicle);
	public List<Vehicle> findByClientId (int idClient);
}
