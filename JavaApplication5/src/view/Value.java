
package view;

import javafx.scene.Parent;
import javafx.scene.text.Text;

/**
 *
 * @author p1307887
 */
public class Value extends Parent{
    
    int value;
    
    public Value(int n){
        this.value=n;
        Text nb = new Text(Integer.toString(n));
        this.getChildren().add(nb);
    }
}
