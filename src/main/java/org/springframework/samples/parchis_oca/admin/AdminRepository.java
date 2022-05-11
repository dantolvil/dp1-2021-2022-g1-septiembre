package org.springframework.samples.parchis_oca.admin;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

    @Query(value = "SELECT a.* FROM Admins a JOIN Users u ON u.username = a.username WHERE a.username LIKE ?1", nativeQuery = true)
	Optional<Admin> findAdminByName(String n);
    
    
}
