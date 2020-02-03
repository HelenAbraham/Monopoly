package com.nsa.cm6123.assessment.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    private Location malpas;

    @Before
    public void constructMaplas() {
        malpas = new Location("Malpas", 20, 20);

    }

    @Test
    public void getName() {
        assertEquals("Malpas", malpas.getName());
    }

    @Test
    public void setName() {
        malpas.setName("Street");
        assertEquals("Street", malpas.getName());
    }

    @Test
    public void getValue() {
        assertEquals(20, malpas.getValue());
    }

    @Test
    public void setValue() {
        malpas.setValue(10);
        assertEquals(10, malpas.getValue());
    }

    @Test
    public void getHousePrice() {
        assertEquals(20, malpas.getHousePrice());
    }

    @Test
    public void setHousePrice() {
        malpas.setHousePrice(10, malpas.getHousePrice());
    }


}

