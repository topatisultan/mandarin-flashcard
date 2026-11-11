package com.portfolio.mandarin_flashcard.config;

import com.portfolio.mandarin_flashcard.model.Flashcard;
import com.portfolio.mandarin_flashcard.repository.FlashcardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(FlashcardRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Flashcard("你好", "Nǐ hǎo", "Halo"));
                repository.save(new Flashcard("谢谢", "Xièxie", "Terima kasih"));
                repository.save(new Flashcard("再见", "Zàijiàn", "Sampai jumpa"));
                repository.save(new Flashcard("苹果", "Píngguǒ", "Apel"));
                repository.save(new Flashcard("猫", "Māo", "Kucing"));
            }
        };
    }
}
