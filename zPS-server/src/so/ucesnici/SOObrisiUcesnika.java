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
public class SOObrisiUcesnika extends AbstractSO{

    private AbstractObjekat param;
    private AbstractObjekat obrisan;
    public SOObrisiUcesnika(AbstractObjekat param) {
        this.param = param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        obrisan = dbb.obrisiObjekat(param);
       
    }

    public AbstractObjekat getObrisan() {
        return obrisan;
    }
    
}
