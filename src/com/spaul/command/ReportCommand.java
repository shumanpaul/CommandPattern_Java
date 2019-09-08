package com.spaul.command;

import com.spaul.receiver.Facing;
import com.spaul.receiver.ToyRobot;

/**
 * REPORT Command implementation of Command Pattern
 *- REPORT will announce the X,Y and F of the robot.
 */
public class ReportCommand implements Command {

    /**
     * Reference to the ToyRobot instance
     */
    ToyRobot robot;

    /**
     * Constructor
     * @param robot
     */
    public ReportCommand(ToyRobot robot) {
        this.robot = robot;
    }

    /**
     *  Print Report
     * @return
     */
    @Override
    public boolean execute() {
        System.out.println(robot.getX() + "," + robot.getY() + "," + robot.getDirection());
        return true;
    }

    @Override
    public void setCoordinates(int x, int y, Facing direction) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
}
