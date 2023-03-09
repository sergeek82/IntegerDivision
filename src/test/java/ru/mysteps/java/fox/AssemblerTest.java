package ru.mysteps.java.fox;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AssemblerTest {

    private Assembler assembler;
    private Calculator calculator;

    @BeforeEach
    public void init() {
        assembler  = new Assembler();
        calculator = new Calculator();
    }

    @Test
    void processShouldDrawDivisionWithZeros() {
        assertEquals("_10004|4\n" +
                "  8   |----\n" +
                "  -   |2501\n" +
                " _20\n" +
                "  20\n" +
                "  --\n" +
                "   _4\n" +
                "    4\n" +
                "    -\n" +
                "    0",
            assembler.build(calculator.calculate(10004, 4)));
    }

    @Test
    void processShouldDrawDivisionTwoDigitDivisor() {
        assertEquals("_1012131517|44\n" +
                "  88       |--------\n" +
                "  --       |23002989\n" +
                " _132\n" +
                "  132\n" +
                "  ---\n" +
                "    _131\n" +
                "      88\n" +
                "      --\n" +
                "     _435\n" +
                "      396\n" +
                "      ---\n" +
                "      _391\n" +
                "       352\n" +
                "       ---\n" +
                "       _397\n" +
                "        396\n" +
                "        ---\n" +
                "          1",
            assembler.build(calculator.calculate(1012131517, 44)));
    }

    @Test
    void processShouldDrawDivisionOneDivisibleAndDigitDivisor() {
        assertEquals("_8|3\n" +
                " 6|-\n" +
                " -|2\n" +
                " 2",
            assembler.build(calculator.calculate(8, 3)));
    }

    @Test
    void processShouldDrawDivisionOneDigitDivisor() {
        assertEquals("_2223|2\n" +
                " 2   |----\n" +
                " -   |1111\n" +
                " _2\n" +
                "  2\n" +
                "  -\n" +
                "  _2\n" +
                "   2\n" +
                "   -\n" +
                "   _3\n" +
                "    2\n" +
                "    -\n" +
                "    1",
            assembler.build(calculator.calculate(2223, 2)));
    }

    @Test
    void processShouldDrawDivisionThreeDigitDivisor() {
        assertEquals("_12131517|123\n" +
                " 1107    |-----\n" +
                " ----    |98630\n" +
                " _1061\n" +
                "   984\n" +
                "   ---\n" +
                "   _775\n" +
                "    738\n" +
                "    ---\n" +
                "    _371\n" +
                "     369\n" +
                "     ---\n" +
                "      27",
            assembler.build(calculator.calculate(12131517, 123)));
    }
}
