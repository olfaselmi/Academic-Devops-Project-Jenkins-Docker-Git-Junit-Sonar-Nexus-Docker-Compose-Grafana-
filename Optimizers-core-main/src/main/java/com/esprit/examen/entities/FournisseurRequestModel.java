package com.esprit.examen.entities;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FournisseurRequestModel {


    public FournisseurRequestModel() {
        super();
    }
    public FournisseurRequestModel(Long idFournisseur, String code, String libelle) {
        super();
        this.idFournisseur = idFournisseur;
        this.code = code;
        this.libelle = libelle;
    }
    public Long idFournisseur;
    public String code;
    public String libelle;
    public CategorieFournisseur  categorieFournisseur;
    public Set<Facture> factures;
    public Set<SecteurActivite> secteurActivites;
    public DetailFournisseur detailFournisseur;

}