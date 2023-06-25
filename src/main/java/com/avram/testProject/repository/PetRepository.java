package com.avram.testProject.repository;

import com.avram.testProject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    void deleteByIdIn(List<Integer> ids);

    List<Pet> findAllByIdIn(List<Integer> ids);
}
