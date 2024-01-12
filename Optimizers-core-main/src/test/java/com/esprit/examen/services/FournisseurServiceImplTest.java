/*package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
	@Autowired
	IFournisseurService FournisseurService;

	
	@Test
	public void testAddFournisseur() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
		Fournisseur c = new Fournisseur("30", "test", "ORDINAIRE", "ORDINAIRE", "pwd", "DetailFournisseur"," " );
        Fournisseur Fournisseur = FournisseurService.addFournisseur(f);
		System.out.print("Fournisseur "+Fournisseur);
		assertNotNull(Fournisseur.getIdClient());
		assertNotNull(Fournisseur.getCategorieClient());
		assertTrue(Fournisseur.getLibelle().length() > 0);
        FournisseurServiceImpl.deleteFournisseur(Fournisseur.getIdFournisseur());

	}
	@Test
	public void testDeleteFournisseur() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
        Fournisseur c = new Fournisseur("Salhi", "Ahmed", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
				CategorieClient.Ordinaire);
		Client client = clientService.addClient(c);
		clientService.deleteClient(client.getIdClient());
		assertNull(FournisseurServiceImpl.retrieveFournisseur(Fournisseur.getIdFournisseur()));
	}

	@Test
	public void testRetrieveAllFournisseurs() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateNaissance = dateFormat.parse("30/09/2000");
		List<Client> clients = clientService.retrieveAllClients();
		int expected = clients.size();
		Client c = new Client("Salhi", "Ahmed", dateNaissance, "ahmed.salhi@esprit.tn", "pwd", Profession.Cadre,
				CategorieClient.Ordinaire);
		Client client = clientService.addClient(c);
		assertEquals(expected + 1, clientService.retrieveAllClients().size());
		clientService.deleteClient(client.getIdClient());

	}


}*/
