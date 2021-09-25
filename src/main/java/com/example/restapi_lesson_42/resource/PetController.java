package com.example.restapi_lesson_42.resource;

import com.example.restapi_lesson_42.entity.Pet;
import com.example.restapi_lesson_42.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/save")
    public ResponseEntity<Pet> save(@Valid @RequestBody Pet pet) {
       Pet save =  petService.save(pet);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Object> findById(long id) {
        Optional<Pet> pet = petService.findById(id);
        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/update")
    public ResponseEntity<Pet> updateNameById(long id, String name) {
        petService.updateName(id, name);
        Pet pet = petService.findById(id).get();
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(long id) {
        petService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
