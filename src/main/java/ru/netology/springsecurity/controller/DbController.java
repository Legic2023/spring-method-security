package ru.netology.springsecurity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springsecurity.entity.Persons;
import ru.netology.springsecurity.repository.DbRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class DbController {

    private final DbRepository dbRepository;

    @GetMapping("by-city")
    @Secured("ROLE_READ")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return dbRepository.findByCityOfLiving(city);
    }

    @GetMapping("by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Persons> getPersonsByAge(@RequestParam int age) {
        return dbRepository.findByAgeLessThanOrderByAge(age);
    }

    @GetMapping("by-name-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Persons> getPersonsByNameSurname(@RequestParam String name, @RequestParam String surname) {
        return dbRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping()
    @PreAuthorize("authentication.principal.username == 'Admin'")
    public List<Persons> findAll() {
        return dbRepository.findAll();
    }

}
