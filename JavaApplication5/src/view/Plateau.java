/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.Controler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author p1307887
 */
public class Plateau extends Parent{
    
    private Case[][] c;
    
    public Plateau(Controler controler) {
        /*Rectangle fond_plateau = new Rectangle();
        fond_plateau.setWidth(260);
        fond_plateau.setHeight(260);
        fond_plateau.setArcWidth(30);
        fond_plateau.setArcHeight(30);
        fond_plateau.setFill( //on remplie notre rectangle avec un dégradé
            new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                new Stop[] {
                    new Stop(0, Color.web("#333333")),
                    new Stop(1, Color.web("#000000"))
                }
            )
        );
        Reflection r = new Reflection();//on applique un effet de réflection
        r.setFraction(0.25);
        r.setBottomOpacity(0);
        r.setTopOpacity(0.5);
        fond_plateau.setEffect(r);
        this.getChildren().add(fond_plateau);//on ajoute le rectangle au groupe
        */
        
        /*c = new Case[10][10];
        for (int i=0; i<10; i++){
            for(int j=0; j<10;j++){
                Case ca = new Case(i*25+7,j*25+7);
                this.getChildren().add(ca);
            }

        }
        */
        final GridPane grid = new GridPane();
        c = new Case[10][10];
        for (int i=0; i<10; i++){
            for(int j=0; j<10;j++){
                Case ca = new Case(i,j,  controler);
                GridPane.setConstraints(ca, i, j);
                grid.getChildren().add(ca);
                grid.getColumnConstraints().add(new ColumnConstraints(50));
                grid.getRowConstraints().add(new RowConstraints(50));
            }
        }
        
        this.getChildren().add(grid);
        
        
            
        /*GridPane.setConstraints(case, i, 1); 
        final GridPane root = new GridPane(); 
        // 
        root.getColumnConstraints().setAll( 
                new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),  
                new ColumnConstraints(75, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE)); 
        root.getColumnConstraints().get(0).setHgrow(Priority.ALWAYS); 
        root.getColumnConstraints().get(1).setHgrow(Priority.ALWAYS); 
        // 
        root.getRowConstraints().setAll( 
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),  
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE),  
                new RowConstraints(25, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE)); 
        root.getRowConstraints().get(0).setVgrow(Priority.NEVER); 
        root.getRowConstraints().get(1).setVgrow(Priority.NEVER); 
        root.getRowConstraints().get(2).setVgrow(Priority.ALWAYS); 
        // 
        root.getChildren().setAll(region, button, label);
        */
        
       


        
    }
}
