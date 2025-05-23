package com.example.charityapp.controller;

import com.example.charityapp.model.ActionCharite;
import com.example.charityapp.service.ActionChariteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/actions")
public class ActionChariteController {

    private final ActionChariteService service;

    @Autowired
    public ActionChariteController(ActionChariteService service) {
        this.service = service;
    }

    @GetMapping
    public String listActions(Model model) {
        model.addAttribute("actions", service.findAll());
        return "admin/actions/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("action", new ActionCharite());
        return "admin/actions/form";
    }

    @PostMapping
    public String saveAction(@ModelAttribute ActionCharite action) {
        service.save(action);
        return "redirect:/admin/actions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        service.findById(id).ifPresent(action -> model.addAttribute("action", action));
        return "admin/actions/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAction(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/admin/actions";
    }
} 