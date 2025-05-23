package com.example.charityapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Organization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "adresse_legale", nullable = false)
    private String adresseLegale;

    @Column(name = "numero_fiscal", nullable = false, unique = true)
    private String numeroFiscal;

    @Column(name = "contact_principal", nullable = false)
    private String contactPrincipal;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "est_approuvee", nullable = false)
    private boolean estApprouvee = false;
}