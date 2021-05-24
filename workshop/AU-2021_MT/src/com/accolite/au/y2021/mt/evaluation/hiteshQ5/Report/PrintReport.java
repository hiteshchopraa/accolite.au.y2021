package com.accolite.au.y2021.mt.evaluation.hiteshQ5.Report;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;

/**
 * Class To Generate and Print Final Report.
 **/
public class PrintReport {

    public static void generateAndPrintReport(Counter counter) {
        printLoop(0, 5, "", '\n');
        printLoop(0, 100, "", '*');
        printLoop(0, 1, "", '\n');
        printLoop(0, 1, "Counter 1 Value " + counter.getC1(), '\n');
        printLoop(0, 1, "Counter 2 Value " + counter.getC2(), '\n');
        printLoop(0, 1, "Counter 3 Value " + counter.getC3(), '\n');
        printLoop(0, 100, "", '*');
        printLoop(0, 1, "", '\n');
    }

    private static void printLoop(int start, int end, String val, char character) {
        for (int i = start; i < end; i++) {
            System.out.print(val + character);
        }
    }
}
