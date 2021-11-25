package pe.edu.upc.spring.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iCompanyServiceService;
import pe.edu.upc.spring.service.iUserService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/company")
public class CompanyServiceController {
	
	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iCompanyServiceService csService;
	

	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("company", new CompanyService());
		return "/register/registerCompany";
	}
	
	@RequestMapping(value = "/registerCompany", method = RequestMethod.POST)
	public String registerCompany(@Valid @ModelAttribute("staff") CompanyService objCompanyService, BindingResult binRes,
			Model model) throws ParseException {
		if(binRes.hasErrors()) {
			return "register/registerCompany";
		} else {
			UserModel user = objCompanyService.getUser();
			user.setType_user(new TypeUser(2, "ROLE_Empresa_de_Servicio"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			Optional<UserModel> userRepeat = uService.findByUsernameRepeated(user.getUsername());
			if (userRepeat.isPresent()) {
				model.addAttribute("error",
						"Error: El nombre de usuario o contraseña ya existe. Por favor ingrese otros valores.");
				return "/register/registerCompany";
			}
			boolean flag = uService.createUser(user);
			if (flag) {
				objCompanyService.setUser(user);
				flag = csService.createCompanyService(objCompanyService);
			}
			if(flag) {
				return "redirect:/login";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/company/register";
			}
		}
	}
	@Secured("ROLE_Empresa_de_Servicio")
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("company", sesion.getCompanyService());
		return "/perfilCompany/view";
	}
	@Secured("ROLE_Empresa_de_Servicio")
	@RequestMapping("/edit")
	public String goPageEdit(Model model){
		model.addAttribute("company", sesion.getCompanyService());
		return "/perfilCompany/update";
	}
	@Secured("ROLE_Empresa_de_Servicio")
	@RequestMapping("/editCompany")
	public String editClient(@ModelAttribute (value="company") CompanyService objCompanyService, BindingResult binRes, Model model)throws ParseException{
		if(binRes.hasErrors()) {
			return "redirect:/company/edit";
		} else {
			boolean flag = csService.createCompanyService(objCompanyService);
			if(flag) {
				sesion.setCompanyService(objCompanyService);
				return "redirect:/company/view";
			} else {
				return "redirect:/company/edit";
			}
		}
	}
}
