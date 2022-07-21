package org.springframework.samples.parchis_oca.player;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface PlayerRepository extends Repository<Player, Integer> {

	void save(Player owner) throws DataAccessException;

	Optional<Player> findById(String player);


}
