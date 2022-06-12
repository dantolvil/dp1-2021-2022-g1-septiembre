package org.springframework.samples.parchis_oca.player;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.parchis_oca.model.BaseEntity;
import org.springframework.samples.parchis_oca.player.PlayerRepository;


public interface PlayerRepository extends Repository<Player, Integer> {

	void save(Player owner) throws DataAccessException;


}
