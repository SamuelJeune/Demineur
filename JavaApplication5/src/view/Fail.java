
package view;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author SAM
 */
public class Fail extends Parent{
    
    Rectangle finDeJeu = new Rectangle(200,100,Color.GREY);
    Text nb;
    StackPane stack = new StackPane(); 
    
    public Fail(boolean fail){
        if(fail){
            nb = new Text("You Fail !!");
        }
        else{
            
            nb = new Text("You WIn !!");
        }
        stack.getChildren().addAll(finDeJeu, nb);
        this.getChildren().add(stack);
    }
    
}
