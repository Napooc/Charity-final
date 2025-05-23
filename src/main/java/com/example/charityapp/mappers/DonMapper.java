package com.example.charityapp.mappers;


import com.example.charityapp.dto.DonDTO;
import com.example.charityapp.entities.Don;

public class DonMapper {

    public static Don dtoToEntity(DonDTO dto) {
        Don don = new Don();
        don.setMontant(dto.getMontant());
        don.setDateDon(dto.getDateDon());
        don.setMethodePaiement(dto.getMethodePaiement());
        return don;
    }

    public static DonDTO entityToDto(Don don) {
        DonDTO dto = new DonDTO();
        dto.setMontant(don.getMontant());
        dto.setDateDon(don.getDateDon());
        dto.setMethodePaiement(don.getMethodePaiement());
        return dto;
    }
}