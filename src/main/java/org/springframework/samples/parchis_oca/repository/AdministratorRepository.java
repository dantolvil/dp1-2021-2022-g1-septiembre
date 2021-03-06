package org.springframework.samples.parchis_oca.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

    @Query(value = "select a.* from Admins a join Users u on u.username = a.username where a.username like ?1", nativeQuery = true)
	Optional<Administrator> findAdminByName(String n);
    
    
}
