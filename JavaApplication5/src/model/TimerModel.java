/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author SAM
 */
public class TimerModel implements Observable{
    
    private int sec;
    private int min;
    private int h;
    private boolean active;
    private boolean stop = true;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    
    
    public TimerModel(){
        this.sec = 0;
        this.min = 0;
        this.h = 0;
        this.active=true;
        
    }
    
    
    public void run() {
        while(stop) {
            if(!active){
                synchronized (this){
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {
                    }
                }
            }
            try {
                // pause
                Thread.sleep(999);
            }
            catch (InterruptedException ex) {}
            if(active)
                incr();
                notifyObserver(sec, min, h);
        }
    }
    public void incr(){
        this.sec++;
        if(this.sec > 59){
            this.min++;
            this.sec -= 60;
            if(this.min>59){
                this.h++;
                this.min-=60;
            }
        }
        
    }

    public int getSec() {
        return sec;
    }

    public int getMin() {
        return min;
    }
    
    
    
    public void restart(){
        this.sec = 0;
        this.min = 0;
        this.h = 0;
        this.active = false;
        notifyObserver(sec, min, h);
    }
    
    public void pause(){
        this.active = false;
    }
    
    public void start(){
        this.active = true;
    }
    
    public void stop(){
        this.stop = true;
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    @Override
    public void removeObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(boolean flag, boolean discover) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(int n, int m, int h) {
        for(Observer obs : listObserver)
              obs.update(n, m, h);
    }
  
}
