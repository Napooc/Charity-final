package com.example.charityapp.mappers;
import com.example.charityapp.dto.OrganizationDTO;
import com.example.charityapp.entities.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper {

    public OrganizationDTO toDTO(Organization organization) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setId(organization.getId());
        dto.setNom(organization.getNom());
        dto.setAdresseLegale(organization.getAdresseLegale());
        dto.setNumeroFiscal(organization.getNumeroFiscal());
        dto.setContactPrincipal(organization.getContactPrincipal());
        dto.setLogoUrl(organization.getLogoUrl());
        dto.setDescription(organization.getDescription());
        dto.setEstApprouvee(organization.isEstApprouvee());
        return dto;
    }

    public Organization toEntity(OrganizationDTO dto) {
        Organization organization = new Organization();
        organization.setId(dto.getId());
        organization.setNom(dto.getNom());
        organization.setAdresseLegale(dto.getAdresseLegale());
        organization.setNumeroFiscal(dto.getNumeroFiscal());
        organization.setContactPrincipal(dto.getContactPrincipal());
        organization.setLogoUrl(dto.getLogoUrl());
        organization.setDescription(dto.getDescription());
        organization.setEstApprouvee(dto.isEstApprouvee());
        return organization;
    }
}
