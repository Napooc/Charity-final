package com.example.charityapp.services;

import com.example.charityapp.dto.DonDTO;
import com.example.charityapp.entities.Don;
import com.example.charityapp.mappers.DonMapper;
import com.example.charityapp.repositories.DonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DonService {

    private final DonRepository donRepository;

    public DonService(DonRepository donRepository) {
        this.donRepository = donRepository;
    }

    public List<Don> getAllDons() {
        return donRepository.findAll();
    }

    public Optional<Don> getDonById(Long id) {
        return donRepository.findById(id);
    }

    public Don createDon(Don don) {
        return donRepository.save(don);
    }

    public Don createDonFromDto(DonDTO dto) {
        Don don = DonMapper.dtoToEntity(dto);
        return donRepository.save(don);
    }

    public void deleteDon(Long id) {
        donRepository.deleteById(id);
    }

    public List<DonDTO> getAllDonDTOs() {
        return donRepository.findAll().stream()
                .map(DonMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
