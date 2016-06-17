/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Observer;
import model.TimerModel;

/**
 *
 * @author SAM
 */
public class TimerView extends Parent implements Observer{
    private int sec;
    private int min;
    TimerModel tm = new TimerModel();
    private int h;
    HBox box = new HBox();
    Label second = new Label();
    Label minute = new Label();
    Label hour = new Label();
    
    public TimerView(){
        tm.addObserver(this);
        second.setText(String.valueOf(sec));
        minute.setText(String.valueOf(min));
        hour.setText(String.valueOf(h));
        box.getChildren().addAll(second ,minute, hour);

    }
    
    @Override
    public void update(int n, int m, int h) {
        this.sec=n;
        this.min=m;
        this.h=h;
        second.setText(String.valueOf(sec));
        minute.setText(String.valueOf(min));
        hour.setText(String.valueOf(this.h));
        box.getChildren().addAll(second ,minute, hour);
    }

    @Override
    public void update(boolean flag, boolean discover) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
