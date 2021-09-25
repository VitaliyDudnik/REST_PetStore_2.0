package com.example.restapi_lesson_42.repository;

import com.example.restapi_lesson_42.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Modifying
    @Query("update Pet u set u.name = :name where u.id = :id")
    void updatePetByName(@Param("id") long id, @Param("name") String name);
}
