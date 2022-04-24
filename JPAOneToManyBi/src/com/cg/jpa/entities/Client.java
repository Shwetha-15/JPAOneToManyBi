package com.cg.jpa.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client 
{
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		//create a new department
		Department department = new Department();
		department.setId(15);
		department.setName("Engineer");
		
		//create two instances of employees
		Employee e1 = new Employee();
		e1.setId(1015);
		e1.setName("Shwetha");
		e1.setSalary(50000);
		
		Employee e2 = new Employee();
		e2.setId(1016);
		e2.setName("Sumanth");
		e2.setSalary(45000);
		
		//add both employees to department
		department.addEmployee(e1);
		department.addEmployee(e2);
		
		//save department and its employees using entity manager
		em.persist(department);
		
		System.out.println("Added department along with two employees to database.");
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
