package com.repository.SpringDataRepository.DaoRepo1;

import com.repository.SpringDataRepository.Entity.Person;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface PeopleManagementDao1 extends CrudRepository<Person,Integer>
{
List<Person> getByLastName(String firstName);

List<Person> findByLastNameAndEmail(String lastName,String email);

@Query("Select p from Person p where lastName=?1")
List<Person> findByLastNameByPageable(String LastName, PageRequest pageRequest);
@Async
CompletableFuture<Person> findByFirstName(String firstName);

@Query("Select p from Person p where p.firstName=:firstName or p.lastName=:lastName")
List<Person> findByFirstNameOrLastName(@Param("firstName") String firstName,
                                       @Param("lastName") String lastName);
@Transactional
@Modifying
@Query("update Person set lastName=:personLastName where id=:personId")
void findByUpdateLastNameAndId(@Param("personLastName") String lastName,
                                 @Param("personId") int id);

}
