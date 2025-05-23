package com.example.charityapp.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any data you want to pass to the dashboard
        model.addAttribute("totalUsers", 1234);
        model.addAttribute("totalDonations", 45678);
        model.addAttribute("activeProjects", 56);
        model.addAttribute("pendingTasks", 12);
        return "/admin/dashboard";
    }
} 