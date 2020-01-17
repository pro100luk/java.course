package com.intellias.px.calc;

import calc.Calculator;
import calc.SimpleCalculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SimpleCalculatorTest {

    private Calculator calculator;

    @Before
    public void setupEnv(){
        calculator = new SimpleCalculator();
    }

    @Test
    public void shouldMultiplyNumbers(){
        int product = calculator.multiply(0, 5);
        assertEquals(0, product);
    }

    @Test(expected = NullPointerException.class)
    public void shouldMultiplyNonZeroNumbers() {
        calculator = null;
        int product = calculator.multiply(5, 5);
        assertEquals(25, product);
    }

    @Test
    public void shouldMultipyNonZeroDutDifferentNumbers() {
        int product = calculator.multiply(5, 6);
        assertEquals(30, product);
    }

    @Test
    public void shouldMultiplyNegativeNumbers() {
        int product = calculator.multiply(5, -6);
        assertEquals(-30, product);
    }

    @Test
    @Parameters({
            "0, 5, 0",
            "5, 5, 25",
            "5, -5, -25",
            "5, -6, -30"
    })
}
