package com.spaul;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static com.spaul.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Test4_ToyRobotSimulator_EmptyCommandFile {
    private static final String EOL =
            System.getProperty("line.separator");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEmptyCommandFile() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        String[] args = {"testResources/Test04_EmptyCommandFile.txt"};
        PrintStream console = System.out;
        try {
            System.setOut(new PrintStream(bytes));
            ToyRobotSimulator.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.setOut(console);
        }
        assertEquals(String.format(MSG_INPUT_FILE_EMPTY + args[0] + EOL),
                bytes.toString());
    }
}