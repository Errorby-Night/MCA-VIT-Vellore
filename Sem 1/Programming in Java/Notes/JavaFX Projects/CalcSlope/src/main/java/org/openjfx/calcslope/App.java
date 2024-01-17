package org.openjfx.calcslope;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TextField x1 = new TextField();
        TextField y1 = new TextField();
        TextField x2 = new TextField();
        TextField y2 = new TextField();
        TextField s = new TextField();
        Label l1 = new Label("Enter point 1 x1 coordinate: ");
        Label l2 = new Label("Enter point 1 y1 coordinate: ");
        Label l3 = new Label("Enter point 2 x2 coordinate: ");
        Label l4 = new Label("Enter point 2 y2 coordinate: ");
        Label l5 = new Label("Slope: ");
        Button b1 = new Button("Submit");
        b1.setOnAction(new Calculate(x1, x2, y1, y2, s));
        GridPane root = new GridPane();
        root.addRow(2, l1, x1);
        root.addRow(3, l2, y1);
        root.addRow(4, l3, x2);
        root.addRow(5, l4, y2);
        root.addRow(6, l5,s);
        root.addRow(7, b1);
        Scene sc = new Scene(root, 500, 500);
        stage.setTitle("Slope Calculator");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}