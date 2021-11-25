package pe.edu.upc.spring.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.UserModel;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Sesion {
	
	private UserModel user;
	private Client client;
	private CompanyService companyService;
	private Admin admin;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	
}
