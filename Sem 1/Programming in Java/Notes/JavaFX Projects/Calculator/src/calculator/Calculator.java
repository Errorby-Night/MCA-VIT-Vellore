/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

/**
 *
 * @author srijan
 * @version 1.0
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
public class Calculator extends Application{
    @Override
    public void start(Stage pstage){
        
        // Input
        TextField tf = new TextField();
        
        // Buttons
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b0 = new Button("0");
        
        Button bd = new Button("/");
        Button bm = new Button("*");
        Button bp = new Button("+");
        Button bs = new Button("-");
        
        Button bc = new Button("C");
        Button be = new Button("=");
        
        // Events
        
        b1.setOnAction(new ExpressionHandle(tf, b1));
        b2.setOnAction(new ExpressionHandle(tf, b2));
        b3.setOnAction(new ExpressionHandle(tf, b3));
        b4.setOnAction(new ExpressionHandle(tf, b4));
        b5.setOnAction(new ExpressionHandle(tf, b5));
        b6.setOnAction(new ExpressionHandle(tf, b6));
        b7.setOnAction(new ExpressionHandle(tf, b7));
        b8.setOnAction(new ExpressionHandle(tf, b8));
        b9.setOnAction(new ExpressionHandle(tf, b9));
        b0.setOnAction(new ExpressionHandle(tf, b0));
     
        GridPane root = new GridPane();
        root.addRow(0, tf);
        root.addRow(1, b7, b8, b9, bd);
        root.addRow(2, b4, b5, b6, bm);
        root.addRow(3, b1, b2, b3, bs);
        root.addRow(4, b0,bp,  be);
        Scene sc = new Scene(root, 300, 150);
        pstage.setScene(sc);
        pstage.show();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }
    
}
