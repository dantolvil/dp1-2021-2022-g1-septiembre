package org.springframework.samples.parchis_oca.repository;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.parchis_oca.model.Player;

public interface PlayerRepository extends Repository<Player, Integer> {

	void save(Player player) throws DataAccessException;

	Optional<Player> findById(String player);

}
