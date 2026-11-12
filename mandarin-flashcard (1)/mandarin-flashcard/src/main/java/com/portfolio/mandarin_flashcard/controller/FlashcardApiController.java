package com.portfolio.mandarin_flashcard.controller;

import com.portfolio.mandarin_flashcard.model.Flashcard;
import com.portfolio.mandarin_flashcard.service.FlashcardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
public class FlashcardApiController {

    private final FlashcardService service;

    public FlashcardApiController(FlashcardService service) {
        this.service = service;
    }

    // 1. GET Semua Kartu: http://localhost:8080/api/flashcards
    @GetMapping
    public ResponseEntity<List<Flashcard>> getAllCards() {
        return ResponseEntity.ok(service.getAllFlashcards());
    }

    // 2. GET Kartu Acak: http://localhost:8080/api/flashcards/random
    @GetMapping("/random")
    public ResponseEntity<Flashcard> getRandomCard() {
        return service.getRandomFlashcard()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST Tambah Kartu Baru: http://localhost:8080/api/flashcards
    @PostMapping
    public ResponseEntity<Flashcard> addCard(@RequestBody Flashcard newCard) {
        Flashcard savedCard = service.createFlashcard(newCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    // 4. DELETE Hapus Kartu: http://localhost:8080/api/flashcards/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        if (service.deleteFlashcard(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
