package com.nexthink.mnt;

import com.nexthink.mnt.math.Calculator;
import com.nexthink.mnt.math.TooLargeNumbers;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @author - Abdelrhman Hamouda
 */
@Tag("CalcTests")
public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Nested
    @DisplayName("All testcases expected to pass under one group")
    class PassingCases {
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
        @DisplayName("Assertion library demo!")
            // A simple showcase of some assertion library methods.
        void addTestCase7() {

            assertTrue("str".equals("str"));
            assertFalse(false);

            String strNull = null;
            assertNull(strNull);

            String strNotNull = "something";
            assertNotNull(strNotNull);

            assertNotEquals(22, 23);

        }

        @Test
        @DisplayName("assertAll() showcase")
        void addTestCase8() {

            int case1Number1 = 1;
            int case1Number2 = 2;
            int case1expected = 3;

            int case2Number1 = 3;
            int case2Number2 = 4;
            int case2expected = 7;

            int case3Number1 = 5;
            int case3Number2 = 6;
            int case3expected = 11;

            int case4Number1 = 7;
            int case4Number2 = 8;
            int case4expected = 15;


            assertAll("Multiple testcases",
                    () -> assertEquals(case1expected, calculator.add(case1Number1, case1Number2)),
                    () -> assertEquals(case2expected, calculator.add(case2Number1, case2Number2)),
                    () -> assertEquals(case3expected, calculator.add(case3Number1, case3Number2)),
                    () -> assertEquals(case4expected, calculator.add(case4Number1, case4Number2)));

        }
    }

    @Nested
    @DisplayName("All testcases expected to fial")
    class FailingTestcases {
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

}
