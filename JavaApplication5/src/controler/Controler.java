
package controler;

import demineur.Demineur;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import model.CaseModel;
import model.GameModel;
import model.Observable;
import model.Observer;

/**
 *
 * @author p1307887
 */
public class Controler implements Observable{
    
    private int size;
    private int[][]  matrixBomb;
    private int bombNumber;
    private GameModel gameModel;
    public CaseModel[][] grille;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    boolean fail =false;
    public int bombnb;

    public int getSize() {
        return size;
    }

    public int getBombNumber() {
        return bombNumber;
    }
    
    
    public Controler(int size,  int bombNumber) {
        this.size = size;
        this.bombNumber = bombNumber;
        this.gameModel = new GameModel(this.size, this.bombNumber);
        this.gameModel.init();
        this.gameModel.calcul();
        this.matrixBomb=this.gameModel.getMatrixBomb();
        this.grille = new CaseModel[size][size];
    }
    
    public int getValue(int i, int j){
        return gameModel.getValue(i, j);
    }

    public void discovering(int x, int y) {
        try{
            grille[x-1][y-1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x-1][y].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x-1][y+1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x][y-1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x][y+1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x+1][y-1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x+1][y].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
        try{
            grille[x+1][y+1].discovering();
            }catch (java.lang.ArrayIndexOutOfBoundsException e) {}
    }

    public void fail() {
        notifyObserver(true);
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }


    @Override
    public void notifyObserver(boolean fail) {
        for(Observer obs : listObserver)
        obs.update(fail);
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
    public void notifyObserver(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void bombFound(){
        bombNumber--;
        
        if (bombNumber==0){
            
            notifyObserver(false);
        }
    }

    @Override
    public void notifyObserver(int n, int m, int h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
