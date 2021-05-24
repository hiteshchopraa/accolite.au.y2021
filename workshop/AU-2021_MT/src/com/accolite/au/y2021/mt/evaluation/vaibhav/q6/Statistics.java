package com.accolite.au.y2021.mt.evaluation.vaibhav.q6;

public class Statistics implements Runnable {
	String horseName; // Horse name passed
	Horse reference; // reference of the Horse

	Statistics(Horse reference, String horseName) {
		this.reference = reference;
		this.horseName = horseName;

	}

	int count = 0;

	public void run() {
		synchronized (this) {

			// Calculating the remainig distance
			reference.distanceRemaining = reference.totalDistance - reference.distanceCovered;
			if (reference.distanceRemaining < reference.speed) {
				// Adding the time required for it
				reference.timeTaken += (float) reference.distanceRemaining / reference.speed;
				reference.distanceCovered = reference.totalDistance;
			}

			else {

				reference.speedHistory += reference.speed + "m/s || ";// Adding the speed of each instance of the horse

				reference.distanceCovered += reference.speed; // Distance covered distance in meters and speed is in
																// m/s so distance covered is equal to speed per second.

				reference.timeTaken += 1; // Calculating the time, horse taking to finish the race

				reference.averageSpeed = (float) reference.distanceCovered / reference.timeTaken; // Calculating the
																									// average speed at
																									// each instance of
																									// time

				// Calculating the maximum speed
				if (reference.topSpeed < reference.speed) {
					reference.topSpeed = reference.speed;
				}
				// Calculating the minimum speed
				if (reference.lowSpeed > reference.speed) {
					reference.lowSpeed = reference.speed;
				}
			}

		}
	}
}
