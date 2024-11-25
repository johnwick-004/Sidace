package com.sidace.student_managment.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sidace.student_managment.entities.Utilisateur;
import com.sidace.student_managment.enumeration.Classe;
import com.sidace.student_managment.enumeration.Role;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, UUID> {
    
    // Find user by username
    Optional<Utilisateur> findByUsername(String username);
    
    // Find user by email
    Optional<Utilisateur> findByEmail(String email);
    
    // Find user by CIN
    Optional<Utilisateur> findByCin(String cin);
    
    // Find user by phone number
    Optional<Utilisateur> findByPhone(String phone);
    
    // Find users by role
    List<Utilisateur> findByRole(Role role);
    
    // Find users by promotion
    List<Utilisateur> findByPromo(String promo);
    
    // Find users by class
    List<Utilisateur> findByClasse(Classe classe);
    
    // Find users by nationality
    List<Utilisateur> findByNationality(String nationality);
    
    // Custom query to search users by name (first name or last name)
    @Query("SELECT u FROM Utilisateur u WHERE LOWER(u.prenom) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(u.nom) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Utilisateur> searchByName(@Param("searchTerm") String searchTerm);
    
    // Check if username exists
    boolean existsByUsername(String username);
    
    // Check if email exists
    boolean existsByEmail(String email);
    
    // Check if CIN exists
    boolean existsByCin(String cin);
    
    // Check if phone exists
    boolean existsByPhone(String phone);
    
    // Find users by age range
    @Query("SELECT u FROM Utilisateur u WHERE u.dateNaissance BETWEEN :startDate AND :endDate")
    List<Utilisateur> findByDateNaissanceBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}