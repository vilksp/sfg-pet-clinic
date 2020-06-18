package ksp.vilius.sfgpetclinic.services;

import ksp.vilius.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);

  
}
