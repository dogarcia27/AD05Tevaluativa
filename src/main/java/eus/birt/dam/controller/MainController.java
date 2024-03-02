package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.DriverRepository;
import eus.birt.dam.repository.TeamRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private DriverRepository driverRepo;
	@Autowired
   	private TeamRepository teamRepo;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/drivers"})
	public String getCyclists(Model model) {
		model.addAttribute("drivers", driverRepo.findAll());
		return "drivers";
	}
	
	@GetMapping ({"/teams"})
	public String getTeams(Model model) {
		model.addAttribute("teams", teamRepo.findAll());
		return "teams";
	}
}
	

