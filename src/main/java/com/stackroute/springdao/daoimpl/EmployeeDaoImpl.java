package com.stackroute.springdao.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.springdao.dao.EmployeeDAO;
import com.stackroute.springdao.model.Employee;

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession(); //error
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		Query query = getCurrentSession().createQuery("from Employee order by postedDate");
		return query.list();
	}
	
	public boolean sendData(Employee employee) {
		session=sessionFactory.openSession();
		employee.setPostedDate(); 
		System.out.println("Error 1");
		session.save(employee); // error
		System.out.println("Error 2");
		sessionFactory.close();
		return true;
	}

	

}
