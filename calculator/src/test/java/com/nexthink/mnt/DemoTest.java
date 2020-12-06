package com.nexthink.mnt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoTest {

    @BeforeEach
    void setUp() {
        System.out.println("I am running before the Test!");
    }

    @AfterEach
    void tearDown() {
        System.out.println("I am running after the Test!");
    }

    @Test
    void howToProtectFromCOVID() {
        // * Setup
        String expected = "Stay home & stay safe!";
        Demo demo = new Demo();

        // * Act
        String actual = demo.howToProtectFromCOVID();

        // * Assert
        assertEquals(expected, actual);

    }

    @Test
    void howToProtectFromCOVID_setToFail() {
        // * Setup
        String expected = "Go out & stay safe!";
        Demo demo = new Demo();

        // * Act
        String actual = demo.howToProtectFromCOVID();

        // * Assert
        assertEquals(expected, actual, "The values are not the same!");

    }

    @Test
    void currentlyInfectedPeople() {
        // * setup
        Demo demo = new Demo();
        int expected = 13100;

        // * Act
        int actual = demo.currentlyInfectedPeople(100);

        // * Assert
        assertEquals(expected, actual);
    }
}