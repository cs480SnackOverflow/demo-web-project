package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.SetMetadata;

import java.util.List;

public interface SetMetadataService {
	Iterable<SetMetadata> listAllSetMetadatas();
	SetMetadata getSetMetadataById(Integer setId);
	SetMetadata saveSetMetadata(SetMetadata flashcard);
	void deleteSetMetadata(Integer id);
	List<SetMetadata> listAllSetMetadatasByName(String name);
	List<SetMetadata> listAllSetMetadatasByUserId(String userId);
}
