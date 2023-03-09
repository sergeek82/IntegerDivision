package ru.mysteps.java.fox;

public class Calculator {

    public DivisionData calculate(int divisible,
                                  int divisor) {
        int surplus = divisible % divisor;
        int result = divisible / divisor;
        int numLength = String.valueOf(divisible).length();
        int[] numbers = new int[numLength];
        DivisionData data = new DivisionData(divisible, divisor, result, surplus);

        for (int i = 0; i <= numLength - 1; i++) {
            numbers[i] = String.valueOf(divisible).charAt(i) - '0';
        }
        int part = numbers[0];
        int repeat = numbers.length;
        int deductible;
        Step step;

        for (int j = 1; j <= repeat; j++) {
            step = new Step();

            if (part >= divisor) {
                deductible = (part / divisor) * divisor;
                step.setPart(part);
                step.setDeductible(deductible);
                data.setSteps(step);
                if (data.getSteps().size() == 1) {
                    data.setFirstPart(part);
                }
                part = part % divisor;
            }
            if (part < divisor && j < repeat) {
                part = Integer.parseInt(part + "" + numbers[j]);
            }
        }
        return data;
    }
}