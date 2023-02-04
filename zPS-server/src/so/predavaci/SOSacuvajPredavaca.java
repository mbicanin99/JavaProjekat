/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predavaci;

import so.ucesnici.*;
import domen.AbstractObjekat;
import exception.ServerskiException;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOSacuvajPredavaca extends AbstractSO{

    private AbstractObjekat param;
    private AbstractObjekat predavac;
    
    public SOSacuvajPredavaca(AbstractObjekat param){
        this.param=param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        predavac = dbb.sacuvajObjekat(param);
    }
    public AbstractObjekat getParam() {
        return param;
    }
    public void setParam(AbstractObjekat param) {
        this.param = param;
    }
    public AbstractObjekat getPredavac() {
        return predavac;
    }

    
    
}
