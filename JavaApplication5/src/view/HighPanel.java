
package view;

import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author SAM
 */
public class HighPanel extends Parent{
    
    Rectangle background = new Rectangle(800,100,Color.GREY);
    HBox box = new HBox();
    
    public HighPanel(){
        this.getChildren().add(background);
        Rectangle rectangle = new Rectangle(50,50, Color.DARKGREY);
        //box.getChildren().add(5, rectangle);
        box.getChildren().add(rectangle);
        this.getChildren().add(box);
        
        
    }

}
