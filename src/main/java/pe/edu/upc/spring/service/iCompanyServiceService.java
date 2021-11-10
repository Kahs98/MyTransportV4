package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.CompanyService;

public interface iCompanyServiceService {
	public boolean createCompanyService(CompanyService companyService);
	public void deleteCompanyService(int idCompanyService);
	public Optional<CompanyService> findById(int idCompanyService);
	public Optional<CompanyService> findByUserId(int idUser);
	public List<CompanyService> listCompanyService();
	public List<CompanyService> searchCompanyService(String nameCompanyService);
}
