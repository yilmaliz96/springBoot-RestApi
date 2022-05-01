package com.ali.springBootrestApi.Service;

import java.util.List;

import com.ali.springBootrestApi.Entities.City;

public interface ICityService {
	List<City> GetAllCities();
	void add(City city);
	void delete(City city);
	City getById(int id);
	boolean cityExist(String name,String district);
	
}
