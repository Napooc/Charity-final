package com.example.charityapp.service;

import com.example.charityapp.model.Don;
import com.example.charityapp.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public List<Don> getAllDonations() {
        return donationRepository.findAll();
    }

    public Optional<Don> getDonationById(Long id) {
        return donationRepository.findById(id);
    }

    public Don saveDonation(Don donation) {
        return donationRepository.save(donation);
    }

    public void deleteDonationById(Long id) {
        donationRepository.deleteById(id);
    }
} 