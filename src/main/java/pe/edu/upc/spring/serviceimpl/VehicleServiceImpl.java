package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Vehicle;
import pe.edu.upc.spring.repository.iVehicleRepository;
import pe.edu.upc.spring.service.iVehicleService;

@Service
public class VehicleServiceImpl implements iVehicleService{

	@Autowired
	private iVehicleRepository dVehicle;
	
	@Override
	@Transactional
	public boolean createProperty(Vehicle vehicle) {
		Vehicle objVehicle = dVehicle.save(vehicle);
		if(objVehicle==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void deleteProperty(int idVehicle) {
		dVehicle.deleteById(idVehicle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicle> findById(int idVehicle) {
		return dVehicle.findById(idVehicle);
	}	
	
	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> findByClientId(int idClient) {
		return dVehicle.findByClientId(idClient);
	}
}
