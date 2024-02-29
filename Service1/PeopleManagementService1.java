package com.repository.SpringDataRepository.Service1;

import com.repository.SpringDataRepository.DaoRepo1.PeopleManagementDao1;
import com.repository.SpringDataRepository.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class PeopleManagementService1
{
    @Autowired
    private PeopleManagementDao1 peopleManagementDao1;

    public List<Person> getByLastName(String lastName)
    {
        List<Person> personList=peopleManagementDao1.getByLastName(lastName);
        for (Person person:personList)
        {
            System.out.println(person);
        }
        return personList;
    }

    public List<Person> findByLastNameAndEmail(String lastName,String email)
    {
        List<Person> personList=peopleManagementDao1.findByLastNameAndEmail(lastName,email);
        for (Person person:personList)
        {
            System.out.println(person);
        }
        return personList;
    }

    public List<Person> findByLastNameByPageble(String lastName, PageRequest pageRequest)
    {
        List<Person> personList=peopleManagementDao1.findByLastNameByPageable(lastName,pageRequest);
        for (Person person:personList)
        {
            System.out.println(person);
        }
        return personList;
    }

    public CompletableFuture<Person> findByFirstName(String firstName)
    {
       CompletableFuture<Person> completableFuture =peopleManagementDao1.findByFirstName(firstName);
      // Person person= completableFuture.get(20,TimeUnit.SECONDS);
      //  System.out.println(person);
        return completableFuture;
    }

    public List<Person> findByFirstNameOrLastName(String firstName,String lastName)
    {
        List<Person> personList =peopleManagementDao1.findByFirstNameOrLastName(firstName,lastName);
        for (Person person:personList)
        {
            System.out.println(person);
        }
        return personList;
    }

    public Void findByUpdateLastNameAndId(String lastName,int id)
    {
        peopleManagementDao1.findByUpdateLastNameAndId(lastName,id);

        return null;
    }
}
