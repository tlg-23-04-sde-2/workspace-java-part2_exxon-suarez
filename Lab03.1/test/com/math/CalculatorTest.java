/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    // business object(s) under test - called a "fixture"
    private Calculator calc;

    @BeforeClass
    public static void initializeEntireTestRun()  {
        System.out.println("initializeEntireTestRun");
    }

    @AfterClass
    public static void finalizeTestRun() {
        System.out.println("finalizeTestRun");
    }

    @Before                     // this runs before every new Test
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();    // here we initialize a new Calculator instance ( calc ) ( which occurs BEFORE every Test )
    }

    @After
    public void cleanUp() {
        System.out.println("cleanUp");
    }

    @Test
    public void testIsEven() {
        System.out.println("test is even");
        assertTrue(calc.isEven(10));        // this calc references the calc created in our setUp method
        assertFalse(calc.isEven(11));

    }


    @Test
    public void testDivide() {
        System.out.println("test is divide");
        assertEquals(2.5, calc.divide(5,2), .001);      // expected, actual and delta ( because of floating point errors)
    }



    @Test
    public void testAdd() {
        System.out.println("test is add");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }


}