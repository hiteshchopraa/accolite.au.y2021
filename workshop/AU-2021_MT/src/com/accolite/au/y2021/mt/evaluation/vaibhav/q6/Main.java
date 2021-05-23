package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.*;

// class for storing the result 
class Outcome {
    ArrayList<Horse> al; // ArrayList to store
    int count = 0;

    Outcome() {
        al = new ArrayList<>();
    }
}

// Main class
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in); // Scanning the output

        int N = sc.nextInt(); // No of threads (horses) the user wants for thr race
        Outcome outcome = new Outcome();
        for (int i = 1; i <= N; i++) {
            // For creating N (from the user) no of horses to race.
            Race r = new Race(new Horse("Horse " + i), outcome, N);

            Thread th = new Thread(r);// using runnable interface
            th.start();

        }
        sc.close();

    }

}
