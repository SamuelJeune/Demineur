
package view;

import controler.Controler;
import javafx.scene.Parent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author p1307887
 */
public class Plateau extends Parent{
    
    private Case[][] c;
    
    public Plateau(Controler controler, int size) {
        

        GridPane grid = new GridPane();
        c = new Case[size][size];
        for (int i=0; i<size; i++){
            for(int j=0; j<size;j++){
                Case ca = new Case(i,j,  controler, size);
                GridPane.setConstraints(ca, i, j);
                grid.getChildren().add(ca);
                grid.getColumnConstraints().add(new ColumnConstraints(600/size));
                grid.getRowConstraints().add(new RowConstraints(600/size));
            }
        }        
        this.getChildren().add(grid);      
    }
}
