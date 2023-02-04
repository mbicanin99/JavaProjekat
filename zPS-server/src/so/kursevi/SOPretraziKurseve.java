/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kursevi;

import so.ucesnici.*;
import domen.AbstractObjekat;
import domen.Kurs;
import domen.Ucesnik;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOPretraziKurseve extends AbstractSO {

    List<AbstractObjekat> lista = new ArrayList<>();
    String naziv;

    public SOPretraziKurseve(String naziv) {
        this.naziv = naziv;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> kursevi = dbb.ucitajKurseve(new Kurs());
        if (naziv.equals("")) {
            lista.addAll(kursevi);
        } else {
            for (AbstractObjekat ao : kursevi) {
                Kurs k= (Kurs) ao;
                if (k.getNaziv().equals(naziv)) {
                    lista.add(k);
                }
            }
        }
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }
}
