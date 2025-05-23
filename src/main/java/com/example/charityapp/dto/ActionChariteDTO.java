package com.example.charityapp.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ActionChariteDTO {
    private Long id;
    private String titre;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String lieu;
    private Double objectifCollecte;
    private Double montantActuel;
    private String mediaUrl;
    private Long organizationId;
    private boolean estArchivee;
}
