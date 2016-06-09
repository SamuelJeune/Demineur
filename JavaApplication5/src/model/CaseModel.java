/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;



/**
 *
 * @author p1307887
 */
public class CaseModel implements Observable{
    private boolean flagged = false;
    private int value;
    private int posX;
    private int posY;
    private boolean discovered = false;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();   

    public boolean isFlagged() {
        return flagged;
    }

    public int getValue() {
        return value;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setFlagged(boolean flag) {
        System.out.println(flag);

        this.flagged = flag;
        notifyObserver(this.flagged);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
        notifyObserver(this.value);
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    @Override
    public void removeObserver() {
        listObserver = new ArrayList<Observer>();    
    }

    @Override
    public void notifyObserver(boolean flag) {
        for(Observer obs : listObserver)
              obs.update(flag);   
    }    
    @Override
    public void notifyObserver(int n) {
        for(Observer obs : listObserver)
              obs.update(n);   
    }    

    
}
