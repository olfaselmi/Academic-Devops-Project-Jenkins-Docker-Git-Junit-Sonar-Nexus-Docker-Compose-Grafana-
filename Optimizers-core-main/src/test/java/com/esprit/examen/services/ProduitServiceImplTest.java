package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {

    @Mock
    StockRepository stockRepository;

    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitService;


    @Test
    @DisplayName("add produit test")
    @Order(1)
    public void testAddProduit() {
        Produit produit = new Produit("addtest", "libelleTest", (float) 2.2);
        when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
        Produit produitToAdd = produitService.addProduit(produit);
        verify(produitRepository).save(produit);
        assertNotNull(produitToAdd);
        assertEquals(produitToAdd, produit);
        assertSame(produitToAdd, produit);

    }

    @Test
    @DisplayName("retreive all produits test")
    @Order(2)
    public void retreiveAllProduitTest() {
        Produit p1 = new Produit("retrieveAlltest1", "libelleTest", (float) 2.2);
        Produit p2 = new Produit("retrieveAlltest2", "libelleTest", (float) 2.2);
        Produit p3 = new Produit("retrieveAlltest3", "libelleTest", (float) 2.2);
        List<Produit> produitList = new ArrayList<>();
        produitList.add(p1);
        produitList.add(p2);
        produitList.add(p3);
        when(produitRepository.findAll()).thenReturn(produitList);
        List<Produit> listToCheck = produitService.retrieveAllProduits();
        verify(produitRepository).findAll();
        assertNotNull(listToCheck);
        assertTrue(listToCheck.size() > 1);
        assertEquals(3, listToCheck.size());
        assertSame(produitList, listToCheck);
    }

    @Test
    @DisplayName("delete produit test")
    @Order(3)
    public void testDeleteProduit() {
        Produit produitToDeleteTest = new Produit("deleteTest", "liblee", (float) 1.1);
        doAnswer(p -> {
            verify(produitRepository).deleteById(produitToDeleteTest.getIdProduit());
            assertSame(p, produitToDeleteTest);
            return null;
        }).when(produitRepository).deleteById(ArgumentMatchers.anyLong());
        produitService.deleteProduit(produitToDeleteTest.getIdProduit());
    }

    @Test
    @DisplayName("update produit test")
    @Order(4)
    public void testUpdateProduit() {
        Produit produit = new Produit("addtest", "libelleTest", (float) 2.2);
        when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
        Produit produitToUpdate = produitService.updateProduit(produit);
        verify(produitRepository).save(produit);
        assertNotNull(produitToUpdate);
        assertEquals(produitToUpdate, produit);
        assertSame(produitToUpdate, produit);
    }

   /* @Test
    @Order(5)
    public void assignProduitToStock() {
        Stock stock = new Stock("test",1,1);
        Produit produit = new Produit("addtest", "libelleTest", (float) 2.2);
        doAnswer(p ->{
            when(stockRepository.getById(ArgumentMatchers.anyLong())).thenReturn(stock);
            when(produitRepository.getById(ArgumentMatchers.anyLong())).thenReturn(produit);
            verify(stockRepository).getById(ArgumentMatchers.anyLong());
            verify(produitRepository).getById(ArgumentMatchers.anyLong());
            stock.getProduits().add(produit);
            assertTrue(stock.getProduits().contains(produit));
            return null;
        }).when(produitService).assignProduitToStock(ArgumentMatchers.anyLong(),ArgumentMatchers.anyLong());
        produitService.assignProduitToStock(produit.getIdProduit(),stock.getIdStock());


    }*/

}