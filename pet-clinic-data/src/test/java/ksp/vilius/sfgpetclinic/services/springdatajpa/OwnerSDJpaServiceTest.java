package ksp.vilius.sfgpetclinic.services.springdatajpa;

import ksp.vilius.sfgpetclinic.model.Owner;
import ksp.vilius.sfgpetclinic.repositories.OwnerRepository;
import ksp.vilius.sfgpetclinic.repositories.PetRepository;
import ksp.vilius.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final String lastName = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = new Owner(1l, "", lastName, "asd", "asd", "asd", new HashSet<>());
    }

    @Test
    void findByLastName() {


        when(service.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());

        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(new Owner(1l, "", lastName, "asd", "asd", "asd", new HashSet<>()));
        returnOwnerSet.add(new Owner(2l, "", lastName, "asd", "asd", "asd", new HashSet<>()));

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1l);

        assertNotNull(owner);

    }

    @Test
    void save() {

        Owner ownerToSave = new Owner(1l, "", lastName, "asd", "asd", "asd", new HashSet<>());

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(ownerToSave);
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());

    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(ownerRepository).deleteById(anyLong());
    }
}