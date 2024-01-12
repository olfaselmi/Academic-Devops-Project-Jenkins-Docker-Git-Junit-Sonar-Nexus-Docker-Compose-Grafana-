package com.esprit.examen.services;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
public class FactureServiceImplTest {
	@Mock
	FactureRepository factureRepository;

    @InjectMocks
    FactureServiceImpl factureService;

    @Test
    @Order(2)
    public void retrieveAllFactures() {
    	
    	Facture f1 = new Facture(01, 01, new Date(01-01-2001),new Date(02-02-2001), true);
    	Facture f2 = new Facture(02, 02, new Date(01-01-2002),new Date(02-02-2002), true);
    	Facture f3 = new Facture(02, 02, new Date(01-01-2003),new Date(02-02-2003), true);
        List<Facture> factureList = new ArrayList<>();
        factureList.add(f1);
        factureList.add(f2);
        factureList.add(f3);
        when(factureRepository.findAll()).thenReturn(factureList);
        List<Facture> findedFactureList = factureService.retrieveAllFactures();
        verify(factureRepository).findAll();
        assertNotNull(findedFactureList);
        assertTrue(findedFactureList.size() > 0);
        assertSame(findedFactureList, factureList);
    }

    @Test
    @Order(1)
    public void addFacture() {
    	Facture factureAddTest = new Facture(11, 11, new Date(11-11-2001),new Date(22-22-2001), true);
        when(factureRepository.save(ArgumentMatchers.any(Facture.class))).thenReturn(factureAddTest);
        Facture addedFacture = factureService.addFacture(factureAddTest);
        verify(factureRepository).save(factureAddTest);
        assertNotNull(addedFacture);
        assertSame(addedFacture, factureAddTest);
        assertEquals(addedFacture, factureAddTest); 
    }

    

    @Test
    public void retrieveFacture() {
    	Facture factureToRetreiveTest = new Facture(11, 11, new Date(11-11-2001),new Date(22-22-2001), true);
        when(factureRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(factureToRetreiveTest));
        Facture retrieved =  factureService.retrieveFacture(factureToRetreiveTest.getIdFacture());
        verify(factureRepository).findById(factureToRetreiveTest.getIdFacture()); 
  
    }
}
