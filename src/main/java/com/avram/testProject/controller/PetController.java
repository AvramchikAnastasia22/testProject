package com.avram.testProject.controller;


import com.avram.testProject.dto.bean.CreatePetResponse;
import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.dto.bean.PetBean;
import com.avram.testProject.dto.response.*;
import com.avram.testProject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping(value = "/create/pet", produces = "application/json")
    public CreatePetResponse createPet(@RequestBody PetBean petBean) {
        return petService.createPet(petBean);
    }

    @GetMapping(value = "/getAll/pets", produces = "application/json")
    public GetAllPetResponse getAllPets() {
        return petService.getAllPetList();
    }

    @DeleteMapping("/delete/pet/{id}")
    public DeletePetResponse deletePet(@PathVariable(name = "id") Integer id) {
        return petService.deletePet(id);
    }

    @PutMapping(value = "/update/pet", produces = "application/json")
    public UpdaterPetResponse updatePet(@RequestBody PetBean petBean) {
        return petService.updatePet(petBean);
    }

}
