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
public class GrupaStavkaDodatiPredavaci extends AbstractObjekat{
    private int sifraStavke; //promenila int
    private Grupa grupa;
    private Predavac predavac; //nama treba ime predavaca i JMBG i to cemo da uzmemo u modelu kada postavljamo podatke
    //bitno je da zasada sve podatke o predavacu cuvamo ovde
    private String stanje; //aktivan, neaktivan
    //stanje nema u bazi znaci mozemo da dodamo i nesto sto nije u bazi

    public GrupaStavkaDodatiPredavaci() {
    }

    public GrupaStavkaDodatiPredavaci(int sifraStavke, Grupa grupa, Predavac predavac) {
        this.sifraStavke = sifraStavke;
        this.grupa = grupa;
        this.predavac = predavac;
    }

   

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public int getSifraStavke() {
        return sifraStavke;
    }

    public void setSifraStavke(int sifraStavke) {
        this.sifraStavke = sifraStavke;
    }

    public Predavac getPredavac() {
        return predavac;
    }

    public void setPredavac(Predavac predavac) {
        this.predavac = predavac;
    }

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    @Override
    public String vratiImeTabele() {
        return "grupastavkadodatipredavaci";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", sifraStavke,grupa.getGrupaID(), predavac.getPredavacID());
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
                int predavacID = rs.getInt("predavacID");
                Grupa grupa = new Grupa(grupaID);
                Predavac predavac = new Predavac(predavacID);
                
 
                
                stavke.add(new GrupaStavkaDodatiPredavaci(sifraStavke, grupa,predavac));
            }
        } catch (SQLException ex) {
            System.out.println("Greska kod RSuTabelu za GrupaPredavaci");
        }
        return stavke;
    }
    

    @Override
    public String vratiUpdate() {
       return String.format("sifraStavke='%s',grupaID='%s', predavacID='%s'", sifraStavke,grupa.getGrupaID(), predavac.getPredavacID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
    }
    
    
    
    //Da li ovde u RS treba da se vrati string ako hocemo naziv ili je ovde samo okvir tabele a onda kroz ono .getNaziv uzimamo samo naziv i upisujemo ga u tabelu

    @Override
    public int hashCode() {
        int hash = 3;
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
        final GrupaStavkaDodatiPredavaci other = (GrupaStavkaDodatiPredavaci) obj;
        if (this.sifraStavke != other.sifraStavke) {
            return false;
        }
        if (!Objects.equals(this.grupa, other.grupa)) {
            return false;
        }
       
        return true;
    }
    
    
    
    
}
