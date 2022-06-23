package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface GameActionRepository extends CrudRepository<GameAction, Integer> {

	Optional<GameAction> findById(Integer Id);
	
    Optional<GameAction> findByAction(@Param("action") String name) throws DataAccessException;


}
