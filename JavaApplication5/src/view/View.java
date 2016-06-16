/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Controler;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Observer;

/**
 *
 * @author p1307887
 */
public class View extends Parent implements Observer{
    
    
    
    public View(Controler controler) {
        
        Plateau plateau = new Plateau(controler);
        this.getChildren().add(plateau);//on l'ajoute à notre groupe root
        controler.addObserver(this);
        
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
        if (fail){
            Rectangle finDeJeu = new Rectangle(200,200,Color.WHITE);
            Text nb = new Text("You Fail !!");
            final StackPane stack = new StackPane(); 
            stack.getChildren().addAll(finDeJeu, nb);
            
            this.getChildren().add(stack);
            System.out.println("you fail");
        }
    }

    
    
}
