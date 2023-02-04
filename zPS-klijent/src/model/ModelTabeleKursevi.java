/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Kurs;
import domen.Predavac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class ModelTabeleKursevi extends AbstractTableModel {

    List<AbstractObjekat> lista = new ArrayList<>();
    String[] kolone = {"Naziv","Broj časova","Opis","Tip kursa"};

    public ModelTabeleKursevi() {
    }

    public ModelTabeleKursevi(List<AbstractObjekat> lista) {
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
       Kurs k = (Kurs) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getNaziv();
            case 1:
                return String.valueOf(k.getBrojCasova());
            case 2:
                return k.getOpis();
            case 3:
                return k.getTipKursa();
      
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

