package com.spaul.command;

import com.spaul.receiver.Facing;
import com.spaul.receiver.ToyRobot;

/**
 * Right Command implementation of Command Pattern
 * - RIGHT will rotate the robot 90 degrees to the RIGHT
 *   without changing the position of the robot.
 */
public class RightCommand implements Command {

    /**
     * Reference to the ToyRobot instance
     */
    ToyRobot robot;

    /**
     * Constructor
     * @param robot
     */
    public RightCommand(ToyRobot robot) {
        this.robot = robot;
    }

    /**
     *  Change Direction as per current direction
     * @return
     */
    @Override
    public boolean execute() {
        switch(robot.getDirection())
        {
            case NORTH:
                this.robot.setDirection(Facing.EAST);
                return true;
            case WEST:
                this.robot.setDirection(Facing.NORTH);
                return true;
            case SOUTH:
                this.robot.setDirection(Facing.WEST);
                return true;
            case EAST:
                this.robot.setDirection(Facing.SOUTH);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void setCoordinates(int x, int y, Facing direction) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
}
