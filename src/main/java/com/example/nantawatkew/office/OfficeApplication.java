package com.example.nantawatkew.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.nantawatkew.office.model.Department;
import com.example.nantawatkew.office.model.Employee;
import com.example.nantawatkew.office.model.Project;
import com.example.nantawatkew.office.repository.DepartmentRepository;
import com.example.nantawatkew.office.repository.EmployeeRepository;
import com.example.nantawatkew.office.repository.ProjectRepository;

@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {

	private static final Logger logger = 
		LoggerFactory.getLogger(OfficeApplication.class);

	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ProjectRepository projectRepository;
	
	
	

	public OfficeApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
			ProjectRepository projectRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.projectRepository = projectRepository;
	}


	@Override
	public void run (String... arg) throws Exception{
		Department dpm1 = new Department("IT");
		Department dpm2 = new Department("IGL");
		departmentRepository.saveAll(Arrays.asList(dpm1,dpm2));
		Project pj1 = new Project("นอน");
		Project pj2= new Project("นั่ง");
		projectRepository.saveAll(Arrays.asList(pj1,pj2));

		employeeRepository.save(new Employee("นันทวัฒน์", 15000, dpm1,pj1));
		employeeRepository.save(new Employee("สุรชาติ", 25000, dpm2,pj2));

		logger.info("-------- find NameAll -------------");
		for (Employee employee : employeeRepository.findAll()){
			logger.info("name : {}, salary : {}",
			employee.getName(),employee.getSalary() );
		}
		logger.info("-------- find Name -------------");
		for (Employee employee : employeeRepository.findByName("สุรชาติ")){
			logger.info("name : {} , salary : {}",
			employee.getName(),employee.getSalary());
		}

		logger.info("-------- find GreaterThan -------------");
		for (Employee employee : employeeRepository.findBySalaryGreaterThan(150)){
			logger.info("Name : {} , Salary : {}",
			employee.getName(),employee.getSalary());
		}

		logger.info("-------- find NameContaining -------------");
		for (Project project : projectRepository.findByNameContaining("")){
			logger.info("Project : {}", project.getName());
		}

		

	}


	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

}
