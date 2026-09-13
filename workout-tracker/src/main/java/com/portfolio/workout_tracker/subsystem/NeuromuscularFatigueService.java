package com.portfolio.workout_tracker.subsystem;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class NeuromuscularFatigueService {
    public int calculateFatigue(int sets, int rpe){
        return sets * rpe;
    }

}

