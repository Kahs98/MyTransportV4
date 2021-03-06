package pe.edu.upc.spring.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.Client;
import pe.edu.upc.spring.model.CustomUser;
import pe.edu.upc.spring.service.iAdminService;
import pe.edu.upc.spring.service.iCompanyServiceService;
import pe.edu.upc.spring.service.iClientService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
public class LoginController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iClientService cService;
	
	@Autowired
	private iCompanyServiceService csService;
	
	@Autowired
	private iAdminService aService;
	
	@RequestMapping("/")
    public String home (){
        return "index";
    }
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash, HttpSession httpSession) {
		if (principal != null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			CustomUser customUser = (CustomUser)authentication.getPrincipal();
			if(customUser.getTypeUserID() == 1) {
				Optional<Client> findedClient =cService.findByUserId(customUser.getUserID());
				Client client = findedClient.get();
				sesion.setClient(client);
				model.addAttribute("client", client);
				httpSession.setAttribute("nameUser", client.getName() + " " + client.getLastname());
				return "redirect:/reservation/list";
			} else {
				if (customUser.getTypeUserID() == 2) {
					Optional<CompanyService> findedCompanyService =csService.findByUserId(customUser.getUserID());
					CompanyService companyService = findedCompanyService.get();
					httpSession.setAttribute("nameUser", companyService.getName() + " " + companyService.getLastname());
					sesion.setCompanyService(companyService);
					return "redirect:/service/list";
				} else {
					Optional<Admin> findedAdmin =aService.findByUserId(customUser.getUserID());
					Admin admin = findedAdmin.get();
					httpSession.setAttribute("nameUser", admin.getName() + " " + admin.getLastname());
					sesion.setAdmin(admin);
					return "redirect:/admin/staff/list";
				}
			}
			
		}

		if (error != null) {
			model.addAttribute("error",
					"Error: Nombre de usuario o contrase??a incorrecta. Por favor vuelva a intentarlo.");
		}

		if (logout != null) {
			sesion.setCompanyService(new CompanyService());
			sesion.setClient(new Client());
			sesion.setAdmin(new Admin());
			model.addAttribute("success", "Ha cerrado sesi??n con ??xito!");
		}

		return "login";
	}
}
