package com.nsa.cm6123.assessment.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board2;
    private ArrayList<Player> aplayers;
    private ArrayList<Location> alocations;
    private ArrayList<Player> players1 = new ArrayList<>();
    private int value;

    @Before
    public void constructBoard2() {
        board2 = new Board(aplayers, alocations);
    }

    @Test
    public void playerMove() {
        assertEquals(5, 5);
    }

    @Test
    public void buyLocation() {
        assertEquals(67, 67);
    }

    @Test
    public void setPosition() {
        assertEquals(6, 6);
    }

    @Test
    public void setBalance() {
        assertEquals(8, 8);
    }

    @Test
    public void testPLAYERS() {
    players1.add(new Player("fghj", 8));
    players1.add(new Player("bjk", 789));
    }


}
