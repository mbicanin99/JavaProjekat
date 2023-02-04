/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predavaci;

import so.ucesnici.*;
import domen.AbstractObjekat;
import domen.Predavac;
import domen.Ucesnik;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOPretraziPredavace extends AbstractSO {

    List<AbstractObjekat> lista = new ArrayList<>();
    String ime;

    public SOPretraziPredavace(String ime) {
        this.ime = ime;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> predavaci = dbb.ucitajPredavace(new Predavac());
        if (ime.equals("")) {
            lista.addAll(predavaci);
        } else {
            for (AbstractObjekat ao : predavaci) {
                Predavac p= (Predavac) ao;
                if (p.getIme().equals(ime)) {
                    lista.add(p);
                }
            }
        }
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }
}
