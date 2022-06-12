package org.springframework.samples.parchis_oca.game;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.parchis_oca.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gameActions")
public class GameAction extends BaseEntity {

	
	@Column(name = "visit_date")        
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;


	@NotEmpty
	@Column(name = "description")
	private String description;


	public GameAction() {
		this.date = LocalDate.now();
	}


}
