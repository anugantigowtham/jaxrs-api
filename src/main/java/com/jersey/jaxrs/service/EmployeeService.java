package com.jersey.jaxrs.service;

import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.jersey.jaxrs.dao.entities.Employee;

/**
 * 
 * @author Gowtham.anuganti
 *
 */
public class EmployeeService {

	private static Map<Long, Employee> empdata = new HashMap();

	/**
	 * adds default employees to map while intializing
	 */
	static {
		empdata.put(1L, new Employee("Naruto", 1L, Instant.now().toEpochMilli()));
		empdata.put(2L, new Employee("Shin Chan", 2L, Instant.now().toEpochMilli()));
	}

	/**
	 * 
	 * @return
	 */
	public static Collection<Employee> getAllEmployees() {
		return empdata.values();
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	public static Employee addEmployee(Employee employee) {
		if (employee.getId() != null) {
			return null;
		}
		employee.setId(empdata.size() + 1L);
		Employee addedEmp = empdata.put(empdata.size() + 1L, employee);
		return addedEmp;
	}

	/**
	 * 
	 * @param employee
	 * @return
	 */
	public static Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = null;
		if (empdata.get(employee.getId()) != null) {
			updatedEmployee = empdata.put(employee.getId(), employee);
		}
		return updatedEmployee;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Employee getEmployeeByID(Long id) {
		return empdata.get(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static boolean deleteEmployee(Long id) {
		empdata.remove(id);
		return true;
	}
}
