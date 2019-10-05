package de.qmsq.sfgpetclinic.services;

import de.qmsq.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
