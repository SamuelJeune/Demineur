
package view;

import controler.Controler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author SAM
 */
public class HighPanel extends Parent{
    
    Rectangle background = new Rectangle(800,100,Color.GREY);
    
    Controler controler;
    
    public HighPanel(Controler controler){
        this.getChildren().add(background);
        TimerView tv = new TimerView();
        this.getChildren().add(tv);
        this.controler=controler;
        int size = controler.getSize();
        int bomb = controler.getBombNumber();
        Label sized = new Label("taille : "+ size);
        Label bombd = new Label("nombre de bombe :"+ bomb);
        this.getChildren().add(sized);
        this.getChildren().add(bombd);
        sized.setTranslateX(50);
        bombd.setTranslateX(400);
        sized.setTranslateY(50);
        bombd.setTranslateY(50);
        
        /*Button button = new Button();
        button.setText("Restart"); 
        this.getChildren().add(button);
        button.setTranslateX(50);
        
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });*/              
    }

    
    public void fail(boolean fail) {
       
        Fail failDisp = new Fail(fail);
        this.getChildren().add(failDisp);
        failDisp.setTranslateX(200);
        
    }


}
