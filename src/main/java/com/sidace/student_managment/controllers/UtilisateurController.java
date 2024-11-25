package com.sidace.student_managment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sidace.student_managment.entities.Utilisateur;
import com.sidace.student_managment.services.UtilisateurService;
@RestController
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping(path = "/createUtilisateur")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.createUtilisateur(utilisateur);
	}

}
