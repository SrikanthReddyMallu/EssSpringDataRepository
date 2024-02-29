package com.repository.SpringDataRepository.DaoRepo;


import com.repository.SpringDataRepository.Entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PeopleManagementDao extends CrudRepository<Person,Integer>
{

}
