/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Ucesnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andjelka
 */
public class ModelTabeleUcesnici extends AbstractTableModel {

    List<AbstractObjekat> lista = new ArrayList<>();
    String[] kolone = {"Ime","Prezime","JMBG","Broj telefona","Email"};

    public ModelTabeleUcesnici() {
    }

    public ModelTabeleUcesnici(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ucesnik u = (Ucesnik) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getIme();
            case 1:
                return u.getPrezime();
            case 2:
                return u.getJMBG();
            case 3:
                return u.getBrojTelefona();
            case 4:
                return u.getEmail();
                
            default:
                return " ";
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

    public void setLista(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

}
