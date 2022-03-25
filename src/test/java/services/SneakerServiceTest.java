package services;

import models.Sneaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SneakerServiceTest {
    @Test
    public void createTest(){
        // given
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        double expectedSize = 10.5;
        int expectedQty = 10;
        double expectedPrice = 80.00f;
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // then
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        double actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        double actualPrice = testSneaker.getPrice();

        // when
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSport, actualSport);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void findSneakerTest() {
        SneakerService sneakerService0 = new SneakerService();
        Sneaker testSneaker = sneakerService0.create("w", "",
                "", 0, 1, 0);
        Sneaker testSneaker2 = sneakerService0.create("testSneaker2", "3",
                "3", 0, 1, 0);
        String expectedName = sneakerService0.findSneaker(2).getName();
        Assertions.assertEquals(expectedName, "testSneaker2");
    }

    @Test
    void findAll() {
        SneakerService sneakerService2 = new SneakerService();
        Sneaker testSneaker = sneakerService2.create("w", "",
                "", 0, 1, 0);
        Sneaker testSneaker2 = sneakerService2.create("testSneaker2", "3",
                "3", 0, 1, 0);
        Sneaker[] expectedArr = sneakerService2.findAll();
        Assertions.assertEquals(2,expectedArr.length);
    }

    @Test
    void deleteSneakerTest() {
        SneakerService sneakerService1 = new SneakerService();
        Sneaker testSneaker = sneakerService1.create("", "",
                "", 0, 1, 0);
        Sneaker testSneaker2 = sneakerService1.create("testSneaker2", "",
                "", 0, 1, 0);
        Assertions.assertTrue(sneakerService1.delete(2));
    }
}