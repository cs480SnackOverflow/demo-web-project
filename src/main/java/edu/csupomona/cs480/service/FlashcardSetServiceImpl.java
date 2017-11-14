package edu.csupomona.cs480.service;

import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.entity.FlashcardSet;
import edu.csupomona.cs480.data.entity.SetMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@DependsOn ({"setMetadataService", "flashcardSetService"})
public class FlashcardSetServiceImpl implements FlashcardSetService {


	private SetMetadataService setMetadataService;
	private FlashcardService flashcardService;

	@Autowired
	public void setMetadataService(SetMetadataService setMetadataService) {
		this.setMetadataService = setMetadataService;
	}

	@Autowired
	public void flashcardSetService(FlashcardService flashcardService) {
		this.flashcardService = flashcardService;
	}

	private FlashcardSet loadFlashcardSet(SetMetadata setMetadata){
		String setId = setMetadata.getSetId();
		List<Flashcard> flashcards = flashcardService.listAllFlashcardsBySetId(setId);
		return new FlashcardSet(setMetadata, flashcards);
	}

	@Override
	public List<FlashcardSet> listAllFlashcardSets() {
		ArrayList<FlashcardSet> flashcardSets = new ArrayList<>();

		Iterable<SetMetadata> sets = setMetadataService.listAllSetMetadatas();
		for(SetMetadata set: sets){
			flashcardSets.add(loadFlashcardSet(set));
		}

		return flashcardSets;
	}

	@Override
	public FlashcardSet getFlashcardSetById(Integer setId) {
		SetMetadata setMetadata = setMetadataService.getSetMetadataById(setId);
		return loadFlashcardSet(setMetadata);
	}

	@Override
	public FlashcardSet saveFlashcardSet(FlashcardSet flashcardSet) {
		SetMetadata setMetadata = flashcardSet.getSetMetadata();
		setMetadataService.saveSetMetadata(setMetadata);

		List<Flashcard> flashcards = flashcardSet.getFlashcardList();
		for(Flashcard flashcard: flashcards)
			flashcardService.saveFlashcard(flashcard);

		return flashcardSet;
	}

	@Override
	public void deleteFlashcardSet(Integer setId) {
		FlashcardSet set = getFlashcardSetById(setId);
		List<Flashcard> flashcards = set.getFlashcardList();

		for(Flashcard flashcard: flashcards){
			flashcardService.deleteFlashcard(flashcard.getId());
		}

		setMetadataService.deleteSetMetadata(setId);
	}

	@Override
	public List<FlashcardSet> listAllFlashcardSetsByName(String name) {
		ArrayList<FlashcardSet> flashcardSetList = new ArrayList<>();

		List<SetMetadata> setMetadataList = setMetadataService.listAllSetMetadatasByName(name);
		for(SetMetadata setMetadata: setMetadataList){
			flashcardSetList.add(loadFlashcardSet(setMetadata));
		}

		return flashcardSetList;
	}

	@Override
	public List<FlashcardSet> listAllFlashcardSetsByUserId(String userId) {
		ArrayList<FlashcardSet> flashcardSetList = new ArrayList<>();

		List<SetMetadata> setMetadataList = setMetadataService.listAllSetMetadatasByUserId(userId);
		for(SetMetadata setMetadata: setMetadataList){
			flashcardSetList.add(loadFlashcardSet(setMetadata));
		}

		return flashcardSetList;
	}
}
