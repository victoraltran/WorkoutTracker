package com.portfolio.workout_tracker.dto;
// API calculates and send back to the client


public class SessionEvaluationResponse {
    private String balanceRank;
    private int fatigueScore;

    public SessionEvaluationResponse (String balanceRank, int fatigueScore){
        this.balanceRank = balanceRank;
        this.fatigueScore = fatigueScore;
    }

    public String getBalanceRank() {
        return balanceRank;
    }

    public int getFatigueScore() {
        return fatigueScore;
    }
}
