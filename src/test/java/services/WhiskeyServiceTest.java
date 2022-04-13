package services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import models.Whiskey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WhiskeyServiceTest {
    @Test
    void createTest() {
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        Double expectedAlc = 0.30;
        double expectedSize = 1.5;
        double expectedPrice = 80.00f;
        int expectedQty = 10;
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey testWhiskey = whiskeyService.create(expectedName, expectedBrand, expectedAlc, expectedSize, expectedPrice, expectedQty);

        int actualId = testWhiskey.getId();
        String actualName = testWhiskey.getName();
        String actualBrand = testWhiskey.getBrand();
        double actualAlc = testWhiskey.getAlcConcentration();
        double actualSize = testWhiskey.getSize();
        int actualQty = testWhiskey.getQty();
        double actualPrice = testWhiskey.getPrice();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedAlc, actualAlc);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
    @Test
    void findTest(){
        WhiskeyService whiskeyService0 = new WhiskeyService();
        Whiskey whiskey = whiskeyService0.create("1","",0,0.0,0,1);
        whiskeyService0.create("2","",0,0.0,0,1);
        Assertions.assertEquals(whiskey,whiskeyService0.findWhiskey(whiskey.getId()));
    }

    @Test
    void findAllTest(){
        WhiskeyService whiskeyService1 = new WhiskeyService();
        whiskeyService1.create("1","",0,0.0,0,1);
        whiskeyService1.create("2","",0,0.0,0,1);
        Whiskey[] whiskies = whiskeyService1.findAll();
        Assertions.assertEquals(2,whiskies.length);
    }

    @Test
    void deleteTest(){
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey whiskey = whiskeyService.create("1","",0,0.0,0,1);
        whiskeyService.create("2","",0,0.0,0,1);
        Assertions.assertTrue(whiskeyService.delete(whiskey.getId()));
    }
}