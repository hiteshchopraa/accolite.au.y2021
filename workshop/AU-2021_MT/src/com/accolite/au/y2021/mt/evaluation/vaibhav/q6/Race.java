package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class Race implements Runnable {
    Horse reference; // Reference of Horse class
    Outcome outcome; // Reference of Outcome class
    int N; // Total number of horse input by the user

    Race(Horse reference, Outcome outcome, int N) {
        this.reference = reference;
        this.outcome = outcome;
        this.N = N;

    }

    public void run() {
        do {
            synchronized (this) {

                // if distance covered becomes equal to track distance the race ends
                // totalDistance is the distance of the track
                if (reference.distanceCovered == reference.totalDistance) {
                    outcome.al.add(reference);
                    outcome.count++;
                    break;
                }
                // Changing the speed of the Horse every 5 seconds but can be set to any time.
                if (reference.timeTaken % 5 == 0) {
                    // This thread is responsible for changing the speed.
                    RandomSpeed rs = new RandomSpeed(reference);
                    Thread th = new Thread(rs);
                    th.start();

                }
                // This thread is storing and updating all the information of the Horse like
                // speed, time , distance, average speed , minspeed,maxspeed,speed history at
                // each instance.
                Statistics sta = new Statistics(reference, Thread.currentThread().getName());
                Thread thd = new Thread(sta);
                thd.start();
                // join() is used so that no other thread can manipulate if the some other
                // thread
                // is making changes.
                try {
                    thd.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } while (true);

        // HashMap for storing the data and picking the winner on the bases of Average
        // speed.
        HashMap<Horse, Number> map = new HashMap<Horse, Number>();
        // Till all the horses(user input) finishes the race
        if (outcome.count == N) {
            // Adding the data from the list to HashMap
            for (int i = 0; i < outcome.al.size(); i++) {
                if (!map.containsKey(outcome.al.get(i))) {
                    map.put(outcome.al.get(i), outcome.al.get(i).averageSpeed);
                }

            }
            int counter = 0;
            // For formating the time and average speed to two decimal spaces.
            DecimalFormat df = new DecimalFormat(".##");
            // Printing the Winner and data of all the horses.
            for (Map.Entry<Horse, Number> hashMap : map.entrySet()) {
                if (counter == 0) {
                    System.out.println("---------- WINNER ---------- is " + hashMap.getKey().horseName);
                    System.out.println();
                    System.out.println("Horse Name = " + hashMap.getKey().horseName + "\nDistance Covered : "
                            + hashMap.getKey().distanceCovered + "\nTime Taken : "
                            + df.format(hashMap.getKey().timeTaken) + "\nAverage Speed : "
                            + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history at each instance : " + hashMap.getKey().speedHistory);
                    counter++;
                    System.out.println();
                } else {
                    System.out.println(
                            "------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Horse Name = " + hashMap.getKey().horseName + "\nDistance Covered : "
                            + hashMap.getKey().distanceCovered + "\nTime Taken : "
                            + df.format(hashMap.getKey().timeTaken) + "\nAverage Speed : "
                            + df.format(hashMap.getKey().averageSpeed) + "\nMinimum Speed : "
                            + hashMap.getKey().lowSpeed + "\nMaximum Speed : " + hashMap.getKey().topSpeed
                            + "\nSpeed history at each instance : " + hashMap.getKey().speedHistory);
                }
            }

        }
    }
}
