package com.scholarpro.backend;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private GraphCalculator calculator = new GraphCalculator();

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addGrade(@RequestBody GradeRequest request) {
        calculator.addGrade(request.getGrade(), request.getWeight());
        calculator.calculateCGPA();

        Map<String, Object> response = new HashMap<>();
        response.put("currentCGPA", calculator.getCurrentCGPA());
        response.put("creditsCompleted", calculator.getCreditsCompleted());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/cgpa")
    public ResponseEntity<Map<String, Object>> getCGPA() {
        Map<String, Object> response = new HashMap<>();
        response.put("currentCGPA", calculator.getCurrentCGPA());
        response.put("cgpaOverTime", calculator.getCgpaOverTime());
        response.put("creditsCompleted", calculator.getCreditsCompleted());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/scholarship-check")
    public ResponseEntity<Map<String, Object>> checkScholarship(@RequestBody ScholarshipRequest request) {
        Double averageNeeded = calculator.getAverageNeeded(request.getCreditsRemaining());
        boolean isPossible = calculator.isAveragePossible(request.getCreditsRemaining());

        Map<String, Object> response = new HashMap<>();
        response.put("averageNeeded", averageNeeded);
        response.put("isPossible", isPossible);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/reset")
    public ResponseEntity<Void> reset() {
        calculator.reset();
        return ResponseEntity.ok().build();
    }
}