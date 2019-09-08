package com.spaul.command;

import com.spaul.TableTop;
import com.spaul.receiver.Facing;
import com.spaul.receiver.ToyRobot;

/**
 * - MOVE will move the toy robot one unit forward in the direction it is
 *   currently facing.
 */
public class MoveCommand implements Command {

    /**
     * Reference to the ToyRobot instance
     */
    ToyRobot robot;

    /**
     * Constructor
     * @param robot
     */
    public MoveCommand(ToyRobot robot) {
        this.robot = robot;
    }

    /**
     * - MOVE will move the toy robot one unit forward in the direction it is
     *   currently facing if the new postion is valid.
     * @return
     */
    @Override
    public boolean execute() {
        TableTop tableTop = TableTop.getInstance();// Get singleton instance
        switch(robot.getDirection()) {
            case NORTH:
                if (tableTop.isPositionValid(robot.getX(), robot.getY() + 1)) {// Set new position only if it is valid
                    this.robot.setY(robot.getY() + 1);
                    return true;
                }
                break;
            case SOUTH:
                if (tableTop.isPositionValid(robot.getX(), robot.getY() - 1)) {// Set new position only if it is valid
                    this.robot.setY(robot.getY() - 1);
                    return true;
                }
                break;
            case EAST:
                if (tableTop.isPositionValid(robot.getX() + 1, robot.getY())) {// Set new position only if it is valid
                    this.robot.setX(robot.getX() + 1);
                    return true;
                }
                break;
            case WEST:
                if (tableTop.isPositionValid(robot.getX() - 1, robot.getY())) {// Set new position only if it is valid
                    this.robot.setX(robot.getX() - 1);
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public void setCoordinates(int x, int y, Facing direction) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }


}
