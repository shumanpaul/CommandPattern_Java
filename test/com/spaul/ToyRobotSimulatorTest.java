package com.spaul;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ToyRobotSimulatorTest {
    private static final String EOL =
            System.getProperty("line.separator");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testArguments() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            ToyRobotSimulator.main();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setOut(console);
        }
        assertEquals(String.format(
                ToyRobotSimulator.MSG_UNACCEPTED_NUMBER_ARGUMENTS + EOL +
                        ToyRobotSimulator.USAGE + EOL),
                bytes.toString());
    }
}