package com.sidace.student_managment.dao.Impl;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sidace.student_managment.dao.UtilisateurDao;
import com.sidace.student_managment.entities.Utilisateur;
import com.sidace.student_managment.enumeration.Classe;
import com.sidace.student_managment.enumeration.Role;
import com.sidace.student_managment.repository.UtilisateurRepository;
@Component
public class UtilisateurDaoImpl01 implements UtilisateurDao {
	@Autowired
	private UtilisateurRepository utilisateurRepository ;
    
    // Create new user
    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        if (utilisateurRepository.existsByUsername(utilisateur.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (utilisateurRepository.existsByEmail(utilisateur.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (utilisateurRepository.existsByCin(utilisateur.getCin())) {
            throw new RuntimeException("CIN already exists");
        }
        if (utilisateurRepository.existsByPhone(utilisateur.getPhone())) {
            throw new RuntimeException("Phone number already exists");
        }
        return utilisateurRepository.save(utilisateur);
    }
    
    // Get user by ID
    @Override
    public Optional<Utilisateur> getUtilisateur(UUID id) {
        return utilisateurRepository.findById(id);
    }
    
    // Update user
    @Override
    public Utilisateur updateUtilisateur(UUID id, Utilisateur utilisateur) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }
    
    // Delete user
    @Override
    public void deleteUtilisateur(UUID id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        utilisateurRepository.deleteById(id);
    }
    
    // Get all users
    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }
    
    // Get users by role
    @Override
    public List<Utilisateur> getUtilisateursByRole(Role role) {
        return utilisateurRepository.findByRole(role);
    }
    
    // Get users by promotion
    @Override
    public List<Utilisateur> getUtilisateursByPromo(String promo) {
        return utilisateurRepository.findByPromo(promo);
    }
    
    // Search users by name
    @Override
    public List<Utilisateur> searchUtilisateursByName(String searchTerm) {
        return utilisateurRepository.searchByName(searchTerm);
    }
    
    // Get users by class
    @Override
    public List<Utilisateur> getUtilisateursByClasse(Classe classe) {
        return utilisateurRepository.findByClasse(classe);
    }
    
    // Get users by age range
    @Override
    public List<Utilisateur> getUtilisateursByAgeRange(Date startDate, Date endDate) {
        return utilisateurRepository.findByDateNaissanceBetween(startDate, endDate);
    }
    
    // Update user image
    @Override
    public Utilisateur updateUtilisateurImage(UUID id, Blob image) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur updatedUtilisateur = utilisateur.get();
            updatedUtilisateur.setImage(image);
            return utilisateurRepository.save(updatedUtilisateur);
        }
        throw new RuntimeException("User not found");
    }
}
