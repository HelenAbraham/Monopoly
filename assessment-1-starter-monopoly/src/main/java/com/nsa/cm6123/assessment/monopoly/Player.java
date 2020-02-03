package com.nsa.cm6123.assessment.monopoly;

import java.util.Objects;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Player {

    private static Logger logger = null;

    static {
        InputStream stream = Player.class.getClassLoader()
                .getResourceAsStream("logging.properties");
        //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(Player.class.getName());
            //replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String name;
    private long balance;
    private int position = 0;

    private static final long STARTING_BALANCE = 200L;


    public Player(final String aName, final long aBalance) {
        this.name = aName;
        this.balance = aBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(final String aName) {
        this.name = aName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(final long aBalance) {
        this.balance = aBalance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return balance == player.balance &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance);
    }

    public int getPosition() { //NO.3 - NOT DONE!!
        return position;
    }

    public void setPosition(final int aposition) {
        this.position = aposition;
    }
}
