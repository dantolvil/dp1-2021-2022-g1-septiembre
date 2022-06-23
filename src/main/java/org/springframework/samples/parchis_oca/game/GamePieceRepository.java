package org.springframework.samples.parchis_oca.game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePieceRepository extends CrudRepository<GamePiece, Integer> {


}