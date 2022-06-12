
package org.springframework.samples.parchis_oca.game;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;


public interface GameRepository extends Repository<Game, Integer> {

	Game findById(int id) throws DataAccessException;


	void save(Game game) throws DataAccessException;

}
