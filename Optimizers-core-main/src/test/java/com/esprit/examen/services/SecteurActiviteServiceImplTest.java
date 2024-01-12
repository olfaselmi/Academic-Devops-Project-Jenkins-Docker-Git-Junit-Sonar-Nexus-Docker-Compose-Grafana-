package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteServiceImplTest {
	@Mock
	SecteurActiviteRepository secteuractiviteRepository;
	
	@InjectMocks
	SecteurActiviteServiceImpl secteuractiviteService;
	
	@Test
	@Order(1)
	public void addSecteurActivite(){
		 SecteurActivite secteuractiviteAddTest = new SecteurActivite("codeSecteurActivite00", "libelleSecteurActivite00");
	        when(secteuractiviteRepository.save(ArgumentMatchers.any(SecteurActivite.class))).thenReturn(secteuractiviteAddTest);
	        SecteurActivite addedSecteurActivite = secteuractiviteService.addSecteurActivite(secteuractiviteAddTest);
	        verify(secteuractiviteRepository).save(secteuractiviteAddTest);
	        assertNotNull(addedSecteurActivite);
	        assertSame(addedSecteurActivite, secteuractiviteAddTest);
	        assertEquals(addedSecteurActivite, secteuractiviteAddTest);

	}
	
	@Test
    @Order(2)
	public void retrieveAllSecteurActivite(){
		SecteurActivite sa1 = new SecteurActivite("codeSecteurActivite01", "libelleSecteurActivite01");
		SecteurActivite sa2 = new SecteurActivite("codeSecteurActivite02", "libelleSecteurActivite02");
		SecteurActivite sa3 = new SecteurActivite("codeSecteurActivite03", "libelleSecteurActivite03");
        List<SecteurActivite> secteuractiviteList = new ArrayList<>();
        secteuractiviteList.add(sa1);
        secteuractiviteList.add(sa2);
        secteuractiviteList.add(sa3);
        when(secteuractiviteRepository.findAll()).thenReturn(secteuractiviteList);
        List<SecteurActivite> findedSecteurActiviteList = secteuractiviteService.retrieveAllSecteurActivite();
        verify(secteuractiviteRepository).findAll();
        assertNotNull(findedSecteurActiviteList);
        assertTrue(findedSecteurActiviteList.size() > 0);
        assertSame(findedSecteurActiviteList, secteuractiviteList);
		
	}
	
	@Test
	@Order(4)
	public void deleteSecteurActivite(){
		SecteurActivite secteuractiviteDeleteTest = new SecteurActivite("codeSecteurActivite00", "libelleSecteurActivite00");
        doAnswer( p ->{
            verify(secteuractiviteRepository).deleteById(secteuractiviteDeleteTest.getIdSecteurActivite());
            assertSame(p,secteuractiviteDeleteTest);
            return null;
        }).when(secteuractiviteRepository).deleteById(ArgumentMatchers.anyLong());
        secteuractiviteService.deleteSecteurActivite(secteuractiviteDeleteTest.getIdSecteurActivite());
	}
	
	@Test
	@Order(3)
	public void updateSecteurActivite(){
		SecteurActivite secteuractiviteAddTest = new SecteurActivite("codeSecteurActivite00", "libelleSecteurActivite00");
        when(secteuractiviteRepository.save(ArgumentMatchers.any(SecteurActivite.class))).thenReturn(secteuractiviteAddTest);
        SecteurActivite updatedSecteurActivite = secteuractiviteService.addSecteurActivite(secteuractiviteAddTest);
        verify(secteuractiviteRepository).save(secteuractiviteAddTest);
        assertNotNull(updatedSecteurActivite);
        assertSame(updatedSecteurActivite, secteuractiviteAddTest);
        assertEquals(updatedSecteurActivite, secteuractiviteAddTest);
		
	}
	@Test
	@Order(5)
	public void retrieveSecteurActivite(){
		SecteurActivite secteuractiviteToRetreiveTest = new SecteurActivite("codeSecteurActivite00", "libelleSecteurActivite00");
        when(secteuractiviteRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(secteuractiviteToRetreiveTest));
        SecteurActivite retrieved =  secteuractiviteService.retrieveSecteurActivite(secteuractiviteToRetreiveTest.getIdSecteurActivite());
        verify(secteuractiviteRepository).findById(secteuractiviteToRetreiveTest.getIdSecteurActivite());
		
	}
}
