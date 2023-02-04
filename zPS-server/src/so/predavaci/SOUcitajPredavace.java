/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predavaci;

import domen.AbstractObjekat;
import domen.Predavac;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOUcitajPredavace extends AbstractSO {

    List<AbstractObjekat> lista;

 
    public SOUcitajPredavace() {
        lista=new ArrayList<>();
    }
    
     public List<AbstractObjekat> getLista() {
        return lista;
    }
    

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Predavac());
        
    }

   
}
