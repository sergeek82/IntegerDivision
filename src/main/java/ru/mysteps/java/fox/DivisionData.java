package ru.mysteps.java.fox;

import java.util.ArrayList;
import java.util.List;

public class DivisionData {
    private int divisible;
    private int divisor;
    private int firstPart;
    private int result;
    private int surplus;
    private List<Step> steps = new ArrayList();

    public DivisionData(int divisible,
                        int divisor,
                        int result,
                        int surplus) {
        this.divisible = divisible;
        this.divisor   = divisor;
        this.result    = result;
        this.surplus   = surplus;
    }

    public int getDivisible() {
        return divisible;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getResult() {
        return result;
    }

    public int getSurplus() {
        return surplus;
    }

    public int getFirstPart() {
        return firstPart;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setFirstPart(int firstPart) {
        this.firstPart = firstPart;
    }

    public void setSteps(Step step) {
        this.steps = steps;
        steps.add(step);
        if (steps.size() == 1) {
            steps.set(0, step).setPart(null);
        }
    }
}