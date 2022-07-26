package org.springframework.samples.parchis_oca.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "admins")
public class Administrator extends Person{

}
