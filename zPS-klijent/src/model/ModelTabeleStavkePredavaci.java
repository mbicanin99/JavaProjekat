/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.prism.paint.Gradient;
import domen.AbstractObjekat;
import domen.Grupa;
import domen.GrupaStavkaDodatiPredavaci;
import domen.Predavac;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class ModelTabeleStavkePredavaci extends AbstractTableModel{
    
    List<AbstractObjekat> lista = new ArrayList<>();
     List<AbstractObjekat> originalnaLista = new ArrayList<>();
    JTextField txtIznos;
    
    
     String[] kolone = {"RB","Ime", "Prezime", "JMBG","Broj Telefona","Email"};

    public ModelTabeleStavkePredavaci() {
    }

    public ModelTabeleStavkePredavaci(List<AbstractObjekat> lista) {
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
        GrupaStavkaDodatiPredavaci sn = (GrupaStavkaDodatiPredavaci) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sn.getSifraStavke();
            case 1:
                return sn.getPredavac().getIme();
            case 2:
                return sn.getPredavac().getPrezime();
            case 3:
                return sn.getPredavac().getJMBG();
            case 4:
                return sn.getPredavac().getBrojTelefona();
            case 5:
                return sn.getPredavac().getEmail();
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
    
    
    public void dodajStavku(Predavac predavac, Grupa grupa) {
        GrupaStavkaDodatiPredavaci stavka = daLiPostoji(predavac);
        
         //   stavka = new GrupaStavkaDodatiPredavaci(lista.size() + 1,grupa, predavac);
         //   lista.add(stavka);
            
          if (stavka != null) {
              
              System.out.println("Predavac postoji");
             
            
        } else {
           stavka = new GrupaStavkaDodatiPredavaci(lista.size() + 1,grupa,predavac);
           lista.add(stavka);
        }
      
        fireTableDataChanged();
    }

    public List<AbstractObjekat> getLista() {
        return lista;
    }

    
 

    private GrupaStavkaDodatiPredavaci daLiPostoji(Predavac p) {
        for (AbstractObjekat abstractObjekat : lista) {
           GrupaStavkaDodatiPredavaci sn = (GrupaStavkaDodatiPredavaci) abstractObjekat;
            if (sn.getPredavac().equals(p)) {
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
            GrupaStavkaDodatiPredavaci sp = (GrupaStavkaDodatiPredavaci) abstractObjekat;
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
            GrupaStavkaDodatiPredavaci sn = (GrupaStavkaDodatiPredavaci) abstractObjekat;
            originalnaLista.add(abstractObjekat);
        }
    }

    public List<AbstractObjekat> getOriginalnaLista() {
        return originalnaLista;
    }
    
    
     
     
     
}
