package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.entities.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    IStockService stockService;
    List<Stock> stocks = new ArrayList<>();

    @Test
    public void getAllStock() {
        assertNotEquals(stocks,stockService.retrieveAllStocks());
    }

    @Test
    public void testAddStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());

    }



    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",30,60);
        Stock savedStock= stockService.addStock(s);
        stockService.deleteStock(savedStock.getIdStock());
        assertNull(stockService.retrieveStock(savedStock.getIdStock()));
    }
}