package com.controle.bedrane.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;


public class Information {
	private Service service;
	private Employee chef;
	private List<Employee> collaborateurs;
	
	
	public Information() {
		super();
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Employee getChef() {
		return chef;
	}
	public void setChef(Employee chef) {
		this.chef = chef;
	}
	public List<Employee> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(List<Employee> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
	

}
