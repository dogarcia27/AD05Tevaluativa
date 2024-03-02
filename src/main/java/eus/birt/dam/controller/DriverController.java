package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Driver;
import eus.birt.dam.repository.DriverRepository;
import eus.birt.dam.repository.TeamRepository;

@Controller
@RequestMapping ("/drivers")
public class DriverController {

	@Autowired
	DriverRepository driverRepo;
	
	@Autowired
	TeamRepository teamRepo;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		driverRepo.deleteById(id);
		return "redirect:/drivers";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Driver driver = new Driver();
		model.addAttribute("driver", driver);
		model.addAttribute("teams", teamRepo.findAll());
		return "driverForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Driver driver) {
		driverRepo.save(driver);
		return "redirect:/drivers/";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("driver", driverRepo.findById(id));
		model.addAttribute("teams", teamRepo.findAll());
		return "driverForm";
	}
}