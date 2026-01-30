package com.scholarpro.backend;

public class ScholarshipRequest {
    private double creditsRemaining;

    public ScholarshipRequest() {}

    public ScholarshipRequest(double creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }

    public double getCreditsRemaining() {
        return creditsRemaining;
    }

    public void setCreditsRemaining(double creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }
}