package com.ali.springBootrestApi.Dal;

import java.util.List;

import com.ali.springBootrestApi.Entities.City;

public interface ICityDal {
	List<City> GetAllCities();
	void add(City city);
	void delete(City city);
	City getById(int id);
	boolean cityExist(String name,String district);
}
