package org.openjfx.employeedetails;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label idLabel = new Label("Employee ID:");
        TextField idField = new TextField();
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label departmentLabel = new Label("Department:");
        TextField departmentField = new TextField();
        Label basicPayLabel = new Label("Basic Pay:");
        TextField basicPayField = new TextField();

        Label daLabel = new Label("DA:");
        TextField daField = new TextField();
        daField.setEditable(false);
        Label hraLabel = new Label("HRA:");
        TextField hraField = new TextField();
        hraField.setEditable(false);
        Label salaryLabel = new Label("Salary:");
        TextField salaryField = new TextField();
        salaryField.setEditable(false);
        Label dis = new Label();
        
        Button insertButton = new Button("Insert");
        insertButton.setOnAction(e -> {
            double bp = Double.parseDouble(basicPayField.getText());
            double da = 0.25 * bp;
            double hra = 0.12 * bp;
            double salary = bp + da + hra;
            daField.setText(String.valueOf(da));
            hraField.setText(String.valueOf(hra));
            salaryField.setText(String.valueOf(salary));
            dis.setText("Details Entered into database!");
        });
        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> {
            idField.clear();
            nameField.clear();
            departmentField.clear();
            basicPayField.clear();
            daField.clear();
            hraField.clear();
            salaryField.clear();
            dis.setText(null);
        });
        GridPane root = new GridPane();
        root.addRow(0, idLabel, idField);
        root.addRow(1, nameLabel, nameField);
        root.addRow(2, departmentLabel, departmentField);
        root.addRow(3, basicPayLabel, basicPayField);
        root.addRow(4, daLabel, daField);
        root.addRow(5, hraLabel, hraField);
        root.addRow(6, salaryLabel, salaryField);
        root.addRow(7, insertButton, resetButton);
        root.addRow(8, dis);
        Scene sc = new Scene(root, 500, 500);
        stage.setTitle("Employee Details");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}