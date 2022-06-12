package org.springframework.samples.parchis_oca.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePieceRepository extends JpaRepository<GamePiece, Integer> {


}