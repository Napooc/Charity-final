package com.example.charityapp.mappers;

import com.example.charityapp.dto.ActionChariteDTO;
import com.example.charityapp.entities.ActionCharite;
import com.example.charityapp.entities.Organization;

public class ActionChariteMapper {

    public static ActionChariteDTO toDTO(ActionCharite action) {
        ActionChariteDTO dto = new ActionChariteDTO();
        dto.setId(action.getId());
        dto.setTitre(action.getTitre());
        dto.setDescription(action.getDescription());
        dto.setDate(action.getDate());
        dto.setLieu(action.getLieu());
        dto.setObjectifCollecte(action.getObjectifCollecte());
        dto.setMontantActuel(action.getMontantActuel());
        dto.setMediaUrl(action.getMediaUrl());
        dto.setEstArchivee(action.isEstArchivee());
        dto.setOrganizationId(action.getOrganization().getId());
        return dto;
    }

    public static ActionCharite toEntity(ActionChariteDTO dto, Organization organization) {
        ActionCharite action = new ActionCharite();
        action.setId(dto.getId());
        action.setTitre(dto.getTitre());
        action.setDescription(dto.getDescription());
        action.setDate(dto.getDate());
        action.setLieu(dto.getLieu());
        action.setObjectifCollecte(dto.getObjectifCollecte());
        action.setMontantActuel(dto.getMontantActuel());
        action.setMediaUrl(dto.getMediaUrl());
        action.setEstArchivee(dto.isEstArchivee());
        action.setOrganization(organization);
        return action;
    }
}
