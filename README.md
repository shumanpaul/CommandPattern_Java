#Toy Robot Simulator Problem
Please read the PROBLEM.md for the requirements.

##Implementaion detail

###Design pattern used

- **Singleton** for the Table Top as only one instance should be used.
- **Command Pattern** While researching for a suitable pattern for this problem, I came across this pattern which I never implemented.
- Primarily used for encapsulationg the transition of the robot and so that it can scaled to include a command to reverse the valid commands or a given number of valid commands via a RESET Command.
- Alternative behavioural pattern that could be used was Factory in conjuction with Null.
- Reference websites
https://www.baeldung.com/java-command-pattern
https://dzone.com/articles/design-patterns-command 

**TDD approach involved.**
**IDE IntelliJ IDEA Community** 

###Code Flow
- Read input File and perform any validations
- Parse each line of code and perform the corresponding actions

###Future

- Implement RESET command to reset the robot's position or undo a given number of commands
- Make table top dimension configurable.

##Usage
- java -jar ToyRobotSimulator.jar <file_name>
- e.g. java -jar D:/TextCase12.txt

## Source files descriptions

├───src
│   ├───com
│   │   └───spaul
│   │       │   Constants.java 							:-Static values used across the project. 			
│   │       │   TableTop.java							:-TableTop implementation.Contains dimension of the table top and methods to validate a position 
│   │       │   ToyRobotSimulator.java					:- Client Class of Command Pattern + Main Program
│   │       │
│   │       ├───command
│   │       │       Command.java 						:-Interface for COmmand CLasses of Command Pattern
│   │       │       LeftCommand.java					:-Implementation for Left Command 
│   │       │       MoveCommand.java					:-Implementation for Move Command
│   │       │       PlaceCommand.java					:-Implementation for Place Command
│   │       │       ReportCommand.java					:-Implementation for Report Command
│   │       │       RightCommand.java					:-Implementation for Right Command
│   │       │
│   │       ├───invoker
│   │       │       ToyRobotSimulatorExecutor.java		:- Invoker Class of CommandPattern
│   │       │
│   │       └───receiver
│   │               Facing.java							:- ENUM CLass for Direction
│   │               ToyRobot.java						:- Receiver class of Command Pattern. Also instance of the Toy Robot used in the Table Top
│   │
│   └───META-INF
│           MANIFEST.MF
│
├───test												:- Test data for TDD
│   └───com
│       └───spaul
│               Test10_ToyRobotSimulator_MultipleWrongCommands.java
│               Test11_ToyRobotSimulator_ValidScenarioB.java
│               Test12_ToyRobotSimulator_BoundaryNorth.java
│               Test13_ToyRobotSimulator_BoundaryEAST.java
│               Test14_ToyRobotSimulator_BoundarySOUTH.java
│               Test15_ToyRobotSimulator_BoundaryWEST.java
│               Test16_ToyRobotSimulator_ValidScenarioC.java
│               Test1_ToyRobotSimulator_NoArguments.java
│               Test2_ToyRobotSimulator_TooManyArguments.java
│               Test3_ToyRobotSimulator_InvalidArgument.java
│               Test4_ToyRobotSimulator_EmptyCommandFile.java
│               Test5_ToyRobotSimulator_NoPlaceCommand.java
│               Test6_ToyRobotSimulator_WrongFormatPlaceCommand.java
│               Test7_ToyRobotSimulator_PlaceCommandNotFirstCommand.java
│               Test8_ToyRobotSimulator_ValidScenarioA.java
│               Test9_ToyRobotSimulator_WrongPlaceCommand.java
│               ToyRobotSimulatorTest.java
│
└───testResources
        Test04_EmptyCommandFile.txt
        Test05_NoPlaceCommand.txt
        Test06_WrongFormatPlaceCommand.txt
        Test07_PlaceCommandNotFirstCommand.txt
        Test08_ValidScenarioA.txt
        Test09_WrongPlaceCommand.txt
        Test10_MultipleWrongCommands.txt
        Test11_ValidScenarioB.txt
        Test12_BoundaryNorth.txt
        Test13_BoundaryEAST.txt
        Test14_BoundarySOUTH.txt
        Test15_BoundaryWEST.txt
        Test16_ValidScenarioC.txt


