package org.springframework.samples.parchis_oca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.User;


public interface UserRepository extends  CrudRepository<User, String>{
	
}
