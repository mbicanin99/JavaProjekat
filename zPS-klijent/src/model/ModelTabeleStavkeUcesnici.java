/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.GrupaStavkaDodatiPredavaci;
import domen.GrupaStavkaDodatiUcesnici;

import domen.Ucesnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class ModelTabeleStavkeUcesnici extends AbstractTableModel{
    
    List<AbstractObjekat> lista = new ArrayList<>();
     List<AbstractObjekat> originalnaLista = new ArrayList<>();
    JTextField txtIznos;
    
    
     String[] kolone = {"RB","Ime", "Prezime", "JMBG","Broj Telefona","Email"};

    public ModelTabeleStavkeUcesnici() {
    }

    public ModelTabeleStavkeUcesnici(List<AbstractObjekat> lista) {
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
        GrupaStavkaDodatiUcesnici sn = (GrupaStavkaDodatiUcesnici) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sn.getSifraStavke();
            case 1:
                return sn.getUcesnik().getIme();
            case 2:
                return sn.getUcesnik().getPrezime();
            case 3:
                return sn.getUcesnik().getJMBG();
            case 4:
                return sn.getUcesnik().getBrojTelefona();
            case 5:
                return sn.getUcesnik().getEmail();
            default:
                return "-";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
  

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            return true;
        }
        return false;
    }
    
    
    public void dodajStavku(Ucesnik ucesnik, Grupa grupa) {
         GrupaStavkaDodatiUcesnici stavka = daLiPostoji(ucesnik);
        
         //   stavka = new GrupaStavkaDodatiPredavaci(lista.size() + 1,grupa, predavac);
         //   lista.add(stavka);
            
          if (stavka != null) {
              System.out.println("Ucesnik postoji");
            
        } else {
           stavka = new GrupaStavkaDodatiUcesnici(lista.size() + 1,grupa,ucesnik);
           lista.add(stavka);
        }
      
        fireTableDataChanged();
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

    
   

    private GrupaStavkaDodatiUcesnici daLiPostoji(Ucesnik u) {
        for (AbstractObjekat abstractObjekat : lista) {
           GrupaStavkaDodatiUcesnici sn = (GrupaStavkaDodatiUcesnici) abstractObjekat;
            if (sn.getUcesnik().equals(u)) {
                return sn;
            }
        }
        return null;
    }

    public void izbaciStavku(int red) {

        lista.remove(red);
        fireTableDataChanged();
        
    }

    public void postaviRB() {

          int rb = 1;
        for (AbstractObjekat abstractObjekat : lista) {
            GrupaStavkaDodatiUcesnici sp = (GrupaStavkaDodatiUcesnici) abstractObjekat;
            sp.setSifraStavke(rb);
            rb++;
        }
        fireTableDataChanged();
        
    
    }
     public void setTxtIznos(JTextField txtIznos) {
        this.txtIznos = txtIznos;
    }

     
    public void setLista(List<AbstractObjekat> lista) {
        this.lista = lista;
    }

     public void popuniOriginalnuListu(List<AbstractObjekat> lista) {
        for (AbstractObjekat abstractObjekat : lista) {
            GrupaStavkaDodatiUcesnici sn = (GrupaStavkaDodatiUcesnici) abstractObjekat;
            originalnaLista.add(abstractObjekat);
        }
    }

    public List<AbstractObjekat> getOriginalnaLista() {
        return originalnaLista;
    }
    
    
     
     
     
}

