package com.portfolio.mandarin_flashcard.controller;

import com.portfolio.mandarin_flashcard.service.FlashcardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlashcardController {

    private final FlashcardService service;

    public FlashcardController(FlashcardService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getFlashcardPage(Model model) {
        service.getRandomFlashcard().ifPresentOrElse(
                card -> model.addAttribute("card", card),
                () -> model.addAttribute("errorMessage", "Belum ada flashcard yang tersedia.")
        );
        return "index";
    }
}
