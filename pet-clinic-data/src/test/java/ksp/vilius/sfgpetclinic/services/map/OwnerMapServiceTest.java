package ksp.vilius.sfgpetclinic.services.map;

import ksp.vilius.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    final long ownerId = 1l;
    final String lastName = "Smith";

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        Owner owner = new Owner(ownerId, "", lastName, "asd", "asd", "asd", new HashSet<>());

        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void save() {
        long id = 2l;
        Owner owner2 = new Owner(id, "", lastName, "asd", "asd", "asd", new HashSet<>());
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner owner2 = ownerMapService.save(Owner.builder().build());
        assertNotNull(owner2);
        assertNotNull(owner2.getId());


    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());

    }
}