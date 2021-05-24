package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.Report.PrintReport;
import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;

/**
 * Thread Runner Class To create And start All Threads.
 **/
public class ThreadRunner {

    public void excecuteThreads(Counter counter) throws InterruptedException {

        Thread1 runnable1 = new Thread1(counter);
        Thread2 runnable2 = new Thread2(counter);
        Thread3 runnable3 = new Thread3(counter);

       System.out.println("Starting Executing Threads");
       start(runnable1,"Thread 1");
       start(runnable2,"Thread 2");
       start(runnable3,"Thread 3").join();

       PrintReport.generateAndPrintReport(counter);
    }


    public Thread start(Runnable runnable,String name) {
        Thread thread = new Thread(runnable,name);
        thread.start();
        return thread;
    }
}
