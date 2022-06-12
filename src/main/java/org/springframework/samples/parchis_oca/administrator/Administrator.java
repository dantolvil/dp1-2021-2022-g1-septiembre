package org.springframework.samples.parchis_oca.administrator;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.samples.parchis_oca.model.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "admins")
public class Administrator extends Person{

}
