package org.springframework.samples.parchis_oca.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.parchis_oca.model.NamedEntity;
import org.springframework.samples.parchis_oca.player.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Game extends NamedEntity {

	@Column(name = "birth_date")        
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private ActionGame type;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Player owner;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.EAGER)
	private List<GameBoard> visits;

	
}
