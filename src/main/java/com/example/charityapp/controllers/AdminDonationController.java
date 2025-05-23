package com.example.charityapp.controllers;

import com.example.charityapp.model.Don;
import com.example.charityapp.service.DonationService;
import com.example.charityapp.service.ActionChariteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/donations")
public class AdminDonationController {

    private final DonationService donationService;
    private final ActionChariteService actionChariteService;

    @Autowired
    public AdminDonationController(DonationService donationService, ActionChariteService actionChariteService) {
        this.donationService = donationService;
        this.actionChariteService = actionChariteService;
    }

    @GetMapping
    public String listDonations(Model model) {
        List<Don> donations = donationService.getAllDonations();
        model.addAttribute("donations", donations);
        return "admin/donations/list"; // Changed to return the new list template
    }

    @GetMapping("/new")
    public String showDonationForm(Model model) {
        model.addAttribute("donation", new Don());
        model.addAttribute("actions", actionChariteService.findAll()); // Corrected method call
        return "admin/donations/form";
    }

    @GetMapping("/edit/{id}")
    public String showEditDonationForm(@PathVariable("id") Long id, Model model) {
        Optional<Don> donation = donationService.getDonationById(id);
        if (donation.isPresent()) {
            model.addAttribute("donation", donation.get());
             model.addAttribute("actions", actionChariteService.findAll()); // Corrected method call
            return "admin/donations/form";
        } else {
            return "redirect:/admin/donations?error=Donation not found";
        }
    }

    @PostMapping("/save")
    public String saveDonation(@ModelAttribute("donation") Don donation) {
        donationService.saveDonation(donation);
        return "redirect:/admin/donations?success=Donation saved successfully!";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonation(@PathVariable("id") Long id) {
        donationService.deleteDonationById(id);
        return "redirect:/admin/donations?success=Donation deleted successfully!";
    }
} 