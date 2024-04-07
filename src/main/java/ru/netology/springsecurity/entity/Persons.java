package ru.netology.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@IdClass(PersonsId.class)
@Table(name = "persons")
public class Persons {
    @Id
    private String name;

    @Id
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Id
    private int age;

}
