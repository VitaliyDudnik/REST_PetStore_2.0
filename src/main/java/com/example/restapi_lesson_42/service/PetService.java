package com.example.restapi_lesson_42.service;

import com.example.restapi_lesson_42.repository.PetRepository;
import com.example.restapi_lesson_42.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Optional<Pet> findById(long id){
        return petRepository.findById(id);
    }

    public void updateName(long id, String name){
       petRepository.updatePetByName(id, name);
    }

    public void delete(long id) {
        petRepository.deleteById(id);
    }
}
