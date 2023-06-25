package com.avram.testProject.service.serviceImpl;

import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.dto.bean.PetBean;
import com.avram.testProject.dto.response.CreatePersonResponse;
import com.avram.testProject.dto.response.DeletePersonResponse;
import com.avram.testProject.dto.response.GetAllPersonResponse;
import com.avram.testProject.dto.response.UpdatePersonResponse;
import com.avram.testProject.model.Person;
import com.avram.testProject.model.Pet;
import com.avram.testProject.repository.PersonRepository;
import com.avram.testProject.repository.PetRepository;
import com.avram.testProject.service.PersonService;
import com.avram.testProject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.BaseResponse;
import util.PersonMapper;
import util.PetMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PetService petService;

    @Override
    public CreatePersonResponse createPerson(PersonBean request) {
        Person person;
        if (Objects.nonNull(request)) {
            person = PersonMapper.personFromPersonBean(request);
            personRepository.save(person);
            return new CreatePersonResponse(200, "Person was created");
        }
        return new CreatePersonResponse(200, "Request was wrong");
    }

    @Override
    public DeletePersonResponse deletePerson(Integer personId) {
        Person person = personRepository.findById(personId).orElse(null);
        if (Objects.nonNull(person)) {
            List<Pet> pets = person.getPets();
            personRepository.delete(person);
            petService.deletePetsByIds(PetMapper.petListToPetBeanList(pets));
            return new DeletePersonResponse(200, "User was deleted");
        } else
            return new DeletePersonResponse(200, "User not found");
    }

    @Override
    public UpdatePersonResponse updatePerson(PersonBean personBean) {
        Person person = PersonMapper.personFromPersonBean(personBean);
        Person personUpdated = personRepository.findById(person.getId()).orElse(null);
        if (Objects.nonNull(personUpdated)) {
            personUpdated.setName(person.getName());
            personUpdated.setLastName(person.getLastName());
            personUpdated.setAddress(person.getAddress());
            personUpdated.setNumberPhone(person.getNumberPhone());
            personUpdated.setTown(person.getTown());

            personRepository.save(personUpdated);
            return new UpdatePersonResponse(200, "Person was updating", personBean);
        }
        return new UpdatePersonResponse(400, "Person update error", personBean);
    }

    @Override
    public GetAllPersonResponse getAllPersons() {
        List<Person> personList = personRepository.findAll();
        List<PersonBean> personBeans = PersonMapper.personBeanListFomPersonList(personList);
        return new GetAllPersonResponse(
                200,
                "Persons was exported from base successfully",
                personBeans
        );
    }

    @Override
    public Person getPersonById(Integer personId) {
        return personRepository.findById(personId)
                .orElse(null);
    }

    @Override
    public UpdatePersonResponse addPetToPerson(Integer petId, Integer personId) {
        List<PetBean> pets = new ArrayList<>();
        PetBean pet = PetMapper.petToPetBean(petService.getPetById(petId));
        Person personById = getPersonById(personId);
        if (Objects.nonNull(pet) && Objects.nonNull(personById)) {
            if (!personById.getPets().isEmpty()) {
                for (int i = 0; i < personById.getPets().size(); i++) {
                    pets.add(PetMapper.petToPetBean(personById.getPets().get(i)));
                }
                pets.add(pet);
            } else {
                pets.add(PetMapper.petToPetBean(petService.getPetById(petId)));
            }


            personById.setPets(PetMapper.petBeanListToPetList(pets));
            for (PetBean petBean : pets) {
                petBean.setPersonId(personId);

                petService.updatePet(petBean);

            }
            personRepository.save(personById);
            PersonBean save = PersonMapper.personBeanFromPerson(personById);
            return new UpdatePersonResponse(200, "Pets was added", save);
        }
        return new UpdatePersonResponse(400, "Pets or person is not found - " +
                "person:" + personById +
                "pets:" + petId,
                null);
    }

    @Override
    public BaseResponse deletePetFromUser(Integer petId, Integer userId) {
        Pet pet = petService.getPetById(petId);
        Person personById = getPersonById(userId);
        if (Objects.nonNull(personById)) {
            if (personById.getPets().contains(pet)) {
                List<Pet> petList = personById.getPets();
                petList.remove(pet);
                personById.setPets(petList);
                petService.deletePet(petId);

            }

            return new BaseResponse(200, "Pet was deleted");
        }
        return new BaseResponse(400, "Pet or person is not found - " +
                "user:" +
                "rooms:" + petId);
    }


}
