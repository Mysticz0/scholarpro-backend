package com.scholarpro.backend;

public class GradeRequest {
    private String grade;
    private double weight;

    // Constructors
    public GradeRequest() {}

    public GradeRequest(String grade, double weight) {
        this.grade = grade;
        this.weight = weight;
    }

    // Getters and Setters
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}