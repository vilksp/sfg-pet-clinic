package ksp.vilius.sfgpetclinic.boostrap;

import ksp.vilius.sfgpetclinic.model.Owner;
import ksp.vilius.sfgpetclinic.model.Vet;
import ksp.vilius.sfgpetclinic.services.OwnerService;
import ksp.vilius.sfgpetclinic.services.VetService;
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
        owner1.setLastName("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Bruhston");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Axe");
        vet2.setLastName("HAxe");
        vetService.save(vet2);
    }

}
