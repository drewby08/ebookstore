package com.ebook.service;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.User;

@Stateless
public class RegistrationService {
	
	@PersistenceContext(unitName="ebookJSF")
	EntityManager em;

public String register(User userEntity){
	
		Boolean check = true;
		
		//check all the userEntity fields
		if(userEntity.getAddress().equals("")||userEntity.getCreditcard().equals("")||userEntity.getEmail().equals("")||userEntity.getFirstname().equals("")||userEntity.getLastname().equals("")||userEntity.getPassword().equals(""))
		{
			check = false;
			
			//break early if empty boxes
			return check.toString();
		}
	
		//query DB for duplicate users
		Query q = em.createQuery("select u.firstname from User u where u.email=:email");
		q.setParameter("email", userEntity.getEmail());

		  List results = q.getResultList();
		  
		  if(results.size() > 0)
		  {
			  check = false;
		  }
		
		//if everything works persist the entity
		if(check){
			em.persist(userEntity);
		}
		
		return check.toString();
	}

}
