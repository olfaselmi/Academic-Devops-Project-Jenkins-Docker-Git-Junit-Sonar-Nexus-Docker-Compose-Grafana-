package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {
    @Mock
    OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurService;

    @Test
    @Order(2)
    public void retrieveAllOperateurs() {
        Operateur o1 = new Operateur("nomOp1", "prenomOp1", "xxxx");
        Operateur o2 = new Operateur("nomOp2", "prenomOp2", "xxxx");
        Operateur o3 = new Operateur("nomOp3", "prenomOp3", "xxxx");
        List<Operateur> operateurList = new ArrayList<>();
        operateurList.add(o1);
        operateurList.add(o2);
        operateurList.add(o3);
        when(operateurRepository.findAll()).thenReturn(operateurList);
        List<Operateur> findedOperateurList = operateurService.retrieveAllOperateurs();
        verify(operateurRepository).findAll();
        assertNotNull(findedOperateurList);
        assertTrue(findedOperateurList.size() > 0);
        assertSame(findedOperateurList, operateurList);
    }

    @Test
    @Order(1)
    public void addOperateur() {
        Operateur operateurAddTest = new Operateur("nomOp", "prenomOp", "xxxx");
        when(operateurRepository.save(ArgumentMatchers.any(Operateur.class))).thenReturn(operateurAddTest);
        Operateur addedOperateur = operateurService.addOperateur(operateurAddTest);
        verify(operateurRepository).save(operateurAddTest);
        assertNotNull(addedOperateur);
        assertSame(addedOperateur, operateurAddTest);
        assertEquals(addedOperateur, operateurAddTest);
    }

    @Test
    public void deleteOperateur() {
        Operateur operateurDeleteTest = new Operateur("nomOp", "prenomOp", "xxxx");
        doAnswer( p ->{
            verify(operateurRepository).deleteById(operateurDeleteTest.getIdOperateur());
            assertSame(p,operateurDeleteTest);
            return null;
        }).when(operateurRepository).deleteById(ArgumentMatchers.anyLong());
        operateurService.deleteOperateur(operateurDeleteTest.getIdOperateur());
    }
    @Test
    public void updateOperateur() {
        Operateur operateurAddTest = new Operateur("nomOp", "prenomOp", "xxxx");
        when(operateurRepository.save(ArgumentMatchers.any(Operateur.class))).thenReturn(operateurAddTest);
        Operateur updatedOperateur = operateurService.addOperateur(operateurAddTest);
        verify(operateurRepository).save(operateurAddTest);
        assertNotNull(updatedOperateur);
        assertSame(updatedOperateur, operateurAddTest);
        assertEquals(updatedOperateur, operateurAddTest);
    }

    @Test
    public void retrieveOperateur() {
        Operateur operateurToRetreiveTest = new Operateur("nomOp", "prenomOp", "xxxx");
        when(operateurRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(operateurToRetreiveTest));
        Operateur retrieved =  operateurService.retrieveOperateur(operateurToRetreiveTest.getIdOperateur());
        verify(operateurRepository).findById(operateurToRetreiveTest.getIdOperateur());
      /*  assertNotNull(retrieved);
        assertSame(retrieved,operateurToRetreiveTest);
        assertEquals(operateurToRetreiveTest,retrieved);*/
    }
}