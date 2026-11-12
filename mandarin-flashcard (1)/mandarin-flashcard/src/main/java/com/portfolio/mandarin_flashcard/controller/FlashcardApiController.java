package com.portfolio.mandarin_flashcard.controller;

import com.portfolio.mandarin_flashcard.model.Flashcard;
import com.portfolio.mandarin_flashcard.service.FlashcardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
@Tag(name = "Mandarin Flashcard API", description = "Endpoint untuk mengelola dan mengambil data kosakata Mandarin")
public class FlashcardApiController {

    private final FlashcardService service;

    public FlashcardApiController(FlashcardService service) {
        this.service = service;
    }

    @Operation(summary = "Ambil semua kartu", description = "Mengembalikan daftar seluruh kosakata Mandarin yang tersimpan di database.")
    @GetMapping
    public ResponseEntity<List<Flashcard>> getAllCards() {
        return ResponseEntity.ok(service.getAllFlashcards());
    }

    @Operation(summary = "Ambil satu kartu acak", description = "Mengambil satu kosakata Mandarin secara acak untuk sesi latihan.")
    @GetMapping("/random")
    public ResponseEntity<Flashcard> getRandomCard() {
        return service.getRandomFlashcard()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Tambah kartu baru", description = "Menyimpan kosakata Mandarin baru (Hanzi, Pinyin, Arti) ke dalam database.")
    @PostMapping
    public ResponseEntity<Flashcard> addCard(@RequestBody Flashcard newCard) {
        Flashcard savedCard = service.createFlashcard(newCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    @Operation(summary = "Hapus kartu", description = "Menghapus data kartu dari database berdasarkan nomor ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        if (service.deleteFlashcard(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
