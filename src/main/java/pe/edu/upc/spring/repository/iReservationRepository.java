package pe.edu.upc.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reservation;

@Repository
public interface iReservationRepository extends JpaRepository<Reservation, Integer> {
	
	@Query("from Reservation r where r.companyService.id_company_service = :idCompanyService")
	List<Reservation> findByCompanyServiceId(@Param("idCompanyService") int idCompanyService);
	
	@Query("from Reservation r where r.vehicle.client.id_client = :idClient")
	List<Reservation> findByClientId(@Param("idClient") int idClient);
	
    List<Reservation> findByDate(Date date);
    
    Optional<Reservation> findById(int id);

}

