package com.nexthink.mnt;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


/*
 * @author - Abdelrhman Hamodua
 */

@Tag("standard")
public class StandardJunitTestDecorators {
    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach");
    }

    @Test
    void passingTest() {

    }

    @Test
    void failingTest() {
        fail("A failing test.");
    }

    @Test
    @Disabled("For a reason")
    void testToBeskipped() {
        // This will not run!
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("Test should have aborted");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll");
    }
}
