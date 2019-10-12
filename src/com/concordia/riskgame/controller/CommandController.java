package com.concordia.riskgame.controller;

import com.concordia.riskgame.model.Modules.Gameplay;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to parse the commands entered by user and perform actions based on commands
 */
public class CommandController {

    public static String commandType; // command type
    public static HashMap<String, Integer> addContinent = new HashMap<>();
    public static ArrayList<String> removeContinent = new ArrayList<>();
    public static HashMap<String, String> addCountry = new HashMap<>();
    public static ArrayList<String> removeCountry = new ArrayList<>();
    public static HashMap<String, String> addNeighbour = new HashMap<>();
    public static HashMap<String, String> removeNeighbour = new HashMap<>();
    public static ArrayList<String> addPlayer = new ArrayList<>();
    public static ArrayList<String> removePlayer = new ArrayList<>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    /**
     * This method takes command as input and calls respective methods corresponding to the command and executes the method.
     *
     * @param command takes command input from user
     */
    public static void parseCommand(String command) {
        command = command.trim().replaceAll(" +", " "); //replace multiple whitespaces with one.
        commandType = command.split(" ")[0];

        switch (commandType) {
            case "editcontinent":
                editContinent(command);
                break;
            case "editcountry":
                editCountry(command);
                break;
            case "editneighbor":
                editNeighbour(command);
                break;
            case "showmap":
                showMap();
                break;
            case "savemap":
                saveMap(command);
                break;
            case "editmap":
                editMap(command);
                break;
            case "vaildatemap":
                validateMap();
                break;
            case "loadmap":
                loadMap(command);
                break;
            case "gameplayer":
                gamePlayer(command);
                break;
            case "populatecountries":
                populateCountries();
                break;
            case "placearmy":
                placeArmy(command);
                break;
            case "placeall":
                placeAll();
                break;
            case "reinforce":
                reinforce(command);
                break;
            case "fortify":
                System.out.println("Yet to configure");
                break;
            case "help":
                showHelpOptions();
                break;
            default:
                invalidCommandMessage();
                break;
        }
    }


    /**
     * @param val Takes a string input
     * @return return true if the string has only characters a-z, else return false.
     */
    public static boolean verifyAllCharacters(String val) {
        return val.matches("^[a-zA-Z]*$");
    }

