package com.example.parta;

import java.time.LocalDate;

public abstract class Assessment {
    private String marksType;
    private String date;
    private double totalMarks;
    private double obtainedMarks;

    public Assessment(String marksType, String date, double totalMarks, double obtainedMarks) {
        this.marksType = marksType;
        this.date = date;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
    }

    public abstract double calculateAggregateMarks();

    public double getTotalMarks() {
        return totalMarks;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%.2f,%.2f", marksType,date,totalMarks,obtainedMarks);
    }
}
