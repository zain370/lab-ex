package com.example.parta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AssessmentSystem extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AssessmentSystem.class.getResource("AssesmentSystem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Lab Terminal Exam");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}