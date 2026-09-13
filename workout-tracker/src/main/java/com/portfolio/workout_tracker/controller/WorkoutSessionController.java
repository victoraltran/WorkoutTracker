package com.portfolio.workout_tracker.controller;


import com.portfolio.workout_tracker.dto.SessionEvaluationResponse;
import com.portfolio.workout_tracker.dto.WorkoutSessionRequest;
import com.portfolio.workout_tracker.facade.SessionAnalyticsFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sessions")
public class WorkoutSessionController {

    // contoller only talks with the facade,  so we got to have one here
    private final SessionAnalyticsFacade facade;

    //its constructor
    public WorkoutSessionController(SessionAnalyticsFacade facade) {
        this.facade = facade;
    }

    // this is trigged when a client sends POST request
    @PostMapping("/analyze")

    public ResponseEntity<SessionEvaluationResponse>
    analyzeSession(@RequestBody WorkoutSessionRequest request){

        // hand the request to the facade
        SessionEvaluationResponse response = facade.processWorkout(request);

        // wrap the response in an HTTP 200 OK status and return it
            //  HTTP 200 OK -> a standard server response indicating that a client's request has succeeded without errors
        return ResponseEntity.ok(response);
    }
}
