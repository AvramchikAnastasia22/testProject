package com.avram.testProject.service;

import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.dto.response.CreatePersonResponse;
import com.avram.testProject.dto.response.DeletePersonResponse;
import com.avram.testProject.dto.response.GetAllPersonResponse;
import com.avram.testProject.dto.response.UpdatePersonResponse;
import com.avram.testProject.model.Person;
import org.springframework.stereotype.Service;
import util.BaseResponse;

import java.util.List;

@Service
public interface PersonService {
    CreatePersonResponse createPerson(PersonBean request);
    DeletePersonResponse deletePerson(Integer userId);
    UpdatePersonResponse updatePerson(PersonBean userBean);
    GetAllPersonResponse getAllPersons();
    Person getPersonById(Integer personId);
    UpdatePersonResponse addPetToPerson(Integer petId, Integer personId);
    BaseResponse deletePetFromUser(Integer petId, Integer userId);
}
