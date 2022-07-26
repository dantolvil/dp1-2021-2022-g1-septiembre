package org.springframework.samples.parchis_oca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.GamePiece;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePieceRepository extends CrudRepository<GamePiece, Integer> {


}