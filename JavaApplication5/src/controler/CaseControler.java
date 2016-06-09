/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private int action;

    public CaseControler(CaseModel caseModel) {
        this.caseModel = caseModel;
        
    }
    
    public void addFlag(){
        

        if (flagged==false){
            this.flagged=true;
            
            }
        else {
            this.flagged=false;
        }
        this.caseModel.setFlagged(flagged);
        System.out.println(flagged);
    }
    
    public void control(){
        
        
    }
    
}
