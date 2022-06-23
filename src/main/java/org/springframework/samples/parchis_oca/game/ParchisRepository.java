package org.springframework.samples.parchis_oca.game;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParchisRepository extends CrudRepository<Parchis, Integer> {
	
    Parchis findById(int id) throws DataAccessException;

    List<Parchis> findAll() throws DataAccessException;


}