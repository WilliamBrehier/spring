package fr.brehierwilliam.cefim.database;

import fr.brehierwilliam.cefim.feature.database.DatabaseService;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DatabaseTests {

    @Autowired
    private DatabaseService databaseService;

    @Test
    void getProductNameListTest(){
        //test data
//        String[] expected = {"Cheese - Cheddar", "Crush - Grape, 355 Ml", "Container Clear 8 Oz","Walkers Special Old Whiskey", "Bagelers", "Cheese - Comte", "Cheese - Stilton", "Bread - Crumbs, Bulk","Rice - Aborio", "Sole - Dover, Whole, Fresh", "Wine - Alsace Riesling Reserve" };
//        String[] result = {"Cheese - Cheddar", "Crush - Grape, 355 Ml", "Container Clear 8 Oz","Walkers Special Old Whiskey", "Bagelers", "Cheese - Comte", "Cheese - Stilton", "Bread - Crumbs, Bulk","Rice - Aborio", "Sole - Dover, Whole, Fresh", "Wine - Alsace Riesling Reserve" };
//        assertArrayEquals(expected, result);

        String expected = "Cheese - Cheddar, Mild";
        List<String> result = databaseService.getProductNameList();
        assertTrue(result.contains(expected));
    }

    @Test
    void getProductListTest(){
//        //test object
        //Tuple produit1 = new Tuple("Cheese - Cheddar, Mild", "Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis.", 1.61, 2);
        Tuple produit1 = databaseService.getProductList().get(0);

        assertEquals(produit1.get("nom"), "Cheese - Cheddar, Mild");
    }
}
