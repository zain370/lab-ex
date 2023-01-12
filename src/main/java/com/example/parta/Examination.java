package com.example.parta;

import java.time.LocalDate;

public class Examination extends Assessment{
    Examination(String marksType, String date, double totalMarks, double obtainedMarks){
        super(marksType,date,totalMarks,obtainedMarks);

    }
    @Override
    public double calculateAggregateMarks() {
        return getObtainedMarks()/getTotalMarks()*75;
    }
}
