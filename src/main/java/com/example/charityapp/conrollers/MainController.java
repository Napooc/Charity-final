package com.example.charityapp.conrollers;

import com.example.charityapp.model.ActionCharite;
import com.example.charityapp.repository.DonRepository;
import com.example.charityapp.service.ActionChariteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final DonRepository donRepository;
    private final ActionChariteService actionChariteService;

    public MainController(DonRepository donRepository, ActionChariteService actionChariteService) {
        this.donRepository = donRepository;
        this.actionChariteService = actionChariteService;
    }

    @GetMapping("/")
    public String accueil(Model model) {
        List<ActionCharite> charityActions = actionChariteService.findAll();
        model.addAttribute("charityActions", charityActions);
        return "index";
    }

    @GetMapping("/accueil/dons")
    public String afficherDons(Model model) {
        model.addAttribute("dons", donRepository.findAll());
        return "liste";
    }

    @GetMapping("/accueil/medias")
    public String afficherMedias() {
        return "medias";
    }

    @GetMapping("/accueil/organisations")
    public String afficherOrganisations() {
        return "organisations";
    }
}
