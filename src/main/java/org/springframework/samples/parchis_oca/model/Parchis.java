package org.springframework.samples.parchis_oca.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parchis")
public class Parchis extends GameBoard {
    

}
