package edu.csupomona.cs480.data.repository;

import edu.csupomona.cs480.data.entity.SetMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

	/**
	 * CrudRepository is an interface that gives access to CRUD operations without
	 * the need to write them ourselves.
	 *
	 * Each method that begins with "findBy" is a query in the repository for the specified element.
	 */
	public interface SetMetadataRepository extends CrudRepository<SetMetadata, Integer> {

		List<SetMetadata> findByName(@Param("name") String name);
		List<SetMetadata> findBySetId(@Param("setId") String setId);
		List<SetMetadata> findByUserId(@Param("userId") String userId);

	}
