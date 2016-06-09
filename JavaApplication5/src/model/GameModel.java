/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author p1307887
 */
public class GameModel implements Observable{
    
    private int size;
    private int[][]  matrixBomb;
    private int bombNumber;
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();

    public GameModel(int size, int bombNumber) {
        this.size = size;
        this.bombNumber = bombNumber;
        this.matrixBomb = new int[size][size]; 
        this.init();
        this.calcul();
    }
    
    public void init(){
        int x;
        int y;
        Random rand = new Random();
        for(int i=0; i<this.bombNumber; i++){
            do{
            x = rand.nextInt(size);
            y = rand.nextInt(size);
            }while(matrixBomb[x][y]==1000);
            matrixBomb[x][y]=1000;
        }
        for(int i=0;i<size;i++){
            for(int j=0; j<size; j++){
            }
        }
    }
    
    public void calcul(){
        for(int i=1;i<size-1;i++){
            int n = 0;
                if (matrixBomb[i][0]!=1000){
                    if (matrixBomb[i-1][0]==1000) n++;
                    if (matrixBomb[i-1][0+1]==1000) n++;
                    if (matrixBomb[i][0+1]==1000) n++;
                    if (matrixBomb[i+1][0]==1000) n++;
                    if (matrixBomb[i+1][0+1]==1000) n++;
                    matrixBomb[i][0]=n;
                }
        }
        for(int i=1;i<size-1;i++){
            int n = 0;
                if (matrixBomb[i][size-1]!=1000){
                    if (matrixBomb[i-1][size-1]==1000) n++;
                    if (matrixBomb[i-1][size-2]==1000) n++;
                    if (matrixBomb[i][size-2]==1000) n++;
                    if (matrixBomb[i+1][size-1]==1000) n++;
                    if (matrixBomb[i+1][size-2]==1000) n++;
                    matrixBomb[i][size-1]=n;
                }
        }
        for(int j=1; j<size-1; j++){
            if (matrixBomb[0][j]!=1000){
                int n = 0;
                if (matrixBomb[0][j-1]==1000) n++;
                if (matrixBomb[0][j+1]==1000) n++;
                if (matrixBomb[0+1][j-1]==1000) n++;
                if (matrixBomb[0+1][j]==1000) n++;
                if (matrixBomb[0+1][j+1]==1000) n++;
                matrixBomb[0][j]=n;
                }
            }
        for(int j=1; j<size-1; j++){
            if (matrixBomb[size-1][j]!=1000){
                int n = 0;
                if (matrixBomb[size-1][j-1]==1000) n++;
                if (matrixBomb[size-1][j+1]==1000) n++;
                if (matrixBomb[size-2][j-1]==1000) n++;
                if (matrixBomb[size-2][j]==1000) n++;
                if (matrixBomb[size-2][j+1]==1000) n++;
                matrixBomb[size-1][j]=n;
                }
            }
        for(int i=1;i<size-1;i++){
            for(int j=1; j<size-1; j++){
                int n = 0;
                if (matrixBomb[i][j]!=1000){
                    if (matrixBomb[i-1][j-1]==1000) n++;
                    if (matrixBomb[i-1][j]==1000) n++;
                    if (matrixBomb[i-1][j+1]==1000) n++;
                    if (matrixBomb[i][j-1]==1000) n++;
                    if (matrixBomb[i][j+1]==1000) n++;
                    if (matrixBomb[i+1][j-1]==1000) n++;
                    if (matrixBomb[i+1][j]==1000) n++;
                    if (matrixBomb[i+1][j+1]==1000) n++;
                    matrixBomb[i][j]=n;
                }               
            }
        }
        if (matrixBomb[0][0]!=1000){
                int n = 0;
                if (matrixBomb[0][0+1]==1000) n++;
                if (matrixBomb[0+1][0+1]==1000) n++;
                if (matrixBomb[0+1][0]==1000) n++;                
                matrixBomb[0][0]=n;
                }
        if (matrixBomb[0][size-1]!=1000){
                int n = 0;
                if (matrixBomb[0][size-2]==1000) n++;
                if (matrixBomb[0+1][size-2]==1000) n++;
                if (matrixBomb[0+1][size-1]==1000) n++;                
                matrixBomb[0][size-1]=n;
                }
        if (matrixBomb[size-1][0]!=1000){
                int n = 0;
                if (matrixBomb[size-2][0]==1000) n++;
                if (matrixBomb[size-2][0+1]==1000) n++;
                if (matrixBomb[size-1][0+1]==1000) n++;                
                matrixBomb[size-1][0]=n;
                }
        if (matrixBomb[size-1][size-1]!=1000){
                int n = 0;
                if (matrixBomb[size-1][size-2]==1000) n++;
                if (matrixBomb[size-2][size-1]==1000) n++;
                if (matrixBomb[size-2][size-2]==1000) n++;                
                matrixBomb[size-1][size-1]=n;
                }
    }

    public int[][] getMatrixBomb() {
        return matrixBomb;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
