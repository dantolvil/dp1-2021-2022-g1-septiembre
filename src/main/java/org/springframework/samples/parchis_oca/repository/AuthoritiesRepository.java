package org.springframework.samples.parchis_oca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.Authorities;



public interface AuthoritiesRepository extends  CrudRepository<Authorities, String>{
	
}
