package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Admin;
import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.UserModel;
import pe.edu.upc.spring.service.iAdminService;
import pe.edu.upc.spring.service.iCompanyServiceService;
import pe.edu.upc.spring.service.iUserService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private iUserService uService;
	
	@Autowired
	private iAdminService aService;
	
	@Autowired
	private iCompanyServiceService csService;
	
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("admin", new Admin());
		return "/admin/register";
	}
	
	@RequestMapping("/company/list")
	public String goPageListCompany(Map<String, Object> model) {
		model.put("listCompany", csService.listCompanyService());
		return "/adminLists/listCompany";
	}
	
	@RequestMapping("/company/active/{id}")
	public String activeCompanyService(@PathVariable int id, Model model, RedirectAttributes objRedir)
			throws ParseException 
			{
				Optional<CompanyService> objCompany= csService.findById(id);
				if (objCompany == null) {
					objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				}
				else {
					if(objCompany.isPresent()) {
						objCompany.ifPresent(o -> {
							o.setEnabled(true);
							csService.createCompanyService(o);
						});
					}
					
				}
				return "redirect:/admin/company/list";
			}
	
	@RequestMapping("/list")
	public String goPageListAdmin(Map<String, Object> model) {
		model.put("listAdmin", aService.listAdmin());
		return "/adminLists/listAdmin";
	}
	
	@RequestMapping("/registerAdmin")
	public String registerAdmin(@ModelAttribute Admin objAdmin, BindingResult binRes, Model model)throws ParseException{
		if (binRes.hasErrors()) {
			return "registerAdmin";
		} else {
			UserModel user = objAdmin.getUser();
			user.setType_user(new TypeUser(3, "Administrador"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			Optional<UserModel> userRepeat = uService.findByUsernameRepeated(user.getUsername());
			if (userRepeat.isPresent()) {
				model.addAttribute("error",
						"Error: El nombre de usuario o contraseña ya existe. Por favor ingrese otros valores.");
				return "/adminLists/registerAdmin";
			}
			boolean flag = uService.createUser(user);
			if(flag) {
				objAdmin.setUser(user);
				flag = aService.createAdmin(objAdmin);
			} 
			if (flag) {
				return "redirect:/admin/list";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/admin/register"; 
			}
			
		}
		
	}
	
}
