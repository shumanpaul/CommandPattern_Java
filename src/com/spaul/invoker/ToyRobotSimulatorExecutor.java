package com.spaul.invoker;

import com.spaul.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker Class of CommandPattern
 */
public class ToyRobotSimulatorExecutor {

    //Store list of valid commands executed
    private final List<Command> commandList = new ArrayList<>();

    /**
     * Constructor
     */
    public ToyRobotSimulatorExecutor() {
    }

    /**
     * Execute command add to the list of valid commands
     * @param command
     * @return
     */
    public boolean executeCommand(Command command){
        if(command.execute()) {
            commandList.add(command);
            return true;
        }
        return false;
    }
}
