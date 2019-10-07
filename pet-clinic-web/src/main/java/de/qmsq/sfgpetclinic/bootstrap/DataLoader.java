package de.qmsq.sfgpetclinic.bootstrap;

import de.qmsq.sfgpetclinic.model.Owner;
import de.qmsq.sfgpetclinic.model.Vet;
import de.qmsq.sfgpetclinic.services.OwnerService;
import de.qmsq.sfgpetclinic.services.VetService;
import de.qmsq.sfgpetclinic.services.map.OwnerServiceMap;
import de.qmsq.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Chriton");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fionna");
        owner2.setLastName("Princess");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Cooke");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Samuel L.");
        vet2.setLastName("Jackson");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
