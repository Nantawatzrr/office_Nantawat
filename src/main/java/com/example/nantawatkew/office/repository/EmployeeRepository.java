package com.example.nantawatkew.office.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.nantawatkew.office.model.Employee;

public interface EmployeeRepository extends CrudRepository <Employee , Integer> {

}
