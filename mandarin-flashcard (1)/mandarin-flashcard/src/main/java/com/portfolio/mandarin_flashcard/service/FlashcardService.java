package com.portfolio.mandarin_flashcard.service;

import com.portfolio.mandarin_flashcard.model.Flashcard;
import com.portfolio.mandarin_flashcard.repository.FlashcardRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {

    private final FlashcardRepository repository;

    public FlashcardService(FlashcardRepository repository) {
        this.repository = repository;
    }

    public Optional<Flashcard> getRandomFlashcard() {
        List<Flashcard> cards = repository.findAll();
        if (cards.isEmpty()) {
            return Optional.empty();
        }
        Collections.shuffle(cards);
        return Optional.of(cards.get(0));
    }

    // --- Tambahan Metode untuk RESTful API ---

    public List<Flashcard> getAllFlashcards() {
        return repository.findAll();
    }

    public Flashcard createFlashcard(Flashcard flashcard) {
        return repository.save(flashcard);
    }

    public boolean deleteFlashcard(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
