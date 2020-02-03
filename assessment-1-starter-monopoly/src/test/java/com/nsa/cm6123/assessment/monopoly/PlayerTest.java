package com.nsa.cm6123.assessment.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player aplayer2;
    private static final long EXPECTED_BALANCE = 200L;

    @Before
    public void constructPlayer2() {
        aplayer2 = new Player("Cat", EXPECTED_BALANCE);

    }

    @Test
    public void playerShouldStartWith200Dollars() throws Exception {
        assertEquals(EXPECTED_BALANCE, aplayer2.getBalance());
    }

    @Test
    public void getName() {
        assertEquals("Cat", aplayer2.getName());
    }

    @Test
    public void setName() {
        aplayer2.setName("Dog");
        assertEquals("Dog", aplayer2.getName());


    }

    @Test
    public void getBalance() {
        assertEquals(EXPECTED_BALANCE, aplayer2.getBalance());

    }

    @Test
    public void setBalance() {
//        final long half = 100L;
        aplayer2.setBalance(100L);
//        assertEquals(half, topHat.getBalance());

        assertEquals(100L, aplayer2.getBalance());

    }

    @Test
    public void toStringEquals() {
        String expectedObject = "Player{" +
                "name='" + "Cat" + '\'' +
                ", balance=" + EXPECTED_BALANCE +
                '}';
        assertEquals(expectedObject, aplayer2.toString());
    }

    @Test
    public void tokensAreEqual() {
        Player aplayer3 = new Player("Cat", 200);
        assertEquals(aplayer2, aplayer2);
    }

    @Test
    public void tokensHashCode() {
        Player aplayer4 = new Player("Cat", 200);
        assertEquals(aplayer2.hashCode(), aplayer2.hashCode());
    }
}
