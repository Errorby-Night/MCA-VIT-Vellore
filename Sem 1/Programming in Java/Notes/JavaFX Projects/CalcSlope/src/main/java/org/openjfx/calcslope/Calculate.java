/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.openjfx.calcslope;

/**
 *
 * @author srijan
 */
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
//import javafx.event.Event;
import javafx.event.EventHandler;

public class Calculate implements EventHandler<ActionEvent>{
    TextField x1, x2, y1, y2, s;
    
    Calculate(TextField x1, TextField x2, TextField y1, TextField y2, TextField s){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.s = s;
    }
    @Override
    public void handle(ActionEvent e){
        double a1 = Double.parseDouble(x1.getText());
        double a2 = Double.parseDouble(x2.getText());
        double b1 = Double.parseDouble(y1.getText());
        double b2 = Double.parseDouble(y2.getText());
        
        double slope = (double)(b2 - b1) / (a2 - a1);
        s.setText(Double.toString(slope));
    }
    
    
}
