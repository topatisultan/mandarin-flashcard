package com.portfolio.mandarin_flashcard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flashcards")
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String hanzi;

    @Column(nullable = false, length = 100)
    private String pinyin;

    @Column(nullable = false, length = 255)
    private String arti;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructor Kosong (Wajib untuk JPA)
    public Flashcard() {}

    // Constructor Utama
    public Flashcard(String hanzi, String pinyin, String arti) {
        this.hanzi = hanzi;
        this.pinyin = pinyin;
        this.arti = arti;
    }

    // Getter dan Setter
    public Long getId() { return id; }
    public String getHanzi() { return hanzi; }
    public void setHanzi(String hanzi) { this.hanzi = hanzi; }
    public String getPinyin() { return pinyin; }
    public void setPinyin(String pinyin) { this.pinyin = pinyin; }
    public String getArti() { return arti; }
    public void setArti(String arti) { this.arti = arti; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

