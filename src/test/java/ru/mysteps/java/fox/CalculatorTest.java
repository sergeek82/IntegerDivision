package ru.mysteps.java.fox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;
    private DivisionData data;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
        data       = calculator.calculate(10004, 4);
    }

    @Test
    void processShouldFillRightDataVar() {
        assertEquals(10004, data.getDivisible());
        assertEquals(4, data.getDivisor());
        assertEquals(2501, data.getResult());
        assertEquals(10, data.getFirstPart());
        assertEquals(0, data.getSurplus());
    }

    @Test
    void processShouldFillStepList() {
        assertEquals(null, data.getSteps().get(0).getPart());
        assertEquals(8, data.getSteps().get(0).getDeductible());
        assertEquals(20, data.getSteps().get(1).getPart());
        assertEquals(20, data.getSteps().get(1).getDeductible());
        assertEquals(4, data.getSteps().get(2).getPart());
        assertEquals(4, data.getSteps().get(2).getDeductible());
    }
}