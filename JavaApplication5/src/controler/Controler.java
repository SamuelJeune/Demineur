/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Random;
import model.CaseModel;
import model.GameModel;

/**
 *
 * @author p1307887
 */
public class Controler {
    
    private int size;
    private int[][]  matrixBomb;
    private int bombNumber;
    private GameModel gameModel;
    

    public Controler(int size,  int bombNumber) {
        this.size = size;
        this.bombNumber = bombNumber;
        this.gameModel = new GameModel(this.size, this.bombNumber);
        
    }
    
    
}
