package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Vehicle;

@Repository
public interface iVehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	@Query("from Vehicle p where p.client.id_client=:idClient")
	List<Vehicle> findByClientId(int idClient);
}
