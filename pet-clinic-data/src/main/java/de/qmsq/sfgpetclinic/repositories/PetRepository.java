package de.qmsq.sfgpetclinic.repositories;

import de.qmsq.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
