package pe.edu.upc.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.CompanyService;

@Repository
public interface iCompanyServiceRepository extends JpaRepository<CompanyService, Integer> {
	
	@Query("from CompanyService c where c.name like %:nameCompanyService%")
	List<CompanyService> searchByName(@Param("nameCompanyService") String nameCompanyService);
	
	@Query("from CleaningStaff c where c.user.id_user=:idUser")
	Optional<CompanyService> findByUserId(int idUser);
}
