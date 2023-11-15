package com.controle.bedrane.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.bedrane.entities.Employee;
import com.controle.bedrane.entities.Service;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByService(Service service);

}
