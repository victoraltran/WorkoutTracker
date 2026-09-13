package com.portfolio.workout_tracker.dto;


// the class represents the data sent by an user to the api when a workout is logged

public class WorkoutSessionRequest {
    private String mainExercise;
    private int totalSets;
    private int avgRPE; // rating of perceived exertion (1-10)
    private int rir; // reps left in reserve (paired with RPE can measure a workout's efficiency)

    public String getMainExercise() {
        return mainExercise;
    }

    public void setMainExercise(String mainExercise) {
        this.mainExercise = mainExercise;
    }

    public int getTotalSets() {
        return totalSets;
    }

    public void setTotalSets(int totalSets) {
        this.totalSets = totalSets;
    }

    public int getAvgRPE() {
        return avgRPE;
    }

    public void setAvgRPE(int avgRPE) {
        this.avgRPE = avgRPE;
    }

    public void setRir (int rir) { this.rir = rir; }

    public int getRir() {return rir;}
}
