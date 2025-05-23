package com.example.charityapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "dons")
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long don_id;

    @Column(nullable = false)
    private BigDecimal montant;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String email;

    @Column(name = "date_don", nullable = false)
    private LocalDateTime dateDon;

    @ManyToOne
    @JoinColumn(name = "action_id", nullable = false)
    private ActionCharite actionCharite;

    // Getters and Setters
    public Long getDon_id() {
        return don_id;
    }

    public void setDon_id(Long don_id) {
        this.don_id = don_id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateDon() {
        return dateDon;
    }

    public void setDateDon(LocalDateTime dateDon) {
        this.dateDon = dateDon;
    }

    public ActionCharite getActionCharite() {
        return actionCharite;
    }

    public void setActionCharite(ActionCharite actionCharite) {
        this.actionCharite = actionCharite;
    }
} 