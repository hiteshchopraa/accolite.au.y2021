package com.accolite.au.y2021.mt.evaluation.aayush.q6;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.Random;
import java.util.Scanner;

public class Main implements Runnable {
    public static int n;

    public static void main(String[] args) throws InterruptedException {

        Scanner a = new Scanner(System.in);

        System.out.println("I have decreased the speed change time\nAnd the Distance to 200m \n" +
                "Because it was getting too long");

        n = a.nextInt();
        Ran random = new Ran();

        for(int i=0;i<n;i++)
        {
//            System.out.println("===========================================");
            random.getrandom();
            Horse h = new Horse("HORSE"+(i+1), random.r);
            Thread t = new Thread(h);
            t.setName("Horse "+(i+1));
            t.start();
            t.join(50);
//            System.out.println("===========================================");
        }

    }

    @Override
    public void run() {

        try {
            System.out.println();
            System.out.println("Thread speed -> "+Thread.currentThread().getName());
            Thread.sleep(30000);
//            Thread speed = new Thread(new Main(0));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("END Thread -> "+Thread.currentThread().getName());
    }
}
