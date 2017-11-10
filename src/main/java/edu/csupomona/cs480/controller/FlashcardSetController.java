package edu.csupomona.cs480.controller;

import edu.csupomona.cs480.data.entity.FlashcardSet;
import edu.csupomona.cs480.service.FlashcardSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlashcardSetController {

	private FlashcardSetService FlashcardSetService;

	@Autowired
	public void setFlashcardSetService(FlashcardSetService FlashcardSetService) {
		this.FlashcardSetService = FlashcardSetService;
	}

	//Returns the requested FlashcardSet
	@RequestMapping(value = "flashcardset/get/{id}")
	public String getSet(@PathVariable Integer id, Model model) {
		model.addAttribute("flashcardset", FlashcardSetService.getFlashcardSetById(id));
		return "flashcardset";
	}

	//Creates and updates the values of a FlashcardSet
	@RequestMapping(value = "flashcardset/set", method = RequestMethod.POST)
	public String setSet(FlashcardSet FlashcardSet) {
		FlashcardSetService.saveFlashcardSet(FlashcardSet);
		return "redirect:/flashcardset/get/" + FlashcardSet.getSetMetadata().getSetId();
	}
}