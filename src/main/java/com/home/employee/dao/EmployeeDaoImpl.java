package com.home.employee.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.employee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> listEmployee() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		return criteria.list();
	}

	@Override
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public void removeEmployee(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from Employee emp where emp.id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		logger.debug("updateEmployee: " + employee.toString());
		logger.info("updateEmployee: " + employee.toString());
		logger.error("updateEmployee: " + employee.toString());
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
	}

}
