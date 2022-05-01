package com.ali.springBootrestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ali.springBootrestApi.Entities.City;
import com.ali.springBootrestApi.Service.ICityService;

@RestController
@RequestMapping("/city-api")
public class CityController {
	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> getAllCities(){
		return cityService.GetAllCities();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody City city){
		cityService.add(city);
	}
	@PostMapping("/delete")
	public void delete(@RequestBody City city){
		cityService.delete(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id) {
		return cityService.getById(id);
	}

	@GetMapping("/cityExist")
	@ResponseBody
	public boolean cityCount(@RequestParam String name,String district) {
	    return cityService.cityExist(name,district);
	}
	
}
