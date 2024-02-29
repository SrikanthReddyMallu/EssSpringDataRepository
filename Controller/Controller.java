package com.repository.SpringDataRepository.Controller;

import com.repository.SpringDataRepository.Entity.Person;
import com.repository.SpringDataRepository.Service.PeopleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/springData")
public class Controller
{
    @Autowired
    PeopleManagementService peopleManagementService;
    @RequestMapping(value="/saveCrud",
                   method = RequestMethod.POST)
    public Person saveStudent(@RequestBody Person person)
    {
        return peopleManagementService.saveCrud(person);
    }

    @RequestMapping(value="/saveAllCrud",
            method = RequestMethod.POST)
    public List<Person> saveAllIerable(@RequestBody List<Person> person)
    {
        return peopleManagementService.saveAllCrud(person);
    }

    @RequestMapping(value="/findByIdCrud/{id}",
            method = RequestMethod.GET)
    public Optional<Person> findByIdCrud(@PathVariable("id") Integer id)
    {
        return peopleManagementService.findByIdCrud(id);
    }

    @RequestMapping(value="/existsByIdCrud/{id}",
            method = RequestMethod.GET)
    public Boolean existsByIdCrud(@PathVariable("id") Integer id)
    {
        return peopleManagementService.existsByIdCrud(id);
    }

    @RequestMapping(value="/findAllCrud",
            method = RequestMethod.GET)
    public List<Person> findAllCrud()
    {
        return peopleManagementService.findAllCrud();
    }

    @RequestMapping(value="/findAllByIdCrud",
            method = RequestMethod.GET)
    public List<Person> findAllByIdCrud(@RequestBody List<Person> id)
    {
        return peopleManagementService.findAllByIdCrud(id);
    }

    @RequestMapping(value="/countCrud",
            method = RequestMethod.GET)
    public Long countCrud()
    {
        return peopleManagementService.countCrud();
    }

    @RequestMapping(value="/deleteByIdCrud/{id}",
            method = RequestMethod.GET)
    public void deleteByIdCrud(@PathVariable("id") Integer id)
    {
         peopleManagementService.deleteByIdCrud(id);
    }

    @RequestMapping(value="/deleteCrud",
            method = RequestMethod.GET)
    public void deleteCrud(
            @RequestBody Person person)
    {
        peopleManagementService.deleteCrud(person);
    }

    @RequestMapping(value="/deleteAllByIdCrud",
            method = RequestMethod.GET)
    public void deleteAllByIdCrud(
            @RequestBody List<Person> ids)
    {
        peopleManagementService.deleteAllByIdCrud(ids);
    }

    @RequestMapping(value="/deleteAllCrud",
            method = RequestMethod.GET)
    public void deleteAllCrud(
            @RequestBody List<Person> person)
    {
        peopleManagementService.deleteAllCrud(person);
    }

    @RequestMapping(value="/deleteAllCrud1",
            method = RequestMethod.GET)
    public void deleteAllCrud1()
    {
        peopleManagementService.deleteAllCrud1();
    }

}
