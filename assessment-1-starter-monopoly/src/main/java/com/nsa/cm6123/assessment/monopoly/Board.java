package com.nsa.cm6123.assessment.monopoly;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class Board {
    private static Logger logger = null;
    private ArrayList<Player> players;
    private ArrayList<Location> locations;
    private final int b = 200;
    private final int s = 6;
    private final int o = 1;
    private final int t = 10;
    private final int f = 4;
    private final int fifty = 50;

    static {
        InputStream stream = MBoard.class.getClassLoader()
                .getResourceAsStream("logging.properties");
        //replace Player with the name of the class
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(MBoard.class.getName());
            //replace Player with the name of the class
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Board(final ArrayList<Player> aplayers,
                 final ArrayList<Location> alocations) {
        this.players = aplayers;
        this.locations = alocations;

    }

    //starting  the next square for player(change position and balance)
    private void moveToNextSquare(final Player player) {
        player.setPosition(player.getPosition() - locations.size());
        player.setBalance(player.getBalance() + b);
    }

    //player move on the board from 1 - 6, randomly
    public void playerMove(final Player player) {
        player.setPosition(player
                .getPosition() + (int) (Math.random() * s + o));
        //doing this to prevent giving the same number
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // if player moves over locations size then move player to next sqaure
        playerBuyLocation(player);
    }

    private void playerBuyLocation(final Player player) {
        if (player.getPosition() >= locations
                .size())  moveToNextSquare(player);
        /* if player location doesnt have an
        owner then offer the player to buy a location*/
        if (!checkOwner(player) && locations.get(player.getPosition())
                .getValue() != 0) {
            logger.info(player.getName() + " can buy "
                    + locations.get(player.getPosition()).getName()
                    + " for " + locations.get(player.getPosition()).getValue());
        }
    }

    private boolean checkOwner(final Player player) {
        boolean isOwned = false;
        int sum = 0;
        if (locations.get(player.getPosition()).getPlayerOwner() != null
                && !player.equals(locations.get(player.getPosition())
                .getPlayerOwner())
                && locations.get(player.getPosition()).getValue() != 0)  {
            isOwned = true;
            sum = locations.get(player.getPosition())
                    .getValue() / f + locations
                    .get(player.getPosition())
                    .getNumberOfHouses() * fifty; // calculate the required sum
            /*if the player has the required sum
             amount then he pays, else game over)
              */
            if (player.getBalance() > sum) {
                player.setBalance(player.getBalance() - sum);
                locations.get(player.getPosition()).getPlayerOwner()
                        .setBalance(locations.get(player.getPosition())
                                .getPlayerOwner().getBalance() + sum);
            } else
                logger.info(player.getName() + "lost the game!");
        }

        return isOwned;
    }

    public boolean buyLocation(final Player player) {
        boolean isSuccessful = false;
        // if player has money and location it's not a start then buy location
        if (locations.get(player.getPosition()).getValue() < player.getBalance()
                && locations.get(player.getPosition()).getValue() != 0) {
            isSuccessful = true;
            locations.get(player.getPosition()).setPlayerOwner(player);
            player.setBalance(player.getBalance()
                    - locations.get(player.getPosition()).getValue());
        }
        return isSuccessful;
    }
}
