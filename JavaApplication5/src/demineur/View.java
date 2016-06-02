/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Line;

/**
 *
 * @author p1307887
 */
public class View extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);        
        Plateau plateau = new Plateau();
        
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
            10d, 10d,
            25d, 15d,
            10d, 20d
        );
        Line baton = new Line();
        baton.setStartX(10);
        baton.setStartY(20);
        baton.setEndX(10);
        baton.setEndY(35);
        root.getChildren().add(baton);
        root.getChildren().add(triangle);
        //root.getChildren().add(plateau);//on l'ajoute à notre groupe root
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
