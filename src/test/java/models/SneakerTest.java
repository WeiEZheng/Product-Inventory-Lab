package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SneakerTest {
    @Test
    public void setNameTest() {
        // given
        String expected = "SomeName";

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setName(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getName());
    }

    @Test
    public void setIDTest() {
        // given
        Integer expected = 1;

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setId(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getId());
    }

    @Test
    public void setBrandTest() {
        // given
        String expected = "SomeBrand";

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setBrand(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getBrand());
    }
    @Test
    public void setSportTest() {
        // given
        String expected = "SomeSport";

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setSport(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getSport());
    }
    @Test
    public void setSizeTest() {
        // given
        double expected = 1;

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setSize(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getSize());
    }
    @Test
    public void setQtyTest() {
        // given
        int expected = 1;

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setQty(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getQty());
    }

    @Test
    public void setPriceTest() {
        // given
        double expected = 9.94;

        // when
        Sneaker testSneaker = new Sneaker();
        testSneaker.setPrice(expected);

        // then
        Assertions.assertEquals(expected, testSneaker.getPrice());
    }

    @Test
    public void constructorTest(){
        // Given
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedQty = 10;
        double expectedSize = 10.5;
        double expectedPrice = 80.00f;

        // When
        Sneaker testSneaker = new Sneaker(expectedId, expectedName, expectedBrand,
                expectedSport, expectedSize,expectedQty,expectedPrice);

        // then
        Assertions.assertEquals(expectedId, testSneaker.getId());
        Assertions.assertEquals(expectedName, testSneaker.getName());
        Assertions.assertEquals(expectedBrand, testSneaker.getBrand());
        Assertions.assertEquals(expectedSport, testSneaker.getSport());
        Assertions.assertEquals(expectedSize, testSneaker.getSize());
        Assertions.assertEquals(expectedQty, testSneaker.getQty());
        Assertions.assertEquals(expectedPrice, testSneaker.getPrice());
    }
}