package com.example.parta;

import java.time.LocalDate;
import java.util.Date;

public class Quiz extends Assessment{
    Quiz(String marksType, String date, double totalMarks, double obtainedMarks){
        super(marksType,date,totalMarks,obtainedMarks);
    }
    @Override
    public double calculateAggregateMarks() {
        return getObtainedMarks()/getTotalMarks()*15;
    }
}
