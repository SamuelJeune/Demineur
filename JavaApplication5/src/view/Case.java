/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.CaseControler;
import controler.Controler;
import view.Drapeau;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
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
    Rectangle fond_case = new Rectangle(50,50,Color.WHITE);
    private boolean drapeau = false;
    Drapeau drap = new Drapeau();
    private int n;
    private CaseModel caseModel;
    private CaseControler caseControler;
    private  Value value;
    
    public Case(int posX, int posY, Controler controler){
        
        this.positionX = posX;
        this.positionY = posY;
        this.caseModel = new CaseModel(controler, posX, posY);
        this.caseControler = new CaseControler(caseModel);
        fond_case.setArcHeight(5);
        fond_case.setArcWidth(5);
        Light.Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        this.n=caseModel.getValue();
        this.value = new Value(n);
        fond_case.setEffect(li);
        final StackPane stack = new StackPane(); 
        stack.getChildren().addAll(drap, value, fond_case); 
        //this.getChildren().add(fond_case);
        this.setTranslateX(positionX);
        this.setTranslateY(positionY);
        caseModel.addObserver(this);
        this.getChildren().add(stack);
        
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
                        System.out.println("2");   
                }
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        caseControler.discover();
                        System.out.println("1");
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
    public void update(boolean flag, boolean discover) {
        if (flag) {
            drap.toFront();
        }
        else drap.toBack();
        if (discover){
            drap.toBack();
            value.toFront();
        }
    }

    @Override
    public void update(int n) {
        System.out.println(n);
        Text nb = new Text(Integer.toString(n));
        
    }

    @Override
    public void update(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
