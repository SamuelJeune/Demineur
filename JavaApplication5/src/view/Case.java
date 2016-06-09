/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.CaseControler;
import view.Drapeau;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.CaseModel;
import model.Observer;

/**
 *
 * @author p1307887
 */
public class Case extends Parent implements Observer{
    
    private int positionX = 0;
    private int positionY = 0;
    Rectangle fond_case = new Rectangle(20,20,Color.WHITE);
    private boolean drapeau = false;
    Drapeau drap = new Drapeau();
    private int n;
    private CaseModel caseModel = new CaseModel();
    private CaseControler caseControler = new CaseControler(caseModel);
    
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
        caseModel.addObserver(this);
        
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
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.SECONDARY)){
                        caseControler.addFlag();
                        System.out.println("case");
                }
            }
        });
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        caseControler.discover();
                        System.out.println("case");
                }
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
    
    

    @Override
    public void update(boolean flag) {
        System.out.println(flag);

        if (flag) {
            this.getChildren().add(drap);
        }
        else this.getChildren().remove(drap);
    }

    @Override
    public void update(int n) {
        System.out.println(n);
        Text nb = new Text(Integer.toString(n));
        this.getChildren().add(nb);

        
            
        
    }    
    
    
}
