package com.boot.jersey.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.jersey.dao.EmployeeRepository;
import com.boot.jersey.exception.ResourceNotFoundException;
import com.boot.jersey.model.Employee;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/api/v2")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository repository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employees")
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employees")
	public List<Employee> getAllEmployees(){
		return repository.findAll();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathParam("id") Long id) throws ResourceNotFoundException{
		Employee employee = repository.findById(id)
		.orElseThrow(()->  new ResourceNotFoundException("Employee not found with id : "+id));
		return ResponseEntity.ok().body(employee);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathParam("id") Long id, @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
		Employee employee = repository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Employee not found with id : "+id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		final Employee updatedEmployee =  repository.save(employee);
		
		return ResponseEntity.ok().body(updatedEmployee);
	}
	
	@DELETE
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Boolean> deleteEmployee(@PathParam("id") Long id) throws ResourceNotFoundException{
		Map<String, Boolean> resp = new HashMap();
		
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : "+id));
		
		repository.delete(employee);
		resp.put("deleted", Boolean.TRUE);
		
		return resp;
	}
	
}
