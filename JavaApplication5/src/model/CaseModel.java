
package model;

import controler.Controler;
import java.util.ArrayList;



/**
 *
 * @author p1307887
 */
public class CaseModel implements Observable{
    
    private Controler controler;
    private boolean flagged = false;
    private int value;
    private int posX;
    private int posY;
    private boolean discovered = false;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    public CaseModel(Controler controler,  int posX, int posY) {
        this.controler = controler;
        this.value = controler.getValue(posX, posY);
        this.posX = posX;
        this.posY = posY;
        this.controler.grille[posX][posY]= this;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public int getValue() {
        return value;
    }
    public boolean isDiscovered() {
        return discovered;
    }

    public void setFlagged(boolean flag) {
        System.out.println(flag);
        
        this.flagged = flag;
        if (!discovered){
            if (this.value==1000){
                controler.bombFound();
                
            }
            notifyObserver(this.flagged, this.discovered);
        }
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
        notifyObserver(this.flagged, this.discovered);
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    @Override
    public void notifyObserver(boolean flag, boolean discover) {
        for(Observer obs : listObserver)
              obs.update(flag, discover);   
    }    
    

    public void discovering() {
        if (!discovered){
                this.setDiscovered(true);
                if(value==0){
                    controler.discovering(posX, posY);
                }
            }
        }

    @Override
    public void notifyObserver(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void fail() {
        controler.fail();
    }

    @Override
    public void notifyObserver(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(int n, int m, int h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
