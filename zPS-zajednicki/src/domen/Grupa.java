/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author hp
 */
public class Grupa extends AbstractObjekat{
   
    private int grupaID;
    private String naziv;
    private Date datumOd;
    private List<AbstractObjekat> listaPredavaca;
    private List<AbstractObjekat> listaUcesnika;
    private Kurs kurs;
    private Menadzer menadzer;

    public Grupa() {
  
    }

    public Grupa(int grupaID, String naziv, Date datumOd, Kurs kurs,Menadzer menadzer) {
        this.grupaID = grupaID;
        this.naziv = naziv;
        this.datumOd = datumOd;
        this.listaPredavaca= new ArrayList<>();
        this.listaUcesnika = new ArrayList<>();
        this.kurs = kurs;
        this.menadzer=menadzer;
    }

    Grupa(int grupaID) {
       this.grupaID=grupaID;
    }
    
    
    
    public int getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(int grupaID) {
        this.grupaID = grupaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }


    public List<AbstractObjekat> getListaPredavaca() {
        return listaPredavaca;
    }

    public void setListaPredavaca(List<AbstractObjekat> listaPredavaca) {
        this.listaPredavaca = listaPredavaca;
    }

    public List<AbstractObjekat> getListaUcesnika() {
        return listaUcesnika;
    }

    public void setListaUcesnika(List<AbstractObjekat> listaUcesnika) {
        this.listaUcesnika = listaUcesnika;
    }
    
    
    
 



    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }
    
     public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    @Override
    public String toString() {
        return " "+naziv+" ";
    }

    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupa other = (Grupa) obj;
        if (!Objects.equals(this.grupaID, other.grupaID)) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    @Override
    public String vratiImeTabele() {
        return "grupa";
    }

    @Override
    public String vratiParametre() {
        java.sql.Date datumPocetka = new java.sql.Date(datumOd.getTime());
        return String.format("'%s', '%s', '%s','%s','%s'", grupaID,naziv, datumPocetka,kurs.getKursID(),menadzer.getMenadzerID());
    }

    @Override
    public String vratiPK() {
       return "grupaID";
    }

    @Override
    public int vratiVrednostPK() {
       return grupaID;
    }

    @Override
    public String vratiSlozenPK() {
      return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
          
       
         List<AbstractObjekat> grupe = new ArrayList<>();
        try {
            while (rs.next()) {
                int grupaID = rs.getInt("grupaID");
                String naziv=rs.getString("naziv");
                Date datumOd = rs.getDate("datumOd");
                int kursID=rs.getInt("kursID");
                int menadzerID = rs.getInt("menadzerID");
                
                Grupa grupa=new Grupa(grupaID,naziv,datumOd,new Kurs(kursID),new Menadzer(menadzerID));
                
         
                
                grupe.add(grupa);
                
            }
        } catch (SQLException ex) {
            System.out.println("Greska kod RSuTabelu za Grupa");
        }
        return grupe;
    }

    @Override
    public String vratiUpdate() {
       java.sql.Date datumSQL = new java.sql.Date(datumOd.getTime());
       return String.format("grupaID='%s', naziv='%s',datumOd='%s',kursID='%s',menadzerID='%s'", grupaID, naziv,datumSQL,kurs.getKursID(),menadzer.getMenadzerID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.grupaID=pk;
    }


}
