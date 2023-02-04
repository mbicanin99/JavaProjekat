/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ucesnici;

import domen.AbstractObjekat;
import exception.ServerskiException;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOSacuvajUcesnika extends AbstractSO{

    private AbstractObjekat param;
    private AbstractObjekat ucesnik;
    
    public SOSacuvajUcesnika(AbstractObjekat param){
        this.param=param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        ucesnik = dbb.sacuvajObjekat(param);
    }
    public AbstractObjekat getParam() {
        return param;
    }
    public void setParam(AbstractObjekat param) {
        this.param = param;
    }
    public AbstractObjekat getUcesnik() {
        return ucesnik;
    }

    
    
}
