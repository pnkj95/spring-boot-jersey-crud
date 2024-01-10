package com.boot.jersey.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jersey.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
