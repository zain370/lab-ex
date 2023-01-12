package com.example.parta;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {
    public static void writeToFile(String content){
        File file = new File("marks.txt");
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Assessment> readFromFile(){
        ArrayList<String> arrayList = new ArrayList<>();

        File file = new File("marks.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null){
                arrayList.add(line);
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Assessment> assessments = new ArrayList<>();

        for (String s :
                arrayList) {
            String[] splittedData = s.split(",");
            if (splittedData[1].equals("Quiz"))
                assessments.add(new Quiz(splittedData[1],splittedData[2],Double.parseDouble(splittedData[3]),Double.parseDouble(splittedData[4])));
            else if(splittedData[1].equals("Assignment"))
                assessments.add(new Assignment(splittedData[1],splittedData[2],Double.parseDouble(splittedData[3]),Double.parseDouble(splittedData[4])));
            else if(splittedData[1].equals("Exam"))
                assessments.add(new Examination(splittedData[1],splittedData[2],Double.parseDouble(splittedData[3]),Double.parseDouble(splittedData[4])));
        }


    return assessments;
    }
}
