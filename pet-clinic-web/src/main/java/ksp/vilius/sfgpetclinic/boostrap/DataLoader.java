package ksp.vilius.sfgpetclinic.boostrap;

import ksp.vilius.sfgpetclinic.model.*;
import ksp.vilius.sfgpetclinic.services.OwnerService;
import ksp.vilius.sfgpetclinic.services.PetTypeService;
import ksp.vilius.sfgpetclinic.services.SpecialtiesService;
import ksp.vilius.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("brrrrrr");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("knifee");
        Speciality saveSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("wrum wrum");
        Speciality saveDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("124 hlrrew");
        owner1.setCity("miami");
        owner1.setTelephone("912383");
        ownerService.save(owner1);

        Owner.builder().address("add");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("ROSCO");
        owner1.getPets().add(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Bruhston");
        owner2.setAddress("124 hlrrew");
        owner2.setCity("miami");
        owner2.setTelephone("912383");
        ownerService.save(owner2);

        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatType);
        fionaCat.setOwner(owner2);
        fionaCat.setName("tarantino");
        fionaCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionaCat);


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadiology);


        Vet vet2 = new Vet();
        vet2.setFirstName("Axe");
        vet2.setLastName("HAxe");
        vetService.save(vet2);
        vet2.getSpecialities().add(saveSurgery);
    }

}
