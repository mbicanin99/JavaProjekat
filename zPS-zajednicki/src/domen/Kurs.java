/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author hp
 */
public class Kurs extends AbstractObjekat{
    private int kursID;
    private String naziv;
    private int brojCasova;
    private String opis;
    private String tipKursa;

    public Kurs() {
    }

    public Kurs(int kursID, String naziv, int brojCasova, String opis,String tipKursa) {
        this.kursID = kursID;
        this.naziv= naziv;
        this.brojCasova = brojCasova;
        this.opis=opis;
        this.tipKursa = tipKursa;
    }

   

    public Kurs(int kursID) {
        this.kursID = kursID;
    }

   
    
    public int getKursID() {
        return kursID;
    }

    public void setKursID(int kursID) {
        this.kursID = kursID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipKursa() {
        return tipKursa;
    }

    public void setTipKursa(String tipKursa) {
        this.tipKursa = tipKursa;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Kurs other = (Kurs) obj;
        if (this.kursID != other.kursID) {
            return false;
        }
        if (this.brojCasova != other.brojCasova) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.tipKursa, other.tipKursa)) {
            return false;
        }
        return true;
    }

   
    
    @Override
    public String vratiImeTabele() {

        return "kurs";
    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s', '%s','%s','%s'", kursID, naziv,  brojCasova,opis, tipKursa);   
    }

    @Override
    public String vratiPK() {

        return "kursID";
    }

    @Override
    public int vratiVrednostPK() {

        return kursID;
    }

    @Override
    public String vratiSlozenPK() {

        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {

         
        List<AbstractObjekat> kursevi = new ArrayList<>();
        try {
            while (rs.next()) {
                int kursID = rs.getInt("kursID");
                String naziv = rs.getString("naziv");
                int brojCasova = rs.getInt("brojCasova");
                String opis=rs.getString("opis");
                String tipKursa = rs.getString("tipKursa");

                Kurs kurs = new Kurs(kursID, naziv,brojCasova, opis, tipKursa);
              
               kursevi.add(kurs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za kurseve");
        }
        return kursevi;
    }

    @Override
    public String vratiUpdate() {

       return String.format("kursID='%s', naziv='%s',brojCasova='%s',opis='%s',tipKursa='%s'", kursID, naziv,brojCasova,opis,tipKursa);

    }

    @Override
    public void postaviVrednostPK(int pk) {

        this.kursID = pk;
    }

 
}

