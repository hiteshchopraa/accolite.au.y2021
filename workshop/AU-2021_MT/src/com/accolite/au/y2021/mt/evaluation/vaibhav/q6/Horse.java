package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

import java.util.concurrent.ThreadLocalRandom;

public class Horse {
    String horseName; // Name of the horse

    public Horse(String horseName) {
        this.horseName = horseName;

    }

    int totalDistance = 1000; // Total length of the track in meters
    int speed = ThreadLocalRandom.current().nextInt(40, 60 + 1); // Providing random value of speed
    float timeTaken = 0; // Time taken by the horse for the race
    int distanceCovered = 0; // Distance covered by the horse
    float averageSpeed = 0; // Average speed pf the horse
    int topSpeed = Integer.MIN_VALUE; // Max speed of the horse
    int lowSpeed = Integer.MAX_VALUE; // Minimum speed of the horse
    String speedHistory = ""; // Storing the speed of each instance of the horse
    int distanceRemaining; // Calculating the remaining distance of the race.
}
