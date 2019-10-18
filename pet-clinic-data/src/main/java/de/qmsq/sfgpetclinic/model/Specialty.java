package de.qmsq.sfgpetclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialites")
@Data
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;

}
