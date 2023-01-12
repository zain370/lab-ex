package com.example.parta;

import java.util.ArrayList;

public class Student {
    private String registrationNumber;
    private final ArrayList<? extends  Assessment> assessments;

    public Student(String registrationNumber, ArrayList<? extends Assessment> assessments) {
        this.registrationNumber = registrationNumber;
        this.assessments = assessments;

    }

    public double calculateTotalMarks(){
        double result = 0;

        for (Assessment a :
                assessments) {
            result += a.calculateAggregateMarks();
        }

        return result;
    }

}
