package de.qmsq.sfgpetclinic.bootstrap;

import de.qmsq.sfgpetclinic.model.Owner;
import de.qmsq.sfgpetclinic.model.Pet;
import de.qmsq.sfgpetclinic.model.PetType;
import de.qmsq.sfgpetclinic.model.Vet;
import de.qmsq.sfgpetclinic.services.OwnerService;
import de.qmsq.sfgpetclinic.services.PetTypeService;
import de.qmsq.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Chriton");
        owner1.setAddress("123 Marddi");
        owner1.setCity("New Orleans");
        owner1.setTelephone("666999");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Joanny");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Princess");
        owner2.setAddress("12 Fauborge");
        owner2.setCity("Paris");
        owner2.setTelephone("777777");

        Pet fionasCat = new Pet();
        fionasCat.setName("Gatta");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

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
