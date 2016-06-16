
package controler;

import demineur.Demineur;
import java.util.ArrayList;
import model.Observable;
import model.Observer;

/**
 *
 * @author SAM
 */
public class MenuControler implements Observable {
    
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    
    public MenuControler(Demineur dem){
        this.listObserver.add(dem);
    }

    public void getText(String size, String bombNumber) {
        int n = Integer.parseInt(size);
        int m = Integer.parseInt(bombNumber);
        System.out.println(n);
        System.out.println(m);
        notifyObserver(n, m);
    }

    @Override
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);

    }

    @Override
    public void notifyObserver(boolean flag, boolean discover) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyObserver(boolean fail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notifyObserver(int n, int m) {
        for(Observer obs : listObserver)
              obs.update(n, m);
        System.out.println("menuc");
    }

    @Override
    public void removeObserver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
