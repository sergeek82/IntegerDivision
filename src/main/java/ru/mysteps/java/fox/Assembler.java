package ru.mysteps.java.fox;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assembler {

    private final String GAP = " ";
    private final String VERT_LINE = "|";
    private final String DOWN_LINE = "_";
    private final String DASH = "-";
    private final String NEW_LINE = "\n";
    private final String DIGIT = "\\d";

    public String build(DivisionData data) {
        StringBuilder collector = new StringBuilder();
        calculateSpaces(data);
        collector.append(drawHead(data, calculateSpaces(data)));
        collector.append(drawBody(data, calculateSpaces(data)));
        return collector.toString();
    }

    private List<Integer> calculateSpaces(DivisionData data) {
        List<Integer> blanks = new ArrayList<>();
        int space = 0;
        if (String.valueOf(data.getFirstPart()).length() !=
            String.valueOf(data.getSteps().get(0).getDeductible()).length()) {
            space = 1;
        }
        blanks.add(space);
        if (data.getFirstPart() - data.getSteps().get(0).getDeductible() == 0) {
            space = String.valueOf(data.getFirstPart()).length();
        } else if (String.valueOf(data.getFirstPart() - data.getSteps().get(0).getDeductible()).length() <
            data.getSteps().get(0).getDeductible().toString().length()) {
            space = String.valueOf(data.getFirstPart()).length() - String.valueOf(data.getFirstPart() -
                data.getSteps().get(0).getDeductible()).length();
        }
        blanks.add(space);
        for (int i = 1; i < data.getSteps().size(); i++) {
            if (data.getSteps().get(i).getPart() - data.getSteps().get(i).getDeductible() == 0) {
                space += String.valueOf(data.getSteps().get(i).getDeductible()).length();
            } else if (String.valueOf(data.getSteps().get(i).getPart() - data.getSteps().get(i).getDeductible()).length() <
                String.valueOf(data.getSteps().get(i).getPart()).length()) {
                space += String.valueOf(data.getSteps().get(i).getPart()).length() -
                    (String.valueOf(data.getSteps().get(i).getPart() - data.getSteps().get(i).getDeductible()).length());
            }
            blanks.add(space);
        }
        return blanks;
    }

    private StringBuilder drawHead(DivisionData data,
                                   List<Integer> blanks) {
        StringBuilder upPart = new StringBuilder();

        upPart.append(DOWN_LINE)
            .append(data.getDivisible()).append(VERT_LINE).append(data.getDivisor()).append(NEW_LINE)
            .append(GAP)
            .append(strIterate(GAP, blanks.get(0))).append(data.getSteps().get(0).getDeductible())
            .append(strIterate(GAP, (String.valueOf(data.getDivisible()).length() - (blanks.get(0) +
                (String.valueOf(data.getSteps().get(0).getDeductible()).length())))))
            .append(VERT_LINE)
            .append(String.valueOf(data.getResult()).replaceAll(DIGIT, DASH)).append(NEW_LINE)
            .append(GAP)
            .append(strIterate(GAP, blanks.get(0)))
            .append(String.valueOf(data.getSteps().get(0).getDeductible()).replaceAll(DIGIT, DASH))
            .append(strIterate(GAP, (String.valueOf(data.getDivisible()).length() - (blanks.get(0) +
                (String.valueOf(data.getSteps().get(0).getDeductible()).length())))))
            .append(VERT_LINE)
            .append(data.getResult()).append(NEW_LINE);
        if (data.getSteps().size() <= 1) {
            upPart.append(GAP)
                .append(strIterate(GAP, blanks.get(0) +
                    (String.valueOf(data.getSteps().get(0).getDeductible()).length() -
                        String.valueOf(data.getSurplus()).length())))
                .append(data.getSurplus());
        }
        return upPart;
    }

    private StringBuilder drawBody(DivisionData data,
                                   List<Integer> blanks) {
        StringBuilder downPart = new StringBuilder();
        for (int i = 1; i < data.getSteps().size(); i++) {
            if (data.getSteps().get(i).getPart() != null) {
                downPart.append(strIterate(GAP, blanks.get(i))).append(DOWN_LINE).append(data.getSteps().get(i).getPart())
                    .append(NEW_LINE)
                    .append(GAP)
                    .append(strIterate(GAP, blanks.get(i) + (String.valueOf(data.getSteps().get(i).getPart()).length() -
                        String.valueOf(data.getSteps().get(i).getDeductible()).length())))
                    .append(data.getSteps().get(i).getDeductible()).append(NEW_LINE)
                    .append(GAP).append(strIterate(GAP, blanks.get(i) +
                        (String.valueOf(data.getSteps().get(i).getPart()).length() -
                            String.valueOf(data.getSteps().get(i).getDeductible()).length())))
                    .append(strIterate(DASH, String.valueOf(data.getSteps().get(i).getDeductible()).length()))
                    .append(NEW_LINE);
            }
            if (i == data.getSteps().size() - 1) {
                downPart.append(GAP).append(strIterate(GAP, blanks.get(i) +
                        (String.valueOf(data.getSteps().get(i).getPart()).length() -
                            String.valueOf(data.getSurplus()).length())))
                    .append(data.getSurplus());
            }
        }
        return downPart;
    }

    private String strIterate(String iterable,
                              int quantity) {
        String out;
        return out = String.join("", Collections.nCopies(quantity, iterable));
    }
}