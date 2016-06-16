/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.MenuControler;
import demineur.Demineur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Observer;

/**
 *
 * @author SAM
 */
public class Menu extends Parent implements Observer{
    Rectangle background = new Rectangle(400,400, Color.GREY);
    Label message =new Label("Salut le monde !");
    private MenuControler controler ; 
    
    public Menu(Demineur dem){
        this.controler = new MenuControler(dem);
        this.getChildren().add(background);
        this.getChildren().add(message);
        message.setTranslateX(150);
        message.setTranslateY(10);
        Label message2 =new Label("entrer la taille de la grille");
        this.getChildren().add(message2);
        message2.setTranslateX(100);
        message2.setTranslateY(70);
        TextField size = new TextField();
        this.getChildren().add(size);
        size.setTranslateX(100);
        size.setTranslateY(100);
        Label message3 =new Label("entrer le nombre de bombe ( < au carré de la taille de la grille");
        this.getChildren().add(message3);
        message3.setTranslateX(50);
        message3.setTranslateY(170);
        TextField bomb = new TextField();        
        this.getChildren().add(bomb);
        bomb.setTranslateX(100);
        bomb.setTranslateY(200);
        Button button = new Button();
        button.setText("Let's Go !"); 
        this.getChildren().add(button);
        button.setTranslateX(100);
        button.setTranslateY(300);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s=size.getText();
                String b=bomb.getText();
                controler.getText(s,b);
            }
        });              
    }

    @Override
    public void update(boolean flag, boolean discover) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int n, int m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
