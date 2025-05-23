package com.example.charityapp.dto;

import lombok.Data;

@Data
public class OrganizationDTO {
    private Long id;
    private String nom;
    private String adresseLegale;
    private String numeroFiscal;
    private String contactPrincipal;
    private String logoUrl;
    private String description;
    private boolean estApprouvee;
}

