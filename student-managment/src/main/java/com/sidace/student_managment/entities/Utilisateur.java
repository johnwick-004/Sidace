package com.sidace.student_managment.entities;

import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

import com.sidace.student_managment.enumeration.Classe;
import com.sidace.student_managment.enumeration.Role;
import com.sidace.student_managment.enumeration.Sex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(nullable = true, unique = true) 
	private String username;
	@Column(nullable = true)
	private String password;
	@Column(nullable = true, unique = true)
	private String email;
	@Column(nullable = true)
	private String prenom;
	@Column(nullable = true)
	private String nom;
	@Column(nullable = true, unique = true)
	private String cin;
	@Column(nullable = true)
	private String promo;
	@Column(nullable = true)
	private String nationality;
	@Column(nullable = true)
	private String addresse;
	@Column(nullable = true) 
	@Enumerated (EnumType.STRING)
	private Role role;
	@Column(nullable = true, unique = true)
	private String phone;
	@Column(nullable = true)
	private Date dateNaissance;
	@Column(nullable = true)
	private Blob image;
	@Column(nullable = true)
	@Enumerated (EnumType.STRING)
	private Classe classe;
	@Column(nullable = true)
	@Enumerated (EnumType.STRING)
	private Sex sex;

}

