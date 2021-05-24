package com.accolite.au.y2021.mt.evaluation.hiteshQ5.threads;

import com.accolite.au.y2021.mt.evaluation.hiteshQ5.model.Counter;

/**
 * Thread 2 Class Used to Increment the counter by 2 whenever the Counter Incremented by Thread1 is an factor of 25.
 **/
public class Thread2 implements Runnable {

    Counter counter;

    public Thread2(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getC1() < counter.getMaxCount() || !counter.isTerminateExecution()) {
            if (counter.getC1() % 25 == 0 && counter.getC1() != 0 && !counter.isSecondConsumed()) {
                counter.increment2();
                if (!counter.isThirdConsumed()) {
                    counter.takeWait();
                }
                if (counter.getC2() % 4 == 0 && counter.getC2() != 0) {
                    counter.setThirdConsumed(false);
                }
                counter.setSecondConsumed(true);
                System.out.println(
                    Thread.currentThread().getName() + " Incremented Counter2 By 2 and Counter Becomes-> " + counter
                        .getC2());
                counter.notifyOthers();
                counter.takeWait();
            }
        }
    }
}
