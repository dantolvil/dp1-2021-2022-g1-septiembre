package org.springframework.samples.parchis_oca.game;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;


public interface GameActionRepository extends Repository<GameAction, Integer> {


	void save(GameAction visit) throws DataAccessException;

	List<GameAction> findById(Integer Id);

}
