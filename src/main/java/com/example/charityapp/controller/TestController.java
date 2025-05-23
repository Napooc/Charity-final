package com.example.charityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class TestController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/test-i18n")
    public String testI18n(@RequestParam(name = "lang", required = false) Locale locale, Model model) {
        String translatedMessage = messageSource.getMessage("welcome", null, locale);
        model.addAttribute("translatedMessage", translatedMessage);
        return "test-i18n";
    }
} 