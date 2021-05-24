package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

class RandomSpeed implements Runnable {
    Horse reference; // Reference of the Horse class

    public RandomSpeed(Horse reference) {
        this.reference = reference;
    }

    int minSpeed = 40; // Kepping the speed in the range 40-60 m/s
    int maxSpeed = 60;
    int range = maxSpeed - minSpeed + 1;

    public void run() {

        reference.speed = (int) (Math.random() * range) + minSpeed; // random method to generate random values of speed

    }
}
