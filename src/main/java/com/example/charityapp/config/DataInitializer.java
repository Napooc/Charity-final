package com.example.charityapp.config;

import com.example.charityapp.model.ActionCharite;
import com.example.charityapp.service.ActionChariteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ActionChariteService actionChariteService) {
        return args -> {
            // Check if any charity actions exist
            if (actionChariteService.count() == 0) {
                // Create and save some sample charity actions
                ActionCharite action1 = new ActionCharite();
                action1.setTitle("Build a School in Village");
                action1.setDescription("Help us build a new primary school for children in a rural village.");
                action1.setTargetAmount(new BigDecimal("50000.00"));
                action1.setCurrentAmount(BigDecimal.ZERO);
                action1.setStartDate(LocalDateTime.now());
                action1.setEndDate(LocalDateTime.now().plusMonths(6));
                action1.setMediaUrl("https://images.unsplash.com/photo-1469571486292-0ba58a3f068b"); // Example image URL

                ActionCharite action2 = new ActionCharite();
                action2.setTitle("Provide Clean Water");
                action2.setDescription("Fund a project to install clean water wells in drought-affected areas.");
                action2.setTargetAmount(new BigDecimal("30000.00"));
                action2.setCurrentAmount(BigDecimal.ZERO);
                action2.setStartDate(LocalDateTime.now());
                action2.setEndDate(LocalDateTime.now().plusMonths(4));
                action2.setMediaUrl("https://images.unsplash.com/photo-1509099836639-18ba1795216d"); // Example image URL

                actionChariteService.save(action1);
                actionChariteService.save(action2);

                System.out.println("Initialized database with sample charity actions.");
            }
        };
    }
} 