package util;

import com.avram.testProject.dto.bean.PetBean;
import com.avram.testProject.model.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetMapper {

    public static List<PetBean> petListToPetBeanList(List<Pet> pets) {
        List<PetBean> petBeans = new ArrayList<>();
        if (!pets.isEmpty()) {
            for (Pet pet : pets) {
                petBeans.add(petToPetBean(pet));
            }
        }
        return petBeans;
    }

    public static PetBean petToPetBean(Pet pet) {
       PetBean petBean = null;
        if (Objects.nonNull(pet)) {
            petBean = new PetBean();
            petBean.setId(pet.getId());
            petBean.setNickName(pet.getNickName());
            petBean.setTypePet(pet.getTypePet());
            petBean.setGender(pet.getGender());
            petBean.setAge(pet.getAge());
            petBean.setWeight(pet.getWeight());
            petBean.setPersonId(pet.getPersonId());
        }
        return petBean;
    }
    public static List<Pet> petBeanListToPetList(List<PetBean> petBeans) {
        List<Pet> pets = new ArrayList<>();
        if (!petBeans.isEmpty()) {
            for (PetBean petBean : petBeans) {
                pets.add(petBeanToPet(petBean));
            }
        }
        return pets;
    }
    public static Pet petBeanToPet(PetBean petBean) {
       Pet pet = null;
        if (Objects.nonNull(petBean)) {
            pet = new Pet();
            pet.setId(petBean.getId());
            pet.setNickName(petBean.getNickName());
            pet.setTypePet(petBean.getTypePet());
            pet.setGender(petBean.getGender());
            pet.setAge(petBean.getAge());
            pet.setWeight(petBean.getWeight());
            pet.setPersonId(petBean.getPersonId());
        }
        return pet;
    }


}
