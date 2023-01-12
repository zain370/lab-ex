package com.example.parta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ComboBox<String> cbAssesmentTypes;
    @FXML
    public TextField tfTotalMarks;
    @FXML
    public TextField tfReg;
    @FXML
    public Button saveBtn;
    @FXML
    public DatePicker datePicker;
    @FXML
    public TextField tfObtainedMarks;
    @FXML
    public Button calcBtn;
    @FXML
    public Text errorMessage;
    @FXML
    public Text tMarks;

    public void saveBtnAction(){

        String marksType = cbAssesmentTypes.getValue();
        Assessment assessment = null;
        if (Double.parseDouble(tfObtainedMarks.getText()) <= Double.parseDouble(tfTotalMarks.getText())) {
            errorMessage.setVisible(false);
            if (marksType.equals("Quiz")) {
                assessment = new Quiz(marksType, datePicker.getValue().toString(), Double.parseDouble(tfTotalMarks.getText()), Double.parseDouble(tfObtainedMarks.getText()));
            } else if (marksType.equals("Assignment")) {
                assessment = new Assignment(marksType, datePicker.getValue().toString(), Double.parseDouble(tfTotalMarks.getText()), Double.parseDouble(tfObtainedMarks.getText()));
            } else if (marksType.equals("Exam")) {
                assessment = new Examination(marksType, datePicker.getValue().toString(), Double.parseDouble(tfTotalMarks.getText()), Double.parseDouble(tfObtainedMarks.getText()));
            }
            assert assessment != null;
            FileHandling.writeToFile(tfReg.getText() + "," + assessment);


        }else {
            errorMessage.setText("Obtained Marks cannot be greater than total marks");
            errorMessage.setVisible(true);
        }
    }

    public void calcTotalBtnAction(){
        Student student = new Student(tfReg.getText(), FileHandling.readFromFile());
        double result = student.calculateTotalMarks();
        tMarks.setText("Total Marks of "+ tfReg.getText() +" are: " + result  + " out of 100");
        tMarks.setVisible(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    cbAssesmentTypes.getItems().add("Quiz");
    cbAssesmentTypes.getItems().add("Assignment");
    cbAssesmentTypes.getItems().add("Exam");
    }
}