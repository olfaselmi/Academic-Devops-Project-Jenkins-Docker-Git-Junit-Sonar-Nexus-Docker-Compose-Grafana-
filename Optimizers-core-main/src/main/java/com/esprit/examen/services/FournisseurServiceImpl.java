package com.esprit.examen.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.FournisseurRequestModel;

import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import java.util.List;
@Service
@Slf4j
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;
	@Autowired
	DetailFournisseurRepository detailFournisseurRepository;
	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;

	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {


		return fournisseurRepository.findAll();
	}


	public Fournisseur addFournisseur(FournisseurRequestModel f /*Master*/) {
		Fournisseur f1= new Fournisseur(f.idFournisseur,f.code,f.libelle);
		fournisseurRepository.save(f1);
		return f1;
	}


	@Override
	public Fournisseur updateFournisseur(FournisseurRequestModel f) {
		fournisseurRepository.save( new Fournisseur(f.idFournisseur,f.code,f.libelle));
		return  new Fournisseur(f.idFournisseur,f.code,f.libelle);
	}

	@Override
	public void deleteFournisseur(Long fournisseurId) {
		fournisseurRepository.deleteById(fournisseurId);

	}

	@Override
	public Fournisseur retrieveFournisseur(Long fournisseurId) {

		return fournisseurRepository.findById(fournisseurId).orElse(null);

	}





}