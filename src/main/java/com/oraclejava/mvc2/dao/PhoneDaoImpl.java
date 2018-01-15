package com.oraclejava.mvc2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oraclejava.mvc2.model.Phone;

@Repository
public class PhoneDaoImpl implements PhoneDao<Phone> {
	
	@PersistenceContext
	private EntityManager manager;
		
	
	public List<Phone> getAllEntity() {

		return manager.createQuery("from Phone").getResultList();
	}

	public List<Phone> findByField(String field, String find) {
		Query query = manager.createQuery("from Phone where " + field + "='" + find + "'");
		return query.getResultList();
	}

	@Transactional
	public void addEntity(Phone entity) {
		// TODO Auto-generated method stub
		manager.persist(entity);
		manager.flush();

	}

	@Transactional
	public void updateEntity(Phone entity) {
		// TODO Auto-generated method stub
		manager.merge(entity);
		manager.flush();
	}

	@Transactional
	public void removeEntity(Phone entity) {
		// TODO Auto-generated method stub
		manager.remove(entity);
		manager.flush();
	}

	@Transactional
	public void removeEntity(Integer id) {
		// TODO Auto-generated method stub
		Phone phone = manager.find(Phone.class, id);
		manager.remove(phone);
		manager.flush();
	}

}
