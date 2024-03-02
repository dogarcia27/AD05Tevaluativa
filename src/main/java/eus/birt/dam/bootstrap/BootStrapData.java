
package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Driver;
import eus.birt.dam.repository.DriverRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private DriverRepository driverRepo;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		Driver driver1 = new Driver("Geraint", "Thomas",LocalDate.parse("1989-04-04"),"UK");
		driverRepo.save(driver1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of drivers: " + driverRepo.count());
			
	}
	
}