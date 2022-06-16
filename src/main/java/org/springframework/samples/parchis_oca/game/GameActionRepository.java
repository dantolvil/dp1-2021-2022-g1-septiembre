package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


public interface GameActionRepository extends Repository<GameAction, Integer> {


	void save(GameAction gameAction) throws DataAccessException;

	Optional<GameAction> findById(Integer Id);
	
    Optional<GameAction> findByAction(@Param("action") String name) throws DataAccessException;


}
