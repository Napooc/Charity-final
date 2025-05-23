package com.example.charityapp.repository;

import com.example.charityapp.model.ActionCharite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ActionChariteRepository extends JpaRepository<ActionCharite, Long> {
    // Add custom query methods if needed
} 