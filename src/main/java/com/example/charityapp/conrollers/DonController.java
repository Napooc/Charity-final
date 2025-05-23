package com.example.charityapp.conrollers;


import com.example.charityapp.dto.DonDTO;
import com.example.charityapp.services.DonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Donations")
public class DonController {

    private final DonService donService;

    public DonController(DonService donService) {
        this.donService = donService;
    }

    @GetMapping
    public String afficherDons(Model model) {
        model.addAttribute("dons", donService.getAllDons());
        return "liste";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("donDTO", new DonDTO());
        return "ajouterDon";
    }

    @PostMapping("/ajouter")
    public String ajouterDon(@ModelAttribute("donDTO") DonDTO donDTO) {
        donService.createDonFromDto(donDTO);
        return "redirect:/dons";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerDon(@PathVariable Long id) {
        donService.deleteDon(id);
        return "redirect:/dons";
    }
}
