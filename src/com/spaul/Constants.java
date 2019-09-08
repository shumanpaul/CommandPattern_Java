package com.spaul;

/**
 * Constants used in the project
 */
public class Constants {

    //Error message constants
    public static final String USAGE = "Usage:java -jar ToyRobotSimulator.jar <file_name>";
    public static final String MSG_UNACCEPTED_NUMBER_ARGUMENTS  = "Unaccepted number of arguments !";
    public static final String MSG_INPUT_FILE_NOT_FOUND  = "The input file was not found: ";
    public static final String MSG_INPUT_FILE_EMPTY = "The input file is empty: ";

    //Valid Command constants
    public static final String COMMAND_PLACE = "PLACE";
    public static final String COMMAND_MOVE = "MOVE";
    public static final String COMMAND_LEFT = "LEFT";
    public static final String COMMAND_RIGHT = "RIGHT";
    public static final String COMMAND_REPORT = "REPORT";

    //End of Line Seperator
    private static final String EOL = System.getProperty("line.separator");
}