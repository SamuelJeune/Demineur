
package controler;

import model.CaseModel;

/**
 *
 * @author p1307887
 */

public class CaseControler {
    
    protected CaseModel caseModel;
    private int value;
    private boolean flagged=false;
    

    public CaseControler(CaseModel caseModel) {
        this.caseModel = caseModel;
        this.value=caseModel.getValue();
        
    }
    
    public void addFlag(){
        if (flagged==false){
            this.flagged=true;
            if (this.value==1000){
                
            }
            }
        else {
            this.flagged=false;
        }
        this.caseModel.setFlagged(flagged);
        System.out.println(flagged);
    }

    public void discover() {
        if (value==1000){
            
            caseModel.setDiscovered(true);
            fail();
        }
        else{
            caseModel.discovering();
        }
    }

    private void fail() {
        
        caseModel.fail();
    }   
}
