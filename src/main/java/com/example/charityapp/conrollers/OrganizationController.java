package com.example.charityapp.conrollers;
import lombok.RequiredArgsConstructor;
import com.example.charityapp.dto.OrganizationDTO;
import com.example.charityapp.services.OrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    public String listOrganizations(Model model) {
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        return "liste_organizations";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("organization", new OrganizationDTO());
        return "ajouter_organization";
    }

    @PostMapping
    public String saveOrganization(@ModelAttribute("organization") OrganizationDTO dto) {
        organizationService.saveOrganization(dto);
        return "redirect:/organizations";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return "redirect:/organizations";
    }
}
