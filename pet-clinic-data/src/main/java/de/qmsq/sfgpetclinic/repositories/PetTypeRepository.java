package de.qmsq.sfgpetclinic.repositories;

import de.qmsq.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
