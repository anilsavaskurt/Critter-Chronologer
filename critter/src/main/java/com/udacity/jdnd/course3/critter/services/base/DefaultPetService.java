package com.udacity.jdnd.course3.critter.services.base;

import com.udacity.jdnd.course3.critter.entities.Pet;

import java.util.List;

public interface DefaultPetService {

    List<Pet> getAllPets();
    List<Pet> getPetsByCustomerId(long customerId);
    Pet getPetById(long petId);
    Pet savePet(Pet pet, long ownerId);
}