    public static boolean verifyNumber(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void invalidCommandMessage() {
        System.out.println(ANSI_RED + "INVALID COMMAND !!, Check the command format below. ");
        showHelpOptions();
        System.out.println(ANSI_RESET);
    }


    /**
     * This method performs add continent and remove continent actions based on the valid command.
     *
     * @param command Command to execute
     */
    public static void editContinent(String command) {
        if (validateEditContinentCommand(command)) {
            for (String Key : addContinent.keySet()) {
                //Add continent functiono call.
            }
            for (String val : removeContinent) {
                //Remove continent function call.
            }
        } else {
            invalidCommandMessage();
        }
    }

    /**
     * This method reads editcontinent command, validates the command and add continent to add or remove to list.
     *
     * @param command Command to validate
     * @return True if the command is valid, else false.
     */
    public static boolean validateEditContinentCommand(String command) {

        addContinent.clear();
        removeContinent.clear();

        String[] args = command.split(" ");
        String arg_type;
        String value1;
        String value2;
        for (int i = 1; i < args.length; i += 2) {
            arg_type = args[i];
            if (arg_type.trim().equals("-add")) {
                value1 = args[i + 1];
                value2 = args[i + 2];
                if (verifyAllCharacters(value1) && verifyNumber(value2)) {
                    addContinent.put(value1, Integer.parseInt(value2));
                }
                i += 1;
            } else if (arg_type.trim().equals("-remove")) {
                value1 = args[i + 1];
                if (verifyAllCharacters(value1)) {
                    removeContinent.add(value1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This method takes editcountry command as input and perform actions as per command.
     *
     * @param command command to execute
     */
    public static void editCountry(String command) {
        if (validateEditCountryCommand(command)) {
            for (String countryName : addCountry.keySet()) {
                //add country code
            }
            for (String countryName : removeCountry) {
                // remove country code
            }
        } else {
            invalidCommandMessage();
        }
    }

    /**
     * This method reads editcountry command, validates the command and add country to add or remove to list.
     *
     * @param command Command to validate
     * @return True if the command is valid, else false.
     */
    public static boolean validateEditCountryCommand(String command) {
        addContinent.clear();
        removeCountry.clear();

        String[] args = command.split(" ");
        String arg_type;
        String value1;
        String value2;
        for (int i = 1; i < args.length; i += 2) {
            arg_type = args[i];
            if (arg_type.trim().equals("-add")) {
                value1 = args[i + 1];
                value2 = args[i + 2];
                if (verifyAllCharacters(value1) && verifyAllCharacters(value2)) {
                    addCountry.put(value1, value2);
                }
                i += 1;
            } else if (arg_type.trim().equals("-remove")) {
                value1 = args[i + 1];
                if (verifyAllCharacters(value1)) {
                    removeCountry.add(value1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * This method takes editneighbour command as input and perform actions as per command.
     *
     * @param command command to execute
     */
    public static void editNeighbour(String command) {
        if (validateEditNeighbourCommand(command)) {
            for (String countryName : addNeighbour.keySet()) {
                String neighbourName = addNeighbour.get(countryName);
                //add country code
            }
            for (String countryName : removeNeighbour.keySet()) {
                String neighbourName = addNeighbour.get(countryName);
                // remove country code
            }
        } else {
            invalidCommandMessage();
        }
    }


    /**
     * This method reads editneighbour command, validates the command and add neighbour to add or remove to list.
     *
     * @param command Command to validate
     * @return True if the command is valid, else false.
     */
    public static boolean validateEditNeighbourCommand(String command) {
        addNeighbour.clear();
        removeNeighbour.clear();

        String[] args = command.split(" ");
        String arg_type;
        String value1;
        String value2;
        for (int i = 1; i < args.length; i += 3) {
            arg_type = args[i];
            value1 = args[i + 1];
            value2 = args[i + 2];
            if (verifyAllCharacters(value1) && verifyAllCharacters(value2)) {
                if (arg_type.trim().equals("-add")) {
                    addNeighbour.put(value1, value2);
                } else if (arg_type.trim().equals("-remove")) {
                    removeNeighbour.put(value1, value2);
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * This method reads gameplayer command, validates the command and add or remove player.
     *
     * @param command Command to validate
     * @return True if the command is valid, else false.
     */
    public static void gamePlayer(String command) {
        if (validateGamePlayerCommand(command)) {
            for (String playerName : addPlayer) {
                System.out.println(Gameplay.getInstance().addPlayer(playerName));
            }
            for (String playerName : removePlayer) {
                Gameplay.getInstance().removePlayer(playerName);
            }
        } else {
            invalidCommandMessage();
        }
    }


    /**
     * This method reads gamplayer command, validates the command and add player to add or remove to list.
     *
     * @param command Command to validate
     * @return True if the command is valid, else false.
     */
    public static boolean validateGamePlayerCommand(String command) {
        addPlayer.clear();
        removePlayer.clear();

        String[] args = command.split(" ");
        String arg_type;
        String value1;
        for (int i = 1; i < args.length; i += 2) {
            arg_type = args[i];
            value1 = args[i + 1];

            if (arg_type.trim().equals("-add")) {
                if (verifyAllCharacters(value1)) {
                    addPlayer.add(value1);
                }
            } else if (arg_type.trim().equals("-remove")) {
                if (verifyAllCharacters(value1)) {
                    removePlayer.add(value1);
                }
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * This method validates if the map loaded is
     */
    public static void validateMap() {

    }

    /**
     * Method to display map to the players.
     */
    public static void showMap() {

    }


    public static void saveMap(String command)
    {
        String fileName = command.split(" ")[1];
    }


    public static void editMap(String command)
    {
        String fileName = command.split(" ")[1];
    }


    /**
     * This method will load the map from the file specified by user in the command.
     *
     * @param command loadmap command as input
     */
    public static void loadMap(String command)
    {
        String fileName = command.split(" ")[1];
    }

    /**
     * Method to populate countries and assign country to players.
     */
    public static void populateCountries()
    {

    }

    public static void placeArmy(String command)
    {
        String countryName = command.split(" ")[1];

    }


    public static void placeAll()
    {

    }


    public static void reinforce(String command)
    {
        String countryName = command.split(" ")[1];
        String num = command.split(" ")[2];

        //Execute method
    }


    public static void fortify(String command)
    {

    }

    /**
     * Method to print help options for commands
     */
    public static void showHelpOptions()
    {
        System.out.println("For getting help menu, type help.\n");
        System.out.format("%-20s%-50s%-50s\n","editcontinent", "[-add] <continentname> <continentvalue>", " command to add continent to a map." );
        System.out.format("%-20s%-50s%-50s\n","editcontinent", "[-remove] <continentname> ", " command to remove continent from a map." );
        System.out.format("%-20s%-50s%-50s\n", "editcountry", "[-add] <countryname> <continentname>", " command to add country to a map.");
        System.out.format("%-20s%-50s%-50s\n", "editcountry", "[-remove] <countryname> ", " command to remove country from a map.");
        System.out.format("%-20s%-50s%-50s\n", "editneighbour", "[-add] <countryname> <neighbourcountryname>", " command to add neighbour country to a map.");
        System.out.format("%-20s%-50s%-50s\n", "editneighbour", "[-remove] <countryname> ", " command to remove neighbour country from a map.");
        System.out.format("%-20s%-50s%-50s\n", "showmap", " ", " command to display map.");
        System.out.format("%-20s%-50s%-50s\n", "savemap", "<filename>", " command to save map.");
        System.out.format("%-20s%-50s%-50s\n", "editmap", "<filename> ", " command to load and edit map.");
        System.out.format("%-20s%-50s%-50s\n", "validatemap", " ", " command to validate loaded map.");
        System.out.format("%-20s%-50s%-50s\n", "loadmap", "<filename> ", " command to load map.");
        System.out.format("%-20s%-50s%-50s\n", "gameplayer", "[-add] <playername> ", " command to add player to game.");
        System.out.format("%-20s%-50s%-50s\n", "gameplayer", "[-remove] <playername> ", " command to remove player from game.");
        System.out.format("%-20s%-50s%-50s\n", "populatecountries", " ", " command initialize game and assign country to players.");
        System.out.format("%-20s%-50s%-50s\n", "placearmy", "<countryname> ", " command to place army for a player in a country.");
        System.out.format("%-20s%-50s%-50s\n", "placeall", " ", " automatically randomly place all remaining unplaced armies for all players.");
        System.out.format("%-20s%-50s%-50s\n", "reinforce", "<countryname> <num> ", " until all reinforcements have been placed.");
        System.out.format("%-20s%-50s%-50s\n", "fortify", "<fromcountry> <tocountry> <num> ", " command to Fortify country");
        System.out.format("%-20s%-50s%-50s\n", "fortify", "none ", " commad to choose to not do a move");

    }
}




