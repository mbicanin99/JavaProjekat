/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kursevi;

import domen.AbstractObjekat;
import domen.Kurs;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOUcitajKurseve extends AbstractSO {

    List<AbstractObjekat> lista;
    
 public SOUcitajKurseve() {
        lista=new ArrayList<>();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.ucitajKurseve(new Kurs());
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }
}
