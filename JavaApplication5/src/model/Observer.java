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
public interface Observer {

    public void update(boolean flag, boolean discover);
    public void update(int n);
    public void update(boolean fail);
    public void update(int n, int m);
}
