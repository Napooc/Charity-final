package com.example.charityapp.service;

import com.example.charityapp.model.ActionCharite;
import com.example.charityapp.repository.ActionChariteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActionChariteService {

    private final ActionChariteRepository actionRepo;

    @Autowired
    public ActionChariteService(ActionChariteRepository actionRepo) {
        this.actionRepo = actionRepo;
    }

    public List<ActionCharite> findAll() {
        return actionRepo.findAll();
    }

    public Optional<ActionCharite> findById(Long id) {
        return actionRepo.findById(id);
    }

    public ActionCharite save(ActionCharite actionCharite) {
        return actionRepo.save(actionCharite);
    }

    public void deleteById(Long id) {
        actionRepo.deleteById(id);
    }

    public long count() {
        return actionRepo.count();
    }
} 