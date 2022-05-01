package com.ali.springBootrestApi.Entities;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="City")
public class City {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String countrycode;
	private String district;
	private Integer population;
	
	public City(Integer id, String name, String countrycode, String district, Integer population) {
		this.id = id;
		this.name = name;
		this.countrycode = countrycode;
		this.district = district;
		this.population = population;
	}
	
	public City() {}
	
	
}
