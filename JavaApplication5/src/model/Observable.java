/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SAM
 */
public interface Observable {
    public void addObserver(Observer obs);
    public void removeObserver();
    public void notifyObserver(boolean flag, boolean discover);
    public void notifyObserver(boolean fail);
    public void notifyObserver(int n, int m);
}
