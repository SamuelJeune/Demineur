/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 *
 * @author p1307887
 */
public class Drapeau extends Parent{
    
    public Drapeau(){
        Image drapeau = new Image(Drapeau.class.getResourceAsStream("images/drapeau.png"));
        ImageView drapeauView = new ImageView(drapeau);
        drapeauView.setFitHeight(20);
        drapeauView.setPreserveRatio(true);
        this.getChildren().add(drapeauView);
    }
    
}
