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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.District;

import pe.edu.upc.spring.model.Vehicle;
import pe.edu.upc.spring.service.iDistrictService;
import pe.edu.upc.spring.service.iVehicleService;
import pe.edu.upc.spring.utils.Sesion;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private Sesion sesion;
	
	@Autowired
	private iVehicleService pService;
	
	@Autowired
	private iDistrictService dService;
	
	@RequestMapping("/list")
	public String goPageListVehicles(Map<String, Object> model) {
		model.put("listVehi", pService.findByClientId(sesion.getClient().getId_client()));
		return "/vehicle/listVehicles";
	}
	
	@RequestMapping("/register")
	public String goPageRegister(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		model.addAttribute("location", new District());
		model.addAttribute("listDistrict", dService.listDistrict());
		
		return "/vehicle/Vehicle";
	}
	
	@RequestMapping("/registerVehicle")
	public String register(@ModelAttribute Vehicle objVehicle, BindingResult binRes, Model model)
			throws ParseException
	{
		if (objVehicle.getClient()==null) {
			objVehicle.setClient(sesion.getClient());	
		}
		
		if (binRes.hasErrors()) {
			model.addAttribute("listDistrict", dService.listDistrict());
			return "/vehicle/Vehicle";}
		else {
			boolean flag = pService.createVehicle(objVehicle);
			if (flag)
				return "redirect:/vehicle/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/vehicle/register";
			}
		}
	}
	
	@RequestMapping("/delete")
	public String deleteVehicle(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.deleteVehicle(id);
				model.put("listVehi", pService.findByClientId(sesion.getClient().getId_client()));
			}
		}
		catch(Exception ex) {
			model.put("mensaje","El vehiculo no se puede eliminar, esta siendo utilizada en una reserva");
			model.put("listVehi", pService.findByClientId(sesion.getClient().getId_client()));
		}
		return "vehicle/listVehicles";
	}

	@RequestMapping("/edit/{id}")
	public String editVehicle(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException 
	{
		Optional<Vehicle> objVehicle = pService.findById(id);
		if (objVehicle == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/vehicle/list";
		}
		else {
			model.addAttribute("listDistrict", dService.listDistrict());
			if (objVehicle.isPresent())
				objVehicle.ifPresent(p -> model.addAttribute("vehicle", p));
			return "vehicle/vehicleUpdate";
		}
	}
}