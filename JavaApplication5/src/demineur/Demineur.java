
package demineur;

import controler.Controler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.layout.BorderPane;
import model.Observer;
import view.HighPanel;
import view.Menu;
import view.Plateau;

/**
 *
 * @author p1307887
 */
public class Demineur extends Application implements Observer{
    
    private int size = 10;
    private int bombNumber = 5;
    private Controler controler;
    private Plateau plateau;
    private Scene scene;    
    private Stage stage;
    private BorderPane border = new BorderPane();
    private HighPanel high;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        this.menu();   
    }
    
    public void menu(){
        Group root = new Group();
        Menu menu = new Menu(this);
        root.getChildren().add(menu);
        Scene sceneMenu = new Scene(root,400,400);
        stage.setScene(sceneMenu);
        stage.show();
    }
    
    public void game(int size, int bombNumber){
        System.out.println("game");
        stage.close();
        this.stage = new Stage();
        controler = new Controler(size, bombNumber);
        plateau = new Plateau(controler,size);
        BorderPane border = new BorderPane();
        this.stage=stage;
        this.controler.addObserver(this);
        this.high = new HighPanel(controler);
        border.setTop(high);
        border.setCenter(plateau);
        scene = new Scene(border,600,700, Color.LIGHTBLUE);
        this.stage.setResizable(false);
        this.stage.sizeToScene(); 
        this.stage.setTitle("D-mineur");
        this.stage.setScene(scene );
        this.stage.show();
    }

    public void update(int n, int m) {
            System.out.println("game1");
            this.game(n, m);    
    }

    public static void main(String[] args) {
        launch(args);
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
        
        high.fail(fail);
    }

    @Override
    public void update(int n, int m, int h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
