package com.avram.testProject.model;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "pet_table")
@ToString
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "type_pet")
    private String typePet;
    @Column(name = "gender")
    private String gender;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "person_id")
    private Integer personId;

    public Pet() {
    }

    public Pet(Integer id, String nickName, Integer age, String typePet, String gender, Double weight) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
        this.typePet = typePet;
        this.gender = gender;
        this.weight = weight;
    }

    public Pet(Integer id, String nickName, Integer age, String typePet, String gender, Double weight, Integer personId) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
        this.typePet = typePet;
        this.gender = gender;
        this.weight = weight;
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
