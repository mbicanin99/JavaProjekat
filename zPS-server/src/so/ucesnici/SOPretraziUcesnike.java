/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ucesnici;

import domen.AbstractObjekat;
import domen.Ucesnik;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOPretraziUcesnike extends AbstractSO {

    List<AbstractObjekat> lista = new ArrayList<>();
    String ime;

    public SOPretraziUcesnike(String ime) {
        this.ime = ime;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> ucesnici = dbb.ucitajUcesnike(new Ucesnik());
        if (ime.equals("")) {
            lista.addAll(ucesnici);
        } else {
            for (AbstractObjekat ao : ucesnici) {
                Ucesnik u= (Ucesnik) ao;
                if (u.getIme().equals(ime)) {
                    lista.add(u);
                }
            }
        }
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }
}
