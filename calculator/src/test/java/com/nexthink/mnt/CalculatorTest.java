package com.nexthink.mnt;

import com.nexthink.mnt.math.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * @author - Abdelrhman Hamouda
 */
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Add 2 positive numbers")
    void addTestCase1() {
        // * Setup
        int n1 = 10;
        int n2 = 20;
        int expectedResult = 30;

        // * Act
        int actualResult = calculator.add(n1, n2);

        // * Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Add 2 negative numbers")
    void addTestCase2() {
        // * Setup
        int n1 = -10;
        int n2 = -20;
        int expectedResult = -30;

        // * Act
        int actualResult = calculator.add(n1, n2);

        // * Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
