/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kursevi;

import so.ucesnici.*;
import domen.AbstractObjekat;
import exception.ServerskiException;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOSacuvajKurs extends AbstractSO{

    private AbstractObjekat param;
    private AbstractObjekat kurs;
    
    public SOSacuvajKurs(AbstractObjekat param){
        this.param=param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        kurs = dbb.sacuvajObjekat(param);
    }
    public AbstractObjekat getParam() {
        return param;
    }
    public void setParam(AbstractObjekat param) {
        this.param = param;
    }
    public AbstractObjekat getKurs() {
        return kurs;
    }

    
    
}
