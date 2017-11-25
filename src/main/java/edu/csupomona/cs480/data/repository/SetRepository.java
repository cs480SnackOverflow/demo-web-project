package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CrudRepository is an interface that gives access to CRUD operations without
 * the need to write them ourselves.
 *
 * Each method that begins with "findBy" is a query in the repository for the specified element.
 */
public interface SetRepository extends CrudRepository<Set, Integer>{

    List<Set> findBySetId(@Param("setId") String setId);
    List<Set> findByTitle(@Param("title") String title);
    List<Set> findAll();

}
