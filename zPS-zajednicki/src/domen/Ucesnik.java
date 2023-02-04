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
public class Ucesnik extends AbstractObjekat{

    private int ucesnikID;
    private String ime;
    private String prezime;
    private String JMBG;
    private String brojTelefona;    
    private String email;

    public Ucesnik() {
    }

    public Ucesnik(int ucesnikID, String ime, String prezime, String JMBG, String brojTelefona, String email) {
        this.ucesnikID = ucesnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.brojTelefona = brojTelefona;
        this.email = email;
    }
    
     Ucesnik(int ucesnikID) {
        this.ucesnikID=ucesnikID;
    }

  
        public int getUcesnikID() {
        return ucesnikID;
    }
        
        

    public void setUcesnikID(int ucesnikID) {
        this.ucesnikID = ucesnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    
      public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
/*
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
        final Ucesnik other = (Ucesnik) obj;
        if (this.ucesnikID != other.ucesnikID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.JMBG, other.JMBG)) {
            return false;
        }
        return true;
    }*/

 

    
    
    
    
    @Override
    public String vratiImeTabele() {
        return "ucesnik";
    }

    @Override
    public String vratiParametre() {
      return String.format("'%s', '%s', '%s','%s','%s','%s'", ucesnikID, ime, prezime,JMBG, brojTelefona,email);
    }

    @Override
    public String vratiPK() {
        return "ucesnikID";
    }

    @Override
    public int vratiVrednostPK() {
        return ucesnikID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObjekat> RSuTabelu(ResultSet rs) {
             
        List<AbstractObjekat> ucesnici = new ArrayList<>();
        try {
            while (rs.next()) {
                int ucesnikID = rs.getInt("ucesnikID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String JMBG=rs.getString("JMBG");
                String brojTelefona = rs.getString("brojTelefona");
                String email=rs.getString("email");

                Ucesnik ucesnik = new Ucesnik(ucesnikID, ime, prezime, JMBG, brojTelefona,email);
              
                ucesnici.add(ucesnik);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Greska kod RSuTabelu za Ucesnik");
        }
        return ucesnici;

    }

    @Override
    public String vratiUpdate() {
        return String.format("ucesnikID='%s', ime='%s',prezime='%s',JMBG='%s',brojTelefona='%s',email='%s'", ucesnikID, ime,prezime,JMBG,brojTelefona,email);
    }

    @Override
    public void postaviVrednostPK(int pk) {
          this.ucesnikID=pk;
    }

    @Override
    public String toString() {
        return " "+ime+" "+prezime;
    }

  

    
}
