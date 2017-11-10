package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.FlashcardSet;

import java.util.List;

public interface FlashcardSetService {

	Iterable<FlashcardSet> listAllFlashcardSets();
	FlashcardSet getFlashcardSetById(Integer setId);
	FlashcardSet saveFlashcardSet(FlashcardSet flashcard);
	void deleteFlashcardSet(Integer id);
	List<FlashcardSet> listAllFlashcardSetsByName(String name);
	List<FlashcardSet> listAllFlashcardSetsByUserId(String userId);
}
