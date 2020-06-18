package ksp.vilius.sfgpetclinic.repositories;

import ksp.vilius.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
