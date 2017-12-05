package com.jersey.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersey.jaxrs.entities.Employee;
import com.jersey.jaxrs.service.EmployeeService;

@Path("employees")
public class EmployeeController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getAllEmployees() {
		return constructJson(EmployeeService.getAllEmployees());
	}

	@GET
	@Path("/{empID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> getAllEmployeeByID(@PathParam(value = "empID") long empID) {
		return constructJson(EmployeeService.getEmployeeByID(empID));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> addEmployee(Employee employee) {
		Employee addEmployee = EmployeeService.addEmployee(employee);
		return constructJson(addEmployee);
	}

	@PUT
	@Path("/{empID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> updateEmployee(@PathParam(value = "empID") long empID, Employee employee) {
		employee.setId(empID);
		Employee updateEmployee = EmployeeService.updateEmployee(employee);
		return constructJson(updateEmployee);
	}

	@Path("/{empID}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Object> deleteEmployee(@PathParam(value = "empID") long empID) {
		EmployeeService.deleteEmployee(empID);
		return constructJson("Employee Deleted!");
	}

	private Map<String, Object> constructJson(Object obj) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("result", obj);
		hashMap.put("status", "200 OK");
		return hashMap;
	}

}
