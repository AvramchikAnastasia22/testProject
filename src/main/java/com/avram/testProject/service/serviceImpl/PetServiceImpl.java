package com.avram.testProject.service.serviceImpl;

import com.avram.testProject.dto.bean.CreatePetResponse;
import com.avram.testProject.dto.bean.PetBean;
import com.avram.testProject.dto.request.CreatePetRequest;
import com.avram.testProject.dto.response.DeletePetResponse;
import com.avram.testProject.dto.response.GetAllPetResponse;
import com.avram.testProject.dto.response.UpdaterPetResponse;
import com.avram.testProject.model.Pet;
import com.avram.testProject.repository.PetRepository;
import com.avram.testProject.service.PetService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.BaseResponse;
import util.PetMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;


    @Override
    public CreatePetResponse createPet(PetBean petBean) {
       Pet pet = PetMapper.petBeanToPet(petBean);
        if(Objects.nonNull(pet)) {
            Pet petSave = petRepository.save(pet);

            return new CreatePetResponse(200, "Pet was created", PetMapper.petToPetBean(petSave));
        }
        return new CreatePetResponse(400, "Pet in request was null");
    }

    @Override
    public DeletePetResponse deletePet(Integer petId) {
     Pet pet = petRepository.findById(petId).orElse(null);
        if (Objects.nonNull(pet)) {
            petRepository.delete(pet);
            return new DeletePetResponse(200, "Pet was deleted");
        }
        return new DeletePetResponse(400, "Pet id is not correct");
    }
    @Transactional
    @Override
    public void deletePetsByIds(List<PetBean> petBeans) {
        List<Integer> ids = new ArrayList<>();
        for (PetBean petBean : petBeans) {
            ids.add(petBean.getId());
        }
      petRepository.deleteByIdIn(ids);
    }

    @Override
    public UpdaterPetResponse updatePet(PetBean petBean) {
        Pet pet = PetMapper.petBeanToPet(petBean);
       Pet petById = petRepository.findById(pet.getId()).orElse(null);
        if (Objects.nonNull(petById)) {
            petById.setNickName(pet.getNickName());
            petById.setGender(pet.getGender());
            petById.setTypePet(pet.getTypePet());
            petById.setAge(pet.getAge());
            petById.setWeight(pet.getWeight());
            petById.setPersonId(pet.getPersonId());
            petRepository.save(petById);

            return new UpdaterPetResponse(200, "Pet was updated", petBean);
        }
        return new UpdaterPetResponse(400, "Pet id is not correct", petBean);
    }

    @Override
    public GetAllPetResponse getAllPetList() {
        List<Pet> petList = petRepository.findAll();

        return new GetAllPetResponse(200,"Pets imported successfully", PetMapper.petListToPetBeanList(petList));
    }

    @Override
    public Pet getPetById(Integer petId) {
        return petRepository.findById(petId).get();
    }

    @Override
    public List<PetBean> getAllPetsByIds(List<Integer> ids) {
        List<Pet> petList = petRepository.findAllByIdIn(ids);
        return PetMapper.petListToPetBeanList(petList);
    }
}
