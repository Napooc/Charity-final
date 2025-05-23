package com.example.charityapp.controllers;

import com.example.charityapp.model.ActionCharite;
import com.example.charityapp.model.Don;
import com.example.charityapp.service.ActionChariteService;
import com.example.charityapp.repository.DonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonationController {

    private final ActionChariteService actionChariteService;
    private final DonRepository donRepository;

    public DonationController(ActionChariteService actionChariteService, DonRepository donRepository) {
        this.actionChariteService = actionChariteService;
        this.donRepository = donRepository;
    }

    @GetMapping("")
    public String showDonationActions(Model model) {
        List<ActionCharite> charityActions = actionChariteService.findAll();
        model.addAttribute("charityActions", charityActions);
        return "donation/list";
    }

    @GetMapping("/{actionId}")
    public String showDonationForm(@PathVariable Long actionId, Model model) {
        ActionCharite action = actionChariteService.findById(actionId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid action ID: " + actionId));
        model.addAttribute("action", action);
        return "donation/form";
    }

    @PostMapping("/{actionId}")
    public String processDonation(@PathVariable Long actionId,
                                @ModelAttribute Don don,
                                RedirectAttributes redirectAttributes) {
        ActionCharite action = actionChariteService.findById(actionId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid action ID: " + actionId));

        // Set the donation details
        don.setActionCharite(action);
        don.setDateDon(LocalDateTime.now());

        // Save the donation
        Don savedDon = donRepository.save(don);

        // Update the action's current amount
        action.setCurrentAmount(action.getCurrentAmount().add(don.getMontant()));
        actionChariteService.save(action);

        // Add the saved donation to the redirect attributes
        redirectAttributes.addFlashAttribute("don", savedDon);
        redirectAttributes.addFlashAttribute("action", action);

        return "redirect:/donate/thankyou";
    }

    @GetMapping("/thankyou")
    public String showThankYouPage() {
        return "donation/thankyou";
    }
} 