package com.controle.bedrane.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.controle.bedrane.dao.IDao;
import com.controle.bedrane.entities.Employee;
import com.controle.bedrane.entities.Information;
import com.controle.bedrane.entities.Service;
import com.controle.bedrane.repositories.EmployeeRepository;
import com.controle.bedrane.repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {

	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Service create(Service o) {
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		try {
			serviceRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Service update(Service o) {
		return serviceRepository.save(o);
	}

	@Override
	public List<Service> findAll() {
		return serviceRepository.findAll();
	}

	@Override
	public Service findById(Long id) {
		return serviceRepository.findById(id).orElse(null);

	}

//	public List<Information> getServicesChefCollaborateurs() {
//		
//
//		for (Service service : serviceRepository.findAll()) {
//			Information newInf = new Information();
//			newInf.setService(service);
//			List<Employee> employees= new Lis
//			for (Employee employee : employeeRepository.findByService(service)) {
//				if (employee.getChef() == null) {
//					newInf.setChef(employee);
//				}
//				else {
//					
//				}
//			}
//			
//
//		}
//		return null;
//
//	}
}
