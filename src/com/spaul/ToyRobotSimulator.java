package com.spaul;

import com.spaul.command.*;
import com.spaul.invoker.ToyRobotSimulatorExecutor;
import com.spaul.receiver.Facing;
import com.spaul.receiver.ToyRobot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.spaul.Constants.*;

/**
 * Client Class of Command Pattern
 */
public class ToyRobotSimulator {


    public static void main(String... args) throws IOException {
	    // Check number of Arguments as input is from a file
        if (args.length == 1)
        {
            File file = new File(args[0]);// Open input file.

                if (file.exists()) {// Check if the input file exists.
                    if (file.length() == 0) {// Check if Input file is empty ?
                        System.out.println(MSG_INPUT_FILE_EMPTY + args[0]);
                        return;
                    } else {
                        ParseFile(file);//Parse and execute valid commands from the input file
                    }
                }
                else{
                    System.out.println(MSG_INPUT_FILE_NOT_FOUND + args[0]);
                }

        }
        else  { //Unexpected number of arguments.
            System.out.println(MSG_UNACCEPTED_NUMBER_ARGUMENTS);
            System.out.println(USAGE);
        }
    }

    public void InvalidCommand(String command)
    {
        System.out.println("Ignored invalid command:-" + command);
    }

    /***
     * ParseFile module to parse and execute the commands in the input file.
     * @param file
     */
    public static void ParseFile(File file) {
        //Input File not empty hence read
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String command; //Variable to store command

            ToyRobotSimulatorExecutor simulator = new ToyRobotSimulatorExecutor();//Invoker instance of Command Pattern
            ToyRobot robot = new ToyRobot();//Receiver instance of Command Pattern
            //Command class instances of Command Pattern
            Command placeCommand = new PlaceCommand(robot);
            Command moveCommand = new MoveCommand(robot);
            Command leftCommand = new LeftCommand(robot);
            Command rightCommand = new RightCommand(robot);
            Command reportCommand = new ReportCommand(robot);

            //Read file line by line and process each command
            while ((command = br.readLine()) != null) {
                command = command.trim();//Remove starting and trailing spaces

                //Parse and execute command
                // 1. In-case command is PLACE then parse it to execute command
                if (command.toUpperCase().startsWith(COMMAND_PLACE)) {
                    //Split Command "PLACE X,Y,Direction"
                    try {
                        String[] placeString = command.split(" ");//Correct command will split it into PLACE AND X,Y,DIRECTION
                        if (placeString[1] != null)//String that should contain coordinates X,Y,DIRECTION
                        {
                            String[] coordinateString = placeString[1].split(",");//Array will contain X Y and Direction as values
                            if (coordinateString[0] != null && coordinateString[1] != null && coordinateString[2] != null) {
                                placeCommand.setCoordinates(Integer.valueOf(coordinateString[0]), Integer.valueOf(coordinateString[1]), Facing.valueOf(coordinateString[2]));
                                if (simulator.executeCommand(placeCommand)) {//Execute PLACE Command and if valid set robot as placed on table top.
                                    robot.setPlaced(true);
                                }
                            }//else not required as it will continue to read next command
                        }//else not required as it will continue to read next command
                    } catch (Exception e) {
                        //Any exception is due to a faulty command hence ignore it.
                        //Future log it into a file
                        //e.printStackTrace();
                        continue;
                    }
                }
                // 2. Not a PLACE command hence execute the other commands
                // only if an earlier PLACE command has been successfully executed
                else if (robot.isPlaced()) {
                    try {
                        switch (command) {
                            case COMMAND_MOVE:
                                simulator.executeCommand(moveCommand);
                                break;
                            case COMMAND_LEFT:
                                simulator.executeCommand(leftCommand);
                                break;
                            case COMMAND_RIGHT:
                                simulator.executeCommand(rightCommand);
                                break;
                            case COMMAND_REPORT:
                                simulator.executeCommand(reportCommand);
                                break;
                        }
                    } catch (Exception e) {
                        //Any exception is due to a faulty command hence ignore it.
                        //e.printStackTrace();
                        continue;
                    }
                }
                                /* Not required as requirement clearly states
                                 "The application should discard all commands in the sequence until a valid PLACE command has been executed."
                                //3. Case when no valid PLACE command has been executed and REPORT needs to be executed
                                else if(command.equals("REPORT"))
                                {
                                    System.out.println("The Robot is not placed");
                                }*/
            }// End of while loop
            br.close();//Close the reader
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
