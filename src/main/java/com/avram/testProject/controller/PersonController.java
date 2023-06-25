package com.avram.testProject.controller;


import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.dto.response.CreatePersonResponse;
import com.avram.testProject.dto.response.DeletePersonResponse;
import com.avram.testProject.dto.response.GetAllPersonResponse;
import com.avram.testProject.dto.response.UpdatePersonResponse;
import com.avram.testProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @PostMapping(value = "/create/person", produces = "application/json")
    public CreatePersonResponse createPerson(@RequestBody PersonBean personBean) {
        return service.createPerson(personBean);
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public GetAllPersonResponse getAllPerson() {
        return service.getAllPersons();
    }

    @DeleteMapping("/delete/person/{id}")
    public DeletePersonResponse deletePerson(@PathVariable(name = "id") Integer id) {
        return service.deletePerson(id);
    }

    @PutMapping(value = "/person/update", produces = "application/json")
    public UpdatePersonResponse updatePerson(@RequestBody PersonBean personBean) {
        return service.updatePerson(personBean);
    }

    @PutMapping(value = "/add/personPet/{id}", produces = "application/json")
    public UpdatePersonResponse addPersonPets(@PathVariable(name = "id") Integer petIds, @RequestBody PersonBean personBean) {
        return service.addPetToPerson(petIds, personBean.getId());
    }
}
