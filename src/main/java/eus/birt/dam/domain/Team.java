package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String city;
	
	@Column
	private String nationality;
	
	@Column
	private String manager;
	
	
	@OneToMany (mappedBy = "team",cascade = CascadeType.ALL)
	List <Driver> drivers = new ArrayList<>();

	public Team(String name, String city, String nationality, String manager) {
		super();
		this.name = name;
		this.city = city;
		this.nationality = nationality;
		this.manager = manager;
	}
	
	
}
