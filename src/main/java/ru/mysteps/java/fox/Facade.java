package ru.mysteps.java.fox;

public class Facade {

    Calculator calculator;
    Assembler assembler;

    public Facade(Calculator calculator,
                  Assembler assembler) {
        this.calculator = calculator;
        this.assembler  = assembler;
    }

    public String divide(int divisible,
                         int divisor) {
        return assembler.build(calculator.calculate(divisible, divisor));
    }
}