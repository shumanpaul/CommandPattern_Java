package com.spaul.command;

import com.spaul.receiver.Facing;

/**
 * Command Interface of Command Pattern
 */
public interface Command {
    /**
     * Execute method
     * @return
     */
    public boolean execute();

    /**
     * Set the coordinates which is only being used by PLACE Command Implementation
     * @param x
     * @param y
     * @param direction
     */
    public void setCoordinates(int x, int y, Facing direction);
}
