package com.avram.testProject.service;

import com.avram.testProject.dto.bean.CreatePetResponse;
import com.avram.testProject.dto.bean.PetBean;
import com.avram.testProject.dto.request.CreatePetRequest;
import com.avram.testProject.dto.response.DeletePetResponse;
import com.avram.testProject.dto.response.GetAllPetResponse;
import com.avram.testProject.dto.response.UpdaterPetResponse;
import com.avram.testProject.model.Pet;
import org.springframework.stereotype.Service;
import util.BaseResponse;

import java.util.List;

@Service
public interface PetService {
    CreatePetResponse createPet(PetBean petBean);
    DeletePetResponse deletePet(Integer petId);
    void deletePetsByIds(List<PetBean> petBeans);

    UpdaterPetResponse updatePet(PetBean petBean);

    GetAllPetResponse getAllPetList();
    Pet getPetById(Integer petId);

    List<PetBean> getAllPetsByIds(List<Integer> ids);
}
