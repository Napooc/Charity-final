package com.example.charityapp.services;

import lombok.RequiredArgsConstructor;
import com.example.charityapp.dto.OrganizationDTO;
import com.example.charityapp.entities.Organization;
import com.example.charityapp.mappers.OrganizationMapper;
import com.example.charityapp.repositories.OrganisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganisationRepository organisationRepository;
    private final OrganizationMapper mapper;

    public List<OrganizationDTO> getAllOrganizations() {
        return organisationRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public void saveOrganization(OrganizationDTO dto) {
        organisationRepository.save(mapper.toEntity(dto));
    }

    public OrganizationDTO getOrganizationById(Long id) {
        Organization organization = organisationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisation introuvable"));
        return mapper.toDTO(organization);
    }

    public void deleteOrganization(Long id) {
        organisationRepository.deleteById(id);
    }
}