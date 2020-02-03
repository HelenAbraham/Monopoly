package com.nsa.cm6123.assessment.monopoly;

public class Location {
    private String name;
    private int value;
    private int housePrice;
    private Player playerOwner;
    private int numberOfHouses;


    public Location(final String aname, final int avalue,
                    final int ahousePrice) {
        this.name = aname;
        this.value = avalue;
        this.housePrice = ahousePrice;
        numberOfHouses = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(final String aname) {
        this.name = aname;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int avalue) {
        this.value = avalue;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(final int price, final int ahousePrice) {
        this.housePrice = ahousePrice;
    }

    public Player getPlayerOwner() {
        return playerOwner;
    }

    public void setPlayerOwner(final Player aplayerOwner) {
        this.playerOwner = aplayerOwner;
    }

    public int getNumberOfHouses() {
        return numberOfHouses;
    }

    public void setNumberOfHouses(final int anumberOfHouses) {
        this.numberOfHouses = anumberOfHouses;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", housePrice=" + housePrice +
                ", playerOwner=" + playerOwner +
                ", numberOfHouses=" + numberOfHouses +
                '}';
    }


}
