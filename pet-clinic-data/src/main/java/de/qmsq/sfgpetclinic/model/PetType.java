package de.qmsq.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
@Data
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

}
