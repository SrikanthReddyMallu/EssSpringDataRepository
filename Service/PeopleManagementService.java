package com.repository.SpringDataRepository.Service;

import com.repository.SpringDataRepository.DaoRepo.PeopleManagementDao;
import com.repository.SpringDataRepository.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PeopleManagementService {
    @Autowired
    private PeopleManagementDao peopleManagementDao;


    public Person saveCrud(Person person)
    {
        Person person1=peopleManagementDao.save(person);
        System.out.println(person1);
        return person1;
    }

    public List<Person> saveAllCrud(List<Person> person)
    {
         List<Person> person1= (List<Person>) peopleManagementDao.saveAll(person);
        for (Person person2:person1) {
            System.out.println(person2);
        }
        return person1;
    }

    public Optional<Person> findByIdCrud(Integer id)
    {
        Optional<Person> person1= peopleManagementDao.findById(id);
        return person1;
    }

    public Boolean existsByIdCrud(Integer id)
    {
        Boolean person1= peopleManagementDao.existsById(id);
        return person1;
    }

    public List<Person> findAllCrud()
    {
        List<Person> person= (List<Person>) peopleManagementDao.findAll();
        for (Person person1:person) {
            System.out.println(person1);
        }
        return person;
    }

    public List<Person> findAllByIdCrud(List<Person> id)
    {
        List<Integer> ids = id.stream().map(Person::getId).collect(Collectors.toList());
        List<Person> person= (List<Person>) peopleManagementDao.findAllById(ids);
        for (Person person1:person) {
            System.out.println(person1);
        }
        return person;
    }

    public Long countCrud()
    {
        Long count= peopleManagementDao.count();
        return count;
    }

    public void deleteByIdCrud(Integer id)
    {
        peopleManagementDao.deleteById(id);
    }

    public void deleteCrud(Person person)
    {
        peopleManagementDao.delete(person);
    }

    public void deleteAllByIdCrud(List<Person> ids)
    {
        List<Integer> str=ids.stream().map(Person::getId).collect(Collectors.toList());
        peopleManagementDao.deleteAllById(str);
    }

    public void deleteAllCrud(List<Person> person)
    {
        peopleManagementDao.deleteAll(person);
    }

    public void deleteAllCrud1()
    {
        peopleManagementDao.deleteAll();
    }
}