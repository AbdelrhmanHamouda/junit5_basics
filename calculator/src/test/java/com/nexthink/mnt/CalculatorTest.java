package com.nexthink.mnt;

import com.nexthink.mnt.math.Calculator;
import com.nexthink.mnt.math.TooLargeNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Test for a negative number exceptions")
    void addTestCase3() {

        // * Setup
        int n1 = -101;
        int n2 = -200;
        String expectedMessage = "Numbers less than 100 are not allowed";

        // * Act
        // Here we are capturing the exception by first passing the expected exception to get
        // and then we pass the function/method that is expected to cause the exception.
        RuntimeException exception = assertThrows(RuntimeException.class, () -> calculator.add(n1, n2));

        // * Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    @DisplayName("Test for numbers bigger than 50000")
    void addTestCase4() {

        // * Setup
        int number1 = 500001;
        int number2 = 100;
        String expectedMessage = "Negative Numbers not allowed";

        // * Act
        TooLargeNumbers exception = assertThrows(TooLargeNumbers.class, () -> calculator.add(number1, number2));

        // * Assert
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    @DisplayName("Test asserts with timeOut for the whole test")
    // Set a timeout for the test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void addTestCase5() {

        // * Setup
        int number1 = 41000;
        int number2 = 41000;
        int expectedSum = 82000;

        // * Act
        int actualSum = calculator.add(number1, number2);
        // * Assert
        assertEquals(expectedSum, actualSum);

    }

    @Test
    @DisplayName("Test asserts with timeOut")
        // This test is failing in order to see the difference message
    void addTestCase6() {

        // * Setup
        int number1 = 41000;
        int number2 = 41000;
        int expectedSum = 82000;

        // * Act
        // The assertTimeout takes the "duration" as first parameter and "lambda" for the second parameter.
        int actualSum = assertTimeout(Duration.ofSeconds(1), () -> calculator.add(number1, number2));
        // * Assert
        assertEquals(expectedSum, actualSum);

    }
}
