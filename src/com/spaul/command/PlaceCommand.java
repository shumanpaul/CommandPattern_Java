package com.spaul.command;

import com.spaul.TableTop;
import com.spaul.receiver.Facing;
import com.spaul.receiver.ToyRobot;

/**
 * PLACE Command implementation of Command Pattern
 * - PLACE will put the toy robot on the table in position X,Y and facing NORTH,
 *   SOUTH, EAST or WEST.
 */

public class PlaceCommand implements Command{

    /**
     * Reference to the ToyRobot instance
     */
    ToyRobot robot;

    /**
     * X coordinates
     */
    public int X;

    /**
     * Y coordinates
     */
    private int Y;

    /**
     * Direction
     */
    private Facing direction; //Robot's direction

    /**
     * Constructor
     * @param robot
     */
    public PlaceCommand(ToyRobot robot) {
        this.robot = robot;
    }

    /**
     *  Change Direction as per current direction
     * @return
     */
    @Override
    public void setCoordinates(int x, int y, Facing direction)
    {
        this.X = x;
        this.Y = y;
        this.direction = direction;
    }

    /**
     *  Check position validity before placing the robot on the table top
     * @return
     */
    @Override
    public boolean execute() {
        TableTop tableTop = TableTop.getInstance();// Get singleton instance
        if(tableTop.isPositionValid(X,Y)) {
            this.robot.setCoordinates(X,Y,direction);
            return true;
        }
        return false;
    }


}
