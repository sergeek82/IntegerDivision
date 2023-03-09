package ru.mysteps.java.fox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FacadeTest {
    private Calculator calculator;
    private Assembler assembler;
    private DivisionData data;
    private Facade facade;

    @BeforeEach
    void init() {
        calculator = mock(Calculator.class);
        assembler  = mock(Assembler.class);
        facade     = new Facade(calculator, assembler);
        data       = new DivisionData(8, 3, 2, 2);
    }

    @Test
    void processShouldCheckCalculatorInvokeQuantity() {
        when(calculator.calculate(8, 3)).thenReturn(data);
        facade = new Facade(calculator, assembler);
        facade.divide(8, 3);
        verify(calculator, times(1)).calculate(8, 3);
    }

    @Test
    void processShouldCheckAssemblerInvokeQuantity() {
        when(calculator.calculate(8, 3)).thenReturn(data);
        when(assembler.build(data)).thenReturn("_8|3\n" +
            " 6|-\n" +
            " -|2\n" +
            " 2");
        facade = new Facade(calculator, assembler);
        facade.divide(8, 3);
        verify(assembler, times(1)).build(data);
    }

    @Test
    void processShouldCheckFacadeOrder() {
        when(calculator.calculate(8, 3)).thenReturn(data);
        when(assembler.build(data)).thenReturn("_8|3\n" +
            " 6|-\n" +
            " -|2\n" +
            " 2");
        facade.divide(8, 3);
        InOrder inOrder = inOrder(calculator, assembler);
        inOrder.verify(calculator).calculate(8, 3);
        inOrder.verify(assembler).build(data);
    }
}
