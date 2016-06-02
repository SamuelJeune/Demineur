/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author p1307887
 */
public class Case extends Parent{
    
    private int positionX = 0;
    private int positionY = 0;
    Rectangle fond_case = new Rectangle(20,20,Color.WHITE);
    
    public Case(int posX, int posY){
        
        positionX = posX;
        positionY = posY;
        fond_case.setArcHeight(5);
        fond_case.setArcWidth(5);
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        fond_case.setEffect(li);
        this.getChildren().add(fond_case);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_case.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                fond_case.setFill(Color.WHITE);

            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }
    
    public void appuyer(){
    fond_case.setFill(Color.DARKGREY);
    this.setTranslateY(positionY+2);
    }
    
    public void relacher(){
        fond_case.setFill(Color.WHITE);
        this.setTranslateY(positionY);
    }

    
    
}
