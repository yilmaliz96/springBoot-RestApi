package com.ali.springBootrestApi.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ali.springBootrestApi.Dal.ICityDal;
import com.ali.springBootrestApi.Entities.City;

@Service
public class CityManager implements ICityService{
	
	private ICityDal cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> GetAllCities() {
		return cityDal.GetAllCities();
	}

	@Override
	@Transactional
	public void add(City city) {
		if(!cityExist(city.getName(),city.getDistrict())) {
			this.cityDal.add(city);
			System.out.println("City Added");
		}else {
			System.out.println("City Exist");
		}
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return cityDal.getById(id);
	}
	
	@Override
	@Transactional
	public boolean cityExist(String name,String district) {
		return this.cityDal.cityExist(name,district);
	}


	
}
