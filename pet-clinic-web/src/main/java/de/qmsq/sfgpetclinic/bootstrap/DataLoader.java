package de.qmsq.sfgpetclinic.bootstrap;

import de.qmsq.sfgpetclinic.model.Owner;
import de.qmsq.sfgpetclinic.model.Vet;
import de.qmsq.sfgpetclinic.services.OwnerService;
import de.qmsq.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Chriton");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Princess");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Cooke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuel L.");
        vet2.setLastName("Jackson");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
