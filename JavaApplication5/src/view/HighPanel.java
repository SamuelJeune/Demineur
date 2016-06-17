
package view;

import controler.Controler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Observer;

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
