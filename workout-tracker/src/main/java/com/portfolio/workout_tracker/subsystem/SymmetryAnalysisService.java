package com.portfolio.workout_tracker.subsystem;
import org.springframework.stereotype.Service;

// this class is purely for biomechanical analysis of the movements,

@Service
public class SymmetryAnalysisService {

    public String analyzeCNSFatigue(String exercise){
        if(exercise == null){
            return "UNKNOWN";
        }

        if(exercise.toLowerCase().contains("squat") || exercise.toLowerCase().contains("press")){
            return "HEAVY_CNS_LOAD";
        }
        return "BALANCED";
    }

}
