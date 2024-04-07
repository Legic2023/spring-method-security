package ru.netology.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.springsecurity.entity.Persons;
import ru.netology.springsecurity.entity.PersonsId;

import java.util.List;
import java.util.Optional;

@Repository
public interface DbRepository extends JpaRepository<Persons, PersonsId> {
    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeLessThanOrderByAge(int age);

    Optional<Persons> findByNameAndSurname(String name, String surname);

}