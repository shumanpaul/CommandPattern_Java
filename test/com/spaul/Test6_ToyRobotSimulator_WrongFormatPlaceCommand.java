package com.spaul;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Test6_ToyRobotSimulator_WrongFormatPlaceCommand {
    private static final String EOL =
            System.getProperty("line.separator");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        String[] args = {"testResources/Test06_WrongFormatPlaceCommand.txt"};
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            ToyRobotSimulator.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setOut(console);
        }
        assertEquals(String.format(""),
                bytes.toString());
    }
}