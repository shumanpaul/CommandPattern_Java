package com.spaul.receiver;

/**
 * Receiver class of Command Pattern
 * Also instance of the Toy Robot used in the Table Top
 */
public class ToyRobot {

    /**
     * Robot's X coordinates
     */
    private int X;

    /**
     * Robot's Y coordinates
     */
    private int Y;

    /**
     * Robot's direction
     */
    private Facing direction; //Robot's direction

    private boolean placed;

    /**
     * Constructor
     * @param x
     * @param y
     * @param direction
     * @param placed
     */
    public ToyRobot() {
        placed = false;
        X = 0;
        Y = 0;
        direction = Facing.NORTH;
    }

    /**
     * Constructor
     * @param x
     * @param y
     * @param direction
     * @param placed
     */
    public ToyRobot(int x, int y, Facing direction, boolean placed) {
        X = x;
        Y = y;
        this.direction = direction;
        this.placed = placed;
    }

    /**
     * Set Coordinates
     * @param x
     * @param y
     * @param direction
     */
    public void setCoordinates(int x, int y, Facing direction) {
        X = x;
        Y = y;
        this.direction = direction;
    }

    //region Getter and Setter Methods
    /**
     * Getter of X
     * @return
     */
    public int getX() {
        return X;
    }

    /**
     * Getter of Y
     * @return
     */
    public int getY() {
        return Y;
    }

    /**
     * Getter of direction
     * @return
     */
    public Facing getDirection() {
        return direction;
    }

    /**
     * Getter of placed
     * @return
     */
    public boolean isPlaced() {
        return placed;
    }

    /**
     * Setter of X
     * @param x
     */
    public void setX(int x) {
        X = x;
    }

    /**
     * Setter of Y
     * @param y
     */
    public void setY(int y) {
        Y = y;
    }

    /**
     * Setter of direction
     * @param direction
     */
    public void setDirection(Facing direction) {
        this.direction = direction;
    }

    /**
     * Setter of placed
     */
    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
    //endregion
}
