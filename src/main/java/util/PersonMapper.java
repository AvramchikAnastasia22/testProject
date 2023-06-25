package util;

import com.avram.testProject.dto.bean.CreatePersonBean;
import com.avram.testProject.dto.bean.PersonBean;
import com.avram.testProject.model.Person;
import com.avram.testProject.model.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonMapper {
    public static Person personFromPersonBean(CreatePersonBean createPersonBean) {
        Person person = null;
        if (Objects.nonNull(createPersonBean)) {
            person = new Person();
            person.setName(createPersonBean.getName());
            person.setLastName(createPersonBean.getLastName());
            person.setAddress(createPersonBean.getAddress());
            person.setNumberPhone(createPersonBean.getNumberPhone());
            person.setTown(createPersonBean.getTown());
        }
        return person;
    }

    public static Person personFromPersonBean(PersonBean personBean) {
        Person person = new Person();
        if (Objects.nonNull(personBean)) {
            person.setId(personBean.getId());
            person.setName(personBean.getName());
            person.setLastName(personBean.getLastName());
            person.setAddress(personBean.getAddress());
            person.setNumberPhone(personBean.getNumberPhone());
            person.setTown(personBean.getTown());
            return person;
        }
        return null;
    }

    public static List<PersonBean> personBeanListFomPersonList(List<Person> personList) {
        List<PersonBean> personBeanList = new ArrayList<>();
        if (!personList.isEmpty()) {
            for (Person person : personList
            ) {
                personBeanList.add(personBeanFromPerson(person));
            }
        }
        return personBeanList;
    }

    public static PersonBean personBeanFromPerson(Person person) {
        PersonBean personBean = new PersonBean();
        if (Objects.nonNull(person)) {
            personBean.setId(person.getId());
            personBean.setName(person.getName());
            personBean.setLastName(person.getLastName());
            personBean.setAddress(person.getAddress());
            personBean.setNumberPhone(person.getNumberPhone());
            personBean.setTown(person.getTown());
            personBean.setPets(person.getPets());
            return personBean;
        }
        return null;
    }

}
