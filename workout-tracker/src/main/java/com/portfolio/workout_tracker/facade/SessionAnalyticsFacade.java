package com.portfolio.workout_tracker.facade;
import com.portfolio.workout_tracker.dto.SessionEvaluationResponse;
import com.portfolio.workout_tracker.dto.WorkoutSessionRequest;
import com.portfolio.workout_tracker.subsystem.NeuromuscularFatigueService;
import com.portfolio.workout_tracker.subsystem.SymmetryAnalysisService;
import org.springframework.stereotype.Service;

@Service
public class SessionAnalyticsFacade {
    private final SymmetryAnalysisService symmetryService;
    private final NeuromuscularFatigueService fatigueService;

    public SessionAnalyticsFacade(SymmetryAnalysisService symmetryService, NeuromuscularFatigueService fatigueService){
        this.fatigueService = fatigueService;
        this.symmetryService = symmetryService;
    }

    public SessionEvaluationResponse processWorkout(WorkoutSessionRequest request) {

        // Step A: Ask the symmetry subsystem to do its job
        String rank = symmetryService.analyzeCNSFatigue(request.getMainExercise());

        // Step B: Ask the fatigue subsystem to do its job
        int fatigue = fatigueService.calculateFatigue(request.getTotalSets(), request.getAvgRPE());

        // Step C: Package the results into the final plate and return it
        return new SessionEvaluationResponse(rank, fatigue);
    }
}

