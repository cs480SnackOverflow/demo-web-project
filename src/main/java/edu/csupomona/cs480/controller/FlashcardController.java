package edu.csupomona.cs480.controller;

import com.sun.org.apache.regexp.internal.RE;
import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.entity.Set;
import edu.csupomona.cs480.service.FlashcardService;
import edu.csupomona.cs480.service.SetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class FlashcardController {

    private FlashcardService flashcardService;
    private SetService setService;

    @Autowired
    public void setFlashcardService(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    }

    @Autowired
    public void setSetService(SetService setService) {
        this.setService = setService;
    }


    //Create
    @RequestMapping("flashcard/new")
    public String newFlashcard(Model model) {
        model.addAttribute(new Flashcard());
        return "flashcardform";
    }

    //Create & Update
    @RequestMapping(value = "flashcard", method = RequestMethod.POST)
    public String saveFlashcard(Flashcard flashcard) {
        flashcardService.saveFlashcard(flashcard);
        return "redirect:/flashcard/" + flashcard.getId();
    }

    //Read
    @RequestMapping("flashcard/{id}")
    public String showFlashCard(@PathVariable Integer id, Model model) {
        model.addAttribute("flashcard", flashcardService.getFlashcardById(id));
        return "flashcardshow";
    }

    //List all
    @RequestMapping(value = "flashcards", method = RequestMethod.GET)
    public List<Flashcard> list(Model model) {
        //model.addAttribute("flashcards", flashcardService.listAllFlashcards());

        List<Flashcard> list = new ArrayList<>();
        Iterator f = flashcardService.listAllFlashcards().iterator();
        while(f.hasNext()) {
            list.add((Flashcard) f.next());
        }

        return list;
    }

    @RequestMapping(value = "flashcards/total", method = RequestMethod.GET)
    public long getTotal() {
        if(flashcardService.count() == 0) {
            return 0L;
        }
        return flashcardService.count();
    }

    //Update
    @RequestMapping("flashcard/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("flashcard", flashcardService.getFlashcardById(id));
        return "flashcardform";
    }

    //Delete
    @RequestMapping("flashcard/delete/{id}")
    public String delete(@PathVariable Integer id) {
        flashcardService.deleteFlashcard(id);
        return "redirect:/flashcards";
    }

    //List Flashcards
    @RequestMapping("user/flashcards/{id}")
    public String listFlashcards(@PathVariable String id, Model model) {
        model.addAttribute("flashcards", flashcardService.listAllFlashcardsByUserId(id));
        return "flashcards";
    }

    //return a given sets
    @RequestMapping(value = "flashcard/set/{setId}", method = RequestMethod.GET)
    public List<Flashcard> listFlashcardSet(@PathVariable String setId) {

        return flashcardService.listAllFlashcardsBySetId(setId);
    }

    //receive a set and add to database
    @RequestMapping(value = "flashcard/set/new", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void saveFlashcardSet(@RequestBody List<Flashcard> flashcard) {

        for(Flashcard f : flashcard) {
            System.out.println(f.getSetId());
            flashcardService.saveFlashcard(f);
        }
    }

    //recieve a set and add to database
    @RequestMapping(value = "flashcard/set/newSet", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void saveSet(@RequestBody Set set) {

        setService.saveSet(set);
    }

    //recieve a set and add to database
    @RequestMapping(value = "flashcard/set/deleteset/{setId}", method = RequestMethod.GET)
    public void deleteSet(@PathVariable int setId) {

        setService.deleteSet(setId);
    }

    //recieve a set and add to database
    @RequestMapping(value = "flashcard/set/getset/{setId}", method = RequestMethod.GET)
    public Set getSet(@PathVariable int setId) {

        return setService.getSetById(setId);
    }

    //recieve all of the sets in the database
    @RequestMapping(value = "flashcard/set/allsets", method = RequestMethod.GET)
    public List<Set> saveSet() {

       return setService.listAllSets();
    }
}
