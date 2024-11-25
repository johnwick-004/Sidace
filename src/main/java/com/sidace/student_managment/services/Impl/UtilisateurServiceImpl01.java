package com.sidace.student_managment.services.Impl;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidace.student_managment.dao.UtilisateurDao;
import com.sidace.student_managment.entities.Utilisateur;
import com.sidace.student_managment.enumeration.Classe;
import com.sidace.student_managment.enumeration.Role;
import com.sidace.student_managment.repository.UtilisateurRepository;
import com.sidace.student_managment.services.UtilisateurService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UtilisateurServiceImpl01 implements UtilisateurService{
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.createUtilisateur(utilisateur);
	}
    
}