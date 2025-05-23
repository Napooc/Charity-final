package com.example.charityapp.repository;

import com.example.charityapp.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DonationRepository extends JpaRepository<Don, Long> {
} 