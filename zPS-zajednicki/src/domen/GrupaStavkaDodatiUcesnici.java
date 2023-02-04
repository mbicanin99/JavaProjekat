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
public class GrupaStavkaDodatiUcesnici extends AbstractObjekat{
    
    private int sifraStavke;
    private Grupa grupa;
    private Ucesnik ucesnik; 
    private String stanje; //obrisana

    public GrupaStavkaDodatiUcesnici() {
    }

    public GrupaStavkaDodatiUcesnici(int sifraStavke, Grupa grupa, Ucesnik ucesnik) {
        this.sifraStavke = sifraStavke;
        this.grupa = grupa;
        this.ucesnik = ucesnik;
 
    }

    public int getSifraStavke() {
        return sifraStavke;
    }

    public void setSifraStavke(int sifraStavke) {
        this.sifraStavke = sifraStavke;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Ucesnik getUcesnik() {
        return ucesnik;
    }

    public void setUcesnik(Ucesnik ucesnik) {
        this.ucesnik = ucesnik;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }
    
    
    @Override
    public String vratiImeTabele() {
        return "grupastavkadodatiucesnici";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", sifraStavke,grupa.getGrupaID(), ucesnik.getUcesnikID());
    }

    @Override
    public String vratiPK() {
       return null;
    }

    @Override
    public int vratiVrednostPK() {
        return 0;
    }

    @Override
    public String vratiSlozenPK() {
          return String.format("sifraStavke='%s' AND grupaID='%s'",  sifraStavke,grupa.getGrupaID());
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
             List<AbstractObjekat> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                int sifraStavke = rs.getInt("sifraStavke");
                int grupaID = rs.getInt("grupaID");
                int ucesnikID = rs.getInt("ucesnikID");
                Grupa grupa = new Grupa(grupaID);
                Ucesnik ucesnik=new Ucesnik(ucesnikID);
                
                stavke.add(new GrupaStavkaDodatiUcesnici(sifraStavke, grupa, ucesnik));
            }
        } catch (SQLException ex) {
            System.out.println("Greska kod RSuTabelu za GrupaUcesnici");
        }
        return stavke;
    }
    

    @Override
    public String vratiUpdate() {
       return String.format("sifraStavke='%s',grupaID='%s', ucesnikID='%s'", sifraStavke,grupa.getGrupaID(), ucesnik.getUcesnikID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final GrupaStavkaDodatiUcesnici other = (GrupaStavkaDodatiUcesnici) obj;
        if (this.sifraStavke != other.sifraStavke) {
            return false;
        }
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
        
        return true;
    }
    
    
    
    
    
}
