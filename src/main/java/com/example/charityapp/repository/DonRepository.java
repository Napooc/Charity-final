package com.example.charityapp.repository;

import com.example.charityapp.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DonRepository extends JpaRepository<Don, Long> {
    // Basic CRUD operations are automatically provided by JpaRepository
    // Additional custom queries can be added here if needed
} 