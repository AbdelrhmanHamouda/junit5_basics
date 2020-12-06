package com.nexthink.mnt;


import com.nexthink.mnt.math.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestsDemo {

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "xzc"})
        // Pass values to testcase in order to run it many times
    void testCase1(String arg) {
        assertTrue(!arg.isEmpty());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
        // Pass values to testcase in order to run it many times
    void testCase2(int arg) {
        assertTrue(arg > 1, "The value of " + arg + " is lower than 1");
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "4,5,9",
            "6,7,13",
    })
        // Pass values to testcase in order to run it many times
    void testCase3(int number1, int number2, int expectedResult) {
        // * Setup
        Calculator calculator = new Calculator();

        // * Act
        int actualSum = calculator.add(number1, number2);

        // * Assert
        assertEquals(expectedResult, actualSum);
    }
}
