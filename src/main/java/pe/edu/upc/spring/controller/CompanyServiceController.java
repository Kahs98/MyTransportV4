package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.Schedule;
import pe.edu.upc.spring.model.TypeUser;
import pe.edu.upc.spring.model.User;
import pe.edu.upc.spring.service.iCompanyServiceService;
import pe.edu.upc.spring.service.iScheduleService;
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
	private iScheduleService sService;
	
	@Autowired
	private iUserService uService;
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("company", new CompanyService());
		return "/register/registerCompany";
	}
	
	@RequestMapping("/registerCompany")
	public String registerCompany (@ModelAttribute CompanyService objCompanyService, BindingResult binRes, Model model)throws ParseException{
		if(binRes.hasErrors()) {
			return "register";
		} else {
			User user = objCompanyService.getUser();
			user.setType_user(new TypeUser(2, "Empresa de Servicio"));
			user.setUsername(user.getUsername().trim());
			user.setPassword(user.getPassword().trim());
			boolean flag = uService.createUser(user);
			if (flag) {
				objCompanyService.setUser(user);
				flag = csService.createCompanyService(objCompanyService);
				if (flag) {
					Schedule schedule = new Schedule();
					schedule.setCompany_service(objCompanyService);
					flag = sService.createSchedule(schedule);
				}
			}
			if(flag) {
				return "redirect:/user/login";
			} else {
				model.addAttribute("errorMessage", "Ocurrio un error");
				return "redirect:/company/register"; 
			}
		}
	}
	
	@RequestMapping("/view")
	public String goPageView(Model model) {
		model.addAttribute("company", sesion.getCompanyService());
		return "/perfilCompany/view";
	}
	
	@RequestMapping("/edit")
	public String goPageEdit(Model model){
		model.addAttribute("company", sesion.getCompanyService());
		return "/perfilCompany/update";
	}
	
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
