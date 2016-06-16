/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import controler.Controler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.View;
import static javafx.application.Application.launch;
import model.Observer;

/**
 *
 * @author p1307887
 */
public class Demineur extends Application implements Observer{

    /**
     * @param args the command line arguments
     */
    private int size = 10;
    private int bombNumber = 5;
    private Controler controler = new Controler(size, bombNumber);
    
    
    public static void main(String[] args) {
        
        
        launch(args);
    }   

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        View view = new View(controler); 
        //BorderPane root = new BorderPane();
        //root.setCenter(view);
        root.getChildren().add(view);//on l'ajoute à notre groupe root
        Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(boolean fail) {
        
    }

    @Override
    public void update(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(boolean flag, boolean discover) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
