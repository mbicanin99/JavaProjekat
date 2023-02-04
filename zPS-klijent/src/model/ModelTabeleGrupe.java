/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Grupa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class ModelTabeleGrupe extends AbstractTableModel {

    List<AbstractObjekat> lista = new ArrayList<>();
    String[] kolone = {"Naziv grupe","Datum od","Kurs","Sifra kreatora grupe","Ime kreatora"};
   

    public ModelTabeleGrupe() {
    }

    public ModelTabeleGrupe(List<AbstractObjekat> lista) {
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
       SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
       Grupa g = (Grupa) lista.get(rowIndex);
       
        switch (columnIndex) {
            case 0:
                return g.getNaziv();
            case 1:
                return sdf.format(g.getDatumOd());
            case 2:
                return g.getKurs().getNaziv();
            case 3:
                return g.getMenadzer().getSifra().toString();//dodato toString()
            case 4:
                return g.getMenadzer().getIme().toString();
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


