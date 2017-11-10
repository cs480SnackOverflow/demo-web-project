package edu.csupomona.cs480.data.entity;

import java.util.List;

public class FlashcardSet {
	private SetMetadata setMetadata;
	private List<Flashcard> flashcardList;

	public FlashcardSet(SetMetadata setMetadata, List<Flashcard> flashcardList){
		this.setMetadata = setMetadata;
		this.flashcardList = flashcardList;
	}

	public SetMetadata getSetMetadata() {
		return setMetadata;
	}

	public void setSetMetadata(SetMetadata setMetadata) {
		this.setMetadata = setMetadata;
	}

	public List<Flashcard> getFlashcardList() {
		return flashcardList;
	}

	public void setFlashcardList(List<Flashcard> flashcardList) {
		this.flashcardList = flashcardList;
	}
}
