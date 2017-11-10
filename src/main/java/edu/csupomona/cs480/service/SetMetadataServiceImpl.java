package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.SetMetadata;
import edu.csupomona.cs480.data.repository.SetMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SetMetadataServiceImpl implements SetMetadataService {

	private SetMetadataRepository flashcardSetRepository;

	@Autowired
	public void setFlashcardRepository(SetMetadataRepository flashcardSetRepository) {
		this.flashcardSetRepository = flashcardSetRepository;
	}

	@Override
	public Iterable<SetMetadata> listAllSetMetadatas() {
		return flashcardSetRepository.findAll();
	}

	@Override
	public SetMetadata getSetMetadataById(Integer setId) {
		return flashcardSetRepository.findOne(setId);
	}

	@Override
	public SetMetadata saveSetMetadata(SetMetadata setMetadata) {
		return flashcardSetRepository.save(setMetadata);
	}

	@Override
	public void deleteSetMetadata(Integer setId) {
		flashcardSetRepository.delete(setId);
	}

	@Override
	public List<SetMetadata> listAllSetMetadatasByName(String name) {
		return flashcardSetRepository.findByName(name);
	}

	@Override
	public List<SetMetadata> listAllSetMetadatasByUserId(String userId) {
		return flashcardSetRepository.findByUserId(userId);
	}
}
