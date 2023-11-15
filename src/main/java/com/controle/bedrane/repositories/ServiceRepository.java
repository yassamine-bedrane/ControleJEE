package com.controle.bedrane.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.bedrane.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
