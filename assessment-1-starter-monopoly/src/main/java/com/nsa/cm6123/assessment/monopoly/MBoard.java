package com.nsa.cm6123.assessment.monopoly;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public abstract class MBoard {
    private static final long EXPECTED_BALANCE = 200;
    private static Logger logger = null;
    private static final int SIXTY = 60;
    private static final int THIRTY = 30;
    private static final int TWOHUNDRED = 200;
    private static final int HUNDRED = 100;
    private static final int FIFTY = 50;
    private static final int ONETWENTY = 120;
    private static final int ONEFORTY = 140;
    private static final int SEVENTY = 70;
    private static final int ONESIXTY = 160;
    private static final int EIGHTY = 80;
    private static final int TWOSIXTY = 260;
    private static final int ONETEN = 110;
    private static final int TWOTWENTY = 220;
    private static final int TWOFORTY = 240;
    private static final int FOURHUNDRED = 400;
    private static final int ONESEVENTYFIVE = 175;
    private static final int THREEFIFTY = 350;
    private static final int THREETWENTY = 320;
    private static final int ONEIGHTY = 180;
    private static final int NINETY = 90;
    private static final int ONETHIRTY = 130;
    private static final int TWOEIGHTY = 280;
    private static final int THREEHUNDRED = 300;
    private static final int ONEFIFTY = 150;



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
    public static void main(final String[] args) {
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Go!", 0, 0));
        locations.add(new Location("Old Kent Road", SIXTY, THIRTY));
        locations.add(new Location("Whitechapel Road", SIXTY, THIRTY));
        locations.add(new Location("Kings Cross Station", TWOHUNDRED, 0));
        logger.info("number of locations " + locations.size());

        locations.add(new Location("The Angel Islington", HUNDRED, FIFTY));
        locations.add(new Location("Euston Road", HUNDRED, FIFTY));
        locations.add(new Location("Pentonville Road", ONETWENTY, SIXTY));
        locations.add(new Location("Pall Mall", ONEFORTY, SEVENTY));

        locations.add(new Location("WhiteMall ", ONEFORTY, SEVENTY));
        locations.add(new Location("Northumberland Avenue", ONESIXTY, EIGHTY));
        locations.add(new Location("Marylebone station", TWOHUNDRED, 0));
        locations.add(new Location("Bow Street", ONEIGHTY, NINETY));

        locations.add(new Location("Marlborough Street", ONEIGHTY, THIRTY));
        locations.add(new Location("Vine Street", TWOHUNDRED, ONETEN));
        locations.add(new Location("Strand", TWOTWENTY, ONETEN));
        locations.add(new Location("Fleet Street", TWOTWENTY, ONETEN));

        locations.add(new Location("Trafalgar Square", TWOFORTY, ONETWENTY));
        locations.add(new Location("Fenchurch Street station", TWOHUNDRED, 0));
        locations.add(new Location("Leicester Square", TWOSIXTY, ONETHIRTY));
        locations.add(new Location("Coventry Street", TWOSIXTY, ONETHIRTY));

        locations.add(new Location("Piccadilly", TWOEIGHTY, ONEFORTY));
        locations.add(new Location("Regent Street", THREEHUNDRED, ONEFIFTY));
        locations.add(new Location("Oxford Street", THREEHUNDRED, ONEFIFTY));
        locations.add(new Location("Bond Street", THREETWENTY, ONESIXTY));

        locations.add(new Location("Liverpool Street station", TWOHUNDRED, 0));
        locations.add(new Location("Park Lane", THREEFIFTY, ONESEVENTYFIVE));
        locations.add(new Location("Mayfair", FOURHUNDRED, TWOHUNDRED));

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Hannah", EXPECTED_BALANCE));
        players.add(new Player("Abigail", EXPECTED_BALANCE));
        logger.info("number of players " + players.size()); //no. of players

        Board board = new Board(players, locations);
        logger.info("number of locations " + locations.size());
        //move test
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board
        board.playerMove(players.get(0)); //Hannah moving on the board
        board.playerMove(players.get(1)); //Abigail moving on the board

        //by location test
        logger.info("Hannah's balance is " + players.get(0).getBalance());
        logger.info("Abigail's balance is " + players.get(1).getBalance());

        logger.info("Hannah buy location " + board.buyLocation(players
                .get(0)) + " for " + locations
                .get(players.get(0).getPosition()).getName());
        logger.info("Abigail buy location " + board.buyLocation(players
                .get(1)) + " for " + locations
                .get(players.get(1).getPosition()).getName());

        logger.info("New Balance");

        logger.info("Hannah's balance is " + players.get(0).getBalance());
        logger.info("Abigail's balance is " + players.get(1).getBalance());

        logger.info("Hannah's locations");
        showOwnerLocations(locations, players.get(0));

        logger.info("Abigail's's locations");
        showOwnerLocations(locations, players.get(1));

        logger.info("---------------------------------------------");
        logger.info("Test moves on owned location");
        hannahByAllLocations(locations, players);

        logger.info("Hannah owns all locations");
        logger.info("---------------------------------------------");

        logger.info("Hannah balance is " + players.get(0).getBalance());
        logger.info("Abigail balance is " + players.get(1).getBalance());
        logger.info("Abigail moves");
        board.playerMove(players.get(1));
        logger.info("Abigail balance is " + players.get(1).getBalance());
        logger.info("Abigail moves on " + locations.get(players.get(1)
                .getPosition()).toString());
        logger.info("Hannah moves on " + locations.get(players.get(0)
                .getPosition()).toString());

    }

    private static void hannahByAllLocations(
            final ArrayList<Location> locations,
                                             final ArrayList<Player> players) {
        for (Location location : locations) {
            if (location.getValue() != 0) location
                    .setPlayerOwner(players.get(0));
        }
    }

    private static void showOwnerLocations(
            final ArrayList<Location> locations, final Player player) {
        for (Location location : locations) {
            if (location.getPlayerOwner() != null //
                    && location.getPlayerOwner().equals(player))
                System.out.print(location.getName() + " ");
        }
    }
}

