package com.esprit.examen.services;

import java.util.List;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.FournisseurRequestModel;

public interface IFournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(FournisseurRequestModel f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(FournisseurRequestModel f);

	Fournisseur retrieveFournisseur(Long id);
}
