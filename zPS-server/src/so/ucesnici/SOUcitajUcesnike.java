/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ucesnici;

import domen.AbstractObjekat;
import domen.Menadzer;
import domen.Ucesnik;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOUcitajUcesnike extends AbstractSO {
    
List<AbstractObjekat> lista;
    
     public SOUcitajUcesnike() {
        lista= new ArrayList<>();
    }

     public List<AbstractObjekat> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Ucesnik());
    }

   
}

//mozda je ovo trebalo da se zove SOUcitajListuUcesnika a ovo sto sam pisala da se iskorisi za combobox
//za listu ide ucitajSveObjekte
