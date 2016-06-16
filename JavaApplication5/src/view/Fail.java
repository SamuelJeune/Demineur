
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
    
    Rectangle finDeJeu = new Rectangle(200,200,Color.WHITE);
    Text nb = new Text("You Fail !!");
    StackPane stack = new StackPane(); 
    
    public Fail(){
        stack.getChildren().addAll(finDeJeu, nb);
        this.getChildren().add(stack);
    }
    
}
