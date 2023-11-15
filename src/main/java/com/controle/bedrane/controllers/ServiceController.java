package com.controle.bedrane.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.bedrane.entities.Service;
import com.controle.bedrane.services.ServiceService;


@RestController
@RequestMapping("/api/services")
@CrossOrigin
public class ServiceController {
	@Autowired
	private ServiceService serviceService;
	
	@GetMapping
	public List<Service> findAllServices(){
		return serviceService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findServiceById(@PathVariable Long id){
		Service service = serviceService.findById(id);
		if(service==null) {
			return new ResponseEntity<Object>("Service with id "+id+" not found",HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(service);
		
	}
	
	@PostMapping
	public Service createService(@RequestBody Service service) {
		service.setId(0L);
		return serviceService.create(service);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id,@RequestBody Service service) {
		Service service2 = serviceService.findById(id);
		if(service2==null) {
			return new ResponseEntity<Object>("Service with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		else {
			service.setId(id);
			return ResponseEntity.ok(serviceService.update(service));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteService(@PathVariable Long id){
		Service service = serviceService.findById(id);
		if(service==null) {
			return new ResponseEntity<Object>("Service with id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(serviceService.delete(service));
	}
}
