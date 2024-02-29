package com.repository.SpringDataRepository.Controller1;

import com.repository.SpringDataRepository.Entity.Person;
import com.repository.SpringDataRepository.Service1.PeopleManagementService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/springDataOne")
public class Controller1
{
    @Autowired
    private PeopleManagementService1 peopleManagementService1;
    @RequestMapping(value="/getByLastName/{lastName}",
            method = RequestMethod.GET)
    public List<Person> findByLastName(@PathVariable("lastName") String lastName)
    {
        return peopleManagementService1.getByLastName(lastName);
    }

    @RequestMapping(value="/getByLastNameAndEmail/{lastName}/{email}",
            method = RequestMethod.GET)
    public List<Person> findByLastName(@PathVariable("lastName") String lastName,
                                        @PathVariable("email") String email)
    {
        return peopleManagementService1.findByLastNameAndEmail(lastName,email);
    }

    @RequestMapping(value="/getByLastNameByPageble/{lastName}",
            method = RequestMethod.GET)
    public List<Person> findByLastNameByPageble(@PathVariable("lastName") String lastName)
    {
        return peopleManagementService1.findByLastNameByPageble(lastName,PageRequest.of(1,1, Sort.Direction.ASC,"firstName"));
    }

    @RequestMapping(value="/getOneByFirstNameByAsync/{lastName}",
            method = RequestMethod.GET)
    public CompletableFuture<Person> findByFirstName(@PathVariable("firstName") String firstName)
    {
        CompletableFuture<Person> completableFuture= peopleManagementService1.findByFirstName(firstName);
        return completableFuture;
    }

    @RequestMapping(value="/getByFirstNameOrLastName/{firstName}/{lastName}",
            method = RequestMethod.GET)
    public List<Person> findByFirstNameOrLastName(@PathVariable("firstName") String firstName,
                                                  @PathVariable("lastName") String lastName)
    {
        List<Person> person= peopleManagementService1.findByFirstNameOrLastName(firstName,lastName);
        return person;
    }

    @RequestMapping(value="/getByUpdateLastNameAndId/{lastName}/{id}",
            method = RequestMethod.GET)
    public void findByFirstNameOrLastName(@PathVariable("lastName") String lastName,
                                                  @PathVariable("id") int id)
    {
         peopleManagementService1.findByUpdateLastNameAndId(lastName,id);
    }
}
