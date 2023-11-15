package com.controle.bedrane.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.bedrane.dao.IDao;
import com.controle.bedrane.entities.Employee;
import com.controle.bedrane.repositories.EmployeeRepository;

@Service
public class EmployeeService implements IDao<Employee>{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee create(Employee o) {
		return employeeRepository.save(o) ;
	}

	@Override
	public boolean delete(Employee o) {
		try {
			employeeRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Employee update(Employee o) {
		return employeeRepository.save(o);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

}
