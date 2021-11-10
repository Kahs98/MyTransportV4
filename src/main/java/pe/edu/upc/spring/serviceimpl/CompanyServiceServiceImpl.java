package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.repository.iCompanyServiceRepository;
import pe.edu.upc.spring.service.iCompanyServiceService;

@Service
public class CompanyServiceServiceImpl implements iCompanyServiceService {
	
	@Autowired
	private iCompanyServiceRepository dCompanyService;

	@Override
	@Transactional
	public boolean createCompanyService(CompanyService companyService) {
		CompanyService objCompanyService = dCompanyService.save(companyService);
		if(objCompanyService==null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@Transactional
	public void deleteCompanyService(int idCompanyService) {
		dCompanyService.deleteById(idCompanyService);
	}

	@Override
	public Optional<CompanyService> findById(int idCompanyService) {
		return dCompanyService.findById(idCompanyService);
	}

	@Override
	public Optional<CompanyService> findByUserId(int idUser) {
		return dCompanyService.findByUserId(idUser);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompanyService> listCompanyService() {
		return dCompanyService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompanyService> searchCompanyService(String nameCompanyService) {
		return dCompanyService.searchByName(nameCompanyService);
	}
	
}
