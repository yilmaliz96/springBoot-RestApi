package com.ali.springBootrestApi.Dal;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ali.springBootrestApi.Entities.City;

@Repository
public class CityDal implements ICityDal {
	
	private EntityManager entityManager;

	@Autowired
	public CityDal(javax.persistence.EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> GetAllCities() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.save(city);
		
	}

	@Override
	public void delete(City city) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(city);	
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class,id);
		return city;
	}
	@Override
	@Transactional
	public boolean cityExist(String name, String district) {
		Session session = entityManager.unwrap(Session.class);
		boolean exists = (Long) session.createQuery("select count(*) from City where name = :name and district = :district").setParameter("name", name).setParameter("district", district).uniqueResult() > 0;
		return exists;
	}
}
