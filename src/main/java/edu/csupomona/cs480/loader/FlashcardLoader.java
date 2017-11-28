package edu.csupomona.cs480.loader;

import edu.csupomona.cs480.data.entity.Flashcard;
import edu.csupomona.cs480.data.entity.Set;
import edu.csupomona.cs480.data.repository.FlashcardRepository;
import edu.csupomona.cs480.data.repository.SetRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Loads defined FlashCards each start in database
 */
@Component
public class FlashcardLoader implements ApplicationListener<ContextRefreshedEvent>{

    private FlashcardRepository flashcardRepository;
    private SetRepository setRepository;
    private Logger log = Logger.getLogger(FlashcardLoader.class);

    @Autowired
    public void setFlashcardRepository(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    @Autowired
    public void setSetRepository(SetRepository setRepository) {
        this.setRepository = setRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       //add flashcards for testing here

    }
}
