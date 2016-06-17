
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
    HBox box = new HBox();
    Controler controler;
    
    public HighPanel(Controler controler){
        this.getChildren().add(background);
        Rectangle rectangle = new Rectangle(50,50, Color.DARKGREY);
        //box.getChildren().add(5, rectangle);
        //box.getChildren().add(rectangle);
        this.getChildren().add(box);
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
