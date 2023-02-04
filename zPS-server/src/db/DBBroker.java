/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import domen.AbstractObjekat;
import domen.GrupaStavkaDodatiPredavaci;
import domen.GrupaStavkaDodatiUcesnici;
import domen.Kurs;
import domen.Predavac;
import domen.Ucesnik;



import exception.ServerskiException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andjelka
 */
public class DBBroker {

    private Connection konekcija;

    public DBBroker() {
    }

    public void uspostaviKonekciju() throws ServerskiException {
        try {
            Class.forName(Util.getInstance().getDriver());
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);
            System.out.println("Uspesna konekcija sa bazom!");
        } catch (IOException ex) {
            throw new ServerskiException("Greska kod citanja iz properties fajla!");
        } catch (ClassNotFoundException ex) {
            throw new ServerskiException("Drajver nije pronadjen!");
        } catch (SQLException ex) {
            throw new ServerskiException("Konekcija na bazu neuspesna!");
        }
    }

    public void raskiniKonekciju() throws ServerskiException {
        try {
            konekcija.close();
            System.out.println("Konekcija uspesno raskinuta");
        } catch (SQLException ex) {
            throw new ServerskiException("Raskidanje konekcije neuspesno!");
        }
    }

    public void potvrdiTransakciju() throws ServerskiException {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            throw new ServerskiException("Transakcija nije uspesno potvrdjena");
        }
    }

    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            System.out.println("Nije uspelo ponistavanje transakcije");
        }
    }

     public List<AbstractObjekat> vratiSveObjekte(AbstractObjekat o) throws ServerskiException {
        try {
            String upit = "SELECT * FROM " + o.vratiImeTabele();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<AbstractObjekat> listaObjekata = o.RSuTabelu(rs);
            s.close();
            System.out.println("Uspesno izvrsen SELECT");
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da prikaze podatke o " + o.getClass().getName() + ".");
        }
    }
   

     
        public AbstractObjekat obrisiObjekat(AbstractObjekat o) throws ServerskiException {
        try {
            String upit = String.format("DELETE FROM %s WHERE %s = %s", o.vratiImeTabele(), o.vratiPK(), o.vratiVrednostPK());
            Statement s = konekcija.createStatement();
            System.out.println(upit);
            s.executeUpdate(upit);
            potvrdiTransakciju();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
        return o;
    }
        
             public AbstractObjekat obrisiStavku(GrupaStavkaDodatiPredavaci o) throws ServerskiException {
        try {
            String upit = "DELETE FROM grupastavkadodatipredavaci WHERE "+o.vratiSlozenPK();
            Statement s = konekcija.createStatement();
            System.out.println(upit);
            s.executeUpdate(upit);
            potvrdiTransakciju();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
        return o;
    }
             
             
             public AbstractObjekat obrisiStavku(GrupaStavkaDodatiUcesnici o) throws ServerskiException {
        try {
            String upit = "DELETE FROM grupastavkadodatiucesnici WHERE "+o.vratiSlozenPK();
            Statement s = konekcija.createStatement();
            System.out.println(upit);
            s.executeUpdate(upit);
            potvrdiTransakciju();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
        return o;
    }
  
        
        public AbstractObjekat sacuvajObjekat(AbstractObjekat o) throws ServerskiException {
        try {

            String upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());
            System.out.println("Upit:\n" + upit);

            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
            while (rs.next()) {
                int lastid = rs.getInt("last_id"); //pazi za string 
                o.postaviVrednostPK(lastid);
                break;
            }
            s.close();
            return o;
        } catch (MySQLIntegrityConstraintViolationException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            if (o.vratiImeTabele().equals("ucesnik")) {
                throw new ServerskiException("Već postoji ucesnik sa unetim IDem!");
            }
            else if(o.vratiImeTabele().equals("predavac")){
            throw new ServerskiException("Već postoji predavac sa unetim IDem!");
            }
            else if(o.vratiImeTabele().equals("kurs")){
             throw new ServerskiException("Već postoji kurs sa unetim IDem!");
            }
            else if(o.vratiImeTabele().equals("grupa")){
             throw new ServerskiException("Već postoji grupa sa unetim IDem!");
            }
            else if(o.vratiImeTabele().equals("grupastavkadodatipredavaci")){
             throw new ServerskiException("Već postoji grupa sa unetim IDem!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
 
           
              public AbstractObjekat izmeniObjekat(AbstractObjekat o) throws ServerskiException {
        try {
            String upit;
            if (o.vratiPK() != null) {
                upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiPK(), o.vratiVrednostPK());
            } else {
                upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiSlozenPK());
            }
            System.out.println("Upit:\n" + upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
           
            s.close();
            return o;
        } catch (SQLException ex) {
           
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
              
                   public List<AbstractObjekat> ucitajUcesnike(AbstractObjekat o) throws ServerskiException {
        try {
           
            String upit = "SELECT * FROM ucesnik ORDER by ime";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            List<AbstractObjekat> listaObjekata = o.RSuTabelu(rs);
            for (AbstractObjekat ao : listaObjekata) {
                Ucesnik u = (Ucesnik) ao;
            }
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException(ex.getMessage());
        }
    }
              
              
              public List<AbstractObjekat> ucitajPredavace(AbstractObjekat o) throws ServerskiException {
        try {
           
            String upit = "SELECT * FROM predavac ORDER by ime";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            List<AbstractObjekat> listaObjekata = o.RSuTabelu(rs);
            for (AbstractObjekat ao : listaObjekata) {
                Predavac p = (Predavac) ao;
            }
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException(ex.getMessage());
        }
    }
              
                  
              public List<AbstractObjekat> ucitajKurseve(AbstractObjekat o) throws ServerskiException {
        try {
           
            String upit = "SELECT * FROM kurs ORDER by naziv";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            List<AbstractObjekat> listaObjekata = o.RSuTabelu(rs);
            for (AbstractObjekat ao : listaObjekata) {
                Kurs k = (Kurs) ao;
            }
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException(ex.getMessage());
        }
    }
            
                    
              
         public AbstractObjekat sacuvajIliAzurirajObjekatPredavaca(AbstractObjekat o) throws ServerskiException {
        try {
            List<AbstractObjekat> lista = vratiSveObjekte(o);
            String upit;
            String tipUpita;
            boolean postoji = false;
            for (AbstractObjekat ao : lista) {
               GrupaStavkaDodatiPredavaci sn = (GrupaStavkaDodatiPredavaci) ao;
               GrupaStavkaDodatiPredavaci sn1 = (GrupaStavkaDodatiPredavaci) o;
               if(sn.getGrupa().getGrupaID()==sn1.getGrupa().getGrupaID() && sn.getSifraStavke()==sn1.getSifraStavke()){
                   postoji = true;
               }
            }
            if (postoji) {
                tipUpita = "UPDATE";
                if (o.vratiPK() != null) {
                    upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiPK(), o.vratiVrednostPK());
                } else {
                    upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiSlozenPK());
                }
            } else {
                tipUpita = "INSERT";
                upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            if (tipUpita.equals("INSERT")) {
                ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
                while (rs.next()) {
                    int lastid = rs.getInt("last_id");
                    System.out.println(lastid);
                    o.postaviVrednostPK(lastid);
                    break;
                }
            }
            
            s.close();
            return o;
        } catch (SQLException ex) {
            
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
    }
         
         public AbstractObjekat sacuvajIliAzurirajObjekatUcesnik(AbstractObjekat o) throws ServerskiException {
        try {
            List<AbstractObjekat> lista = vratiSveObjekte(o);
            String upit;
            String tipUpita;
            boolean postoji = false;
            for (AbstractObjekat ao : lista) {
               GrupaStavkaDodatiUcesnici sn = (GrupaStavkaDodatiUcesnici) ao;
               GrupaStavkaDodatiUcesnici sn1 = (GrupaStavkaDodatiUcesnici) o;
               if(sn.getGrupa().getGrupaID()==sn1.getGrupa().getGrupaID() && sn.getSifraStavke()==sn1.getSifraStavke()){
                   postoji = true;
               }
            }
            if (postoji) {
                tipUpita = "UPDATE";
                if (o.vratiPK() != null) {
                    upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiPK(), o.vratiVrednostPK());
                } else {
                    upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiSlozenPK());
                }
            } else {
                tipUpita = "INSERT";
                upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            if (tipUpita.equals("INSERT")) {
                ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
                while (rs.next()) {
                    int lastid = rs.getInt("last_id");
                    System.out.println(lastid);
                    o.postaviVrednostPK(lastid);
                    break;
                }
            }
           
            s.close();
            return o;
        } catch (SQLException ex) {
           
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
    }
      
        public AbstractObjekat vratiObjekatPoKljucu(AbstractObjekat o, int ID) throws ServerskiException { //ucitajStavke
            System.out.println("Usao u sam u vartiObjekatPoKljucu");
        String upit;
        if (o.vratiPK() != null) {
            System.out.println("Usao u sam u prvi if i tabela je "+o.vratiImeTabele()+"a pk je   "+o.vratiPK());
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "=" + ID;
        } else {
             System.out.println("Usao u sam u else za tabelu:"+o.vratiImeTabele()+"gde je slozen kljuc"+"   "+o.vratiSlozenPK());
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiSlozenPK();
        }
        try (Statement s = konekcija.createStatement();) {
              System.out.println("Usao sam u try catch blok");
            ResultSet rs = s.executeQuery(upit); 
            System.out.println("Ucitao sam resultSet");
            
            List<AbstractObjekat> listaObjekata = o.RSuTabelu(rs);
              System.out.println("Result sam pretvorio u listu");
            s.close();
             System.out.println("Zatvorio sam soket");
            return listaObjekata.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
    }

    public List<AbstractObjekat> ucitajPredavacePoIDGrupe(int grupaID) throws ServerskiException { //ucitajStavke
            try {
            GrupaStavkaDodatiPredavaci sta = new GrupaStavkaDodatiPredavaci();
            String upit = "SELECT * FROM grupastavkadodatipredavaci where grupaID = '" + grupaID + "'";
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            List<AbstractObjekat> listaPredavaca = sta.RSuTabelu(rs);
            for (AbstractObjekat ao : listaPredavaca) {
                GrupaStavkaDodatiPredavaci sn = (GrupaStavkaDodatiPredavaci) ao;
                System.out.println("PredavacID" +sn.getPredavac().getPredavacID());
                Predavac predavac = (Predavac) vratiObjekatPoKljucu(new Predavac(), sn.getPredavac().getPredavacID());
                
                sn.setPredavac(predavac);
            }
            
            
            s.close();
            return listaPredavaca;
        } catch (SQLException ex) {
            throw new ServerskiException(ex.getMessage());
        }


    }

    public List<AbstractObjekat> ucitajUcesnikePoIDGrupe(int grupaID) throws ServerskiException {
      try {
           System.out.println("Usao sam u ucitajUcesnikePoIdGrupe");
            GrupaStavkaDodatiUcesnici sta = new GrupaStavkaDodatiUcesnici();
            String upit = "SELECT * FROM grupastavkadodatiucesnici where grupaID = '" + grupaID + "'";
            
            
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            System.out.println("Izvrsio sam upit"); 
            
            List<AbstractObjekat> listaUcesnika = sta.RSuTabelu(rs);
            //GrupaStavkaDodatiUcesnici  m=new GrupaStavkaDodatiUcesnici(); //DODATO
           // System.out.println("UcesnikID OVDE JE PROBLEM " +m.getUcesnik().getUcesnikID()); //DODATO
                
                
            for (AbstractObjekat ao : listaUcesnika) {
                GrupaStavkaDodatiUcesnici n = (GrupaStavkaDodatiUcesnici) ao;
                Ucesnik ucesnikk = (Ucesnik) vratiObjekatPoKljucu(new Ucesnik(),n.getUcesnik().getUcesnikID());
                n.setUcesnik(ucesnikk);
            }
            s.close();
            return listaUcesnika;
        } catch (SQLException ex) {
            throw new ServerskiException(ex.getMessage());
        }
    }
    
           
 
     
}
