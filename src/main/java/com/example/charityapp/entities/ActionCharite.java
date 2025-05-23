package com.example.charityapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "action_charite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionCharite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_action", nullable = false)
    private Date date;

    @Column(nullable = false)
    private String lieu;

    @Column(name = "objectif_collecte", nullable = false)
    private Double objectifCollecte;

    @Column(name = "montant_actuel")
    private Double montantActuel = 0.0;

    @Column(name = "media_url")
    private String mediaUrl;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "est_archivee")
    private boolean estArchivee = false;
}
