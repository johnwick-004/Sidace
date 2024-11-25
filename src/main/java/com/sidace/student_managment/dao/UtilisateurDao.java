package com.sidace.student_managment.dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sidace.student_managment.entities.Utilisateur;
import com.sidace.student_managment.enumeration.Classe;
import com.sidace.student_managment.enumeration.Role;
import com.sidace.student_managment.repository.UtilisateurRepository;

public interface UtilisateurDao {

    
    
    // Create new user
    public Utilisateur createUtilisateur(Utilisateur utilisateur);
    
    // Get user by ID
    
    public Optional<Utilisateur> getUtilisateur(UUID id) ;
    // Update user
    
    public Utilisateur updateUtilisateur(UUID id, Utilisateur utilisateur) ;
    
    // Delete user
    
    public void deleteUtilisateur(UUID id) ;
    
    // Get all users
   
    public List<Utilisateur> getAllUtilisateurs() ;
    
    // Get users by role
    
    public List<Utilisateur> getUtilisateursByRole(Role role) ;
    
    // Get users by promotion
   
    public List<Utilisateur> getUtilisateursByPromo(String promo) ;
    
    // Search users by name
    
    public List<Utilisateur> searchUtilisateursByName(String searchTerm) ;
    
    // Get users by class
    
    public List<Utilisateur> getUtilisateursByClasse(Classe classe) ;
    
    // Get users by age range
    
    public List<Utilisateur> getUtilisateursByAgeRange(Date startDate, Date endDate) ;
    
    // Update user image
    
    public Utilisateur updateUtilisateurImage(UUID id, Blob image) ;
}
