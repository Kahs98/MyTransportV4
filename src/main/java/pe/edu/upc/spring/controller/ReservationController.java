package pe.edu.upc.spring.controller;

import java.util.ArrayList;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.utils.Sesion;



import pe.edu.upc.spring.model.CompanyService;
import pe.edu.upc.spring.model.DetailReservation;
import pe.edu.upc.spring.model.Reservation;
import pe.edu.upc.spring.model.Room;
import pe.edu.upc.spring.service.iReservationService;
import pe.edu.upc.spring.service.iDetailReservationService;
import pe.edu.upc.spring.service.iRoomService;
import pe.edu.upc.spring.service.iVehicleService;



@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private Sesion sesion;

	@Autowired
	private iReservationService rService;

	@Autowired
	private iVehicleService pService;

	@Autowired
	private iDetailReservationService dService;



	@Autowired
	private iRoomService roService;

	

	//List<Parameter> listParameters = new ArrayList<Parameter>();
	List<DetailReservation> listDetailReservation = new ArrayList<DetailReservation>();
	List<CompanyService> listCompanyService= new ArrayList<CompanyService>();

	private Reservation reservation;
	

	@RequestMapping("/list")
	public String listReservationByClient(Map<String, Object> model) {
		model.put("listReservations", rService.listByClient(sesion.getClient().getId_client()));
		return "/reservation/list";
	}

	@RequestMapping("/view/{id}")
	public String goPageView(@PathVariable int id, Model model, RedirectAttributes objRedir,
			Map<String, Object> modelList) throws ParseException {
		Optional<Reservation> objRes = rService.findById(id);
		if (objRes == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reservation/list";
		} else {
			if (objRes.isPresent())
				objRes.ifPresent(o -> model.addAttribute("reservation", o));

			modelList.put("listDetailsReservation", dService.listByReservation(id));

			return "reservation/view";
		}
	}

	@RequestMapping("/goRegister")
	public String goPageCreate(Model model) {
		Reservation reservation = new Reservation();

		List<Room> listRoom = roService.listRooms();
		 for (int i = 0; i < listRoom.size(); i++) {
	         DetailReservation detail = new DetailReservation();
	         detail.setRoom(listRoom.get(i));
	         listDetailReservation.add(detail);
	     }
		reservation.setListDetails(this.listDetailReservation);

		model.addAttribute("listCompanyService", listCompanyService);
		model.addAttribute("listVehicle", pService.findByClientId(sesion.getClient().getId_client()));
		//listParameters = paService.list();
		
		this.reservation = reservation;
		model.addAttribute("reservation", reservation);
		return "/reservation/create";
	}



	

	@RequestMapping("/register")
	public String register(Model model, BindingResult binRes) throws ParseException {
		if (binRes.hasErrors()) {
			return "reservation";
		} else {

			boolean flag = true;
			flag = rService.createReservation(this.reservation);

			for (int i = 0; i < this.listDetailReservation.size(); i++) {
				flag = dService.createDetailReservation(this.listDetailReservation.get(i));
			}

			if (flag)
				return "redirect:/reservation/list";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reservation/list";
			}
		}
	}


}
