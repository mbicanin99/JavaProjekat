/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.Kurs;
import domen.Menadzer;
import domen.Predavac;
import domen.Ucesnik;

import exception.ServerskiException;
import java.util.List;
import so.grupe.SOIzmeniGrupu;
import so.grupe.SOPretraziGrupe;
import so.grupe.SOSacuvajGrupu;
import so.grupe.SOUcitajGrupe;
import so.kursevi.SOIzmeniKurs;
import so.kursevi.SOObrisiKurs;
import so.kursevi.SOPretraziKurseve;
import so.kursevi.SOSacuvajKurs;
import so.kursevi.SOUcitajKurseve;
import so.predavaci.SOIzmeniPredavaca;
import so.predavaci.SOObrisiPredavaca;
import so.predavaci.SOPretraziPredavace;
import so.predavaci.SOSacuvajPredavaca;
import so.predavaci.SOUcitajPredavace;
import so.menadzer.SOIzlogujMenadzera;
import so.menadzer.SOUcitajListuKorisnika;

import so.menadzer.SOUlogujMenadzera;

import so.ucesnici.SOIzmeniUcesnika;
import so.ucesnici.SOObrisiUcesnika;
import so.ucesnici.SOPretraziUcesnike;
import so.ucesnici.SOSacuvajUcesnika;
import so.ucesnici.SOUcitajUcesnike;

/**
 *
 * @author Andjelka
 */
public class Kontroler {

    private static Kontroler instanca;
    private List<AbstractObjekat> listaKorisnika;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<AbstractObjekat> getListaKorisnika() throws ServerskiException {
        if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    private List<AbstractObjekat> vratiListuKorisnika() throws ServerskiException {
        SOUcitajListuKorisnika souk = new SOUcitajListuKorisnika();
        souk.izvrsiOperaciju();
        return souk.getLista();

    }

    public AbstractObjekat ulogujKorisnika(Menadzer men) throws ServerskiException {
        SOUlogujMenadzera som = new SOUlogujMenadzera();
        som.setUnetiParametri(men);
        som.izvrsiOperaciju();
        return som.getUlogovanKorisnik();
    }
    
  

    public void izlogujMenadzera(AbstractObjekat menadzer) throws ServerskiException {
        SOIzlogujMenadzera soik = new SOIzlogujMenadzera(menadzer);
        soik.izvrsiOperaciju();
    }

    //ucesnik
    public AbstractObjekat kreirajUcesnika(Ucesnik u) throws ServerskiException {
        SOSacuvajUcesnika so = new SOSacuvajUcesnika(u);
        so.izvrsiOperaciju();
        return so.getUcesnik();
    }

    public List<AbstractObjekat> vratiListuUcesnika() throws ServerskiException {
        SOUcitajUcesnike soud = new SOUcitajUcesnike();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }

    public List<AbstractObjekat> pretraziUcesnike(String ime) throws ServerskiException {
        SOPretraziUcesnike sopd = new SOPretraziUcesnike(ime);
        sopd.izvrsiOperaciju();
        return sopd.getLista();
    }

    public AbstractObjekat izmeniUcesnika(Ucesnik u) throws ServerskiException {
        SOIzmeniUcesnika so = new SOIzmeniUcesnika(u);
        so.izvrsiOperaciju();
        return so.getUcesnik();
    }

    public AbstractObjekat obrisiUcesnika(Ucesnik u) throws ServerskiException {
        SOObrisiUcesnika soop = new SOObrisiUcesnika(u);
        soop.izvrsiOperaciju();
        return soop.getObrisan();
    }

    //dobavljac
    public AbstractObjekat kreirajPredavaca(Predavac p) throws ServerskiException {
        SOSacuvajPredavaca so = new SOSacuvajPredavaca(p);
        so.izvrsiOperaciju();
        return so.getPredavac();
    }

    public List<AbstractObjekat> vratiListuPredavaca() throws ServerskiException {
        SOUcitajPredavace soud = new SOUcitajPredavace();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }

    public List<AbstractObjekat> pretraziPredavace(String ime) throws ServerskiException {
        SOPretraziPredavace sopd = new SOPretraziPredavace(ime);
        sopd.izvrsiOperaciju();
        return sopd.getLista();
    }

    public AbstractObjekat izmeniPredavaca(Predavac p) throws ServerskiException {
        SOIzmeniPredavaca so = new SOIzmeniPredavaca(p);
        so.izvrsiOperaciju();
        return so.getPredavac();
    }

    public AbstractObjekat obrisiPredavaca(Predavac p) throws ServerskiException {
        SOObrisiPredavaca soop = new SOObrisiPredavaca(p);
        soop.izvrsiOperaciju();
        return soop.getObrisan();
    }

    //kursevi
    public AbstractObjekat kreirajKurs(Kurs k) throws ServerskiException {
        SOSacuvajKurs so = new SOSacuvajKurs(k);
        so.izvrsiOperaciju();
        return so.getKurs();
    }

    public List<AbstractObjekat> vratiListuKurseva() throws ServerskiException {
        SOUcitajKurseve soud = new SOUcitajKurseve();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }
    
       //dodato
      /*  public List<String> vratiListuNazivaKurseva() throws ServerskiException {
        SOUcitajNaziveKurseva soud = new SOUcitajNaziveKurseva();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }*/

    public List<AbstractObjekat> pretraziKurseve(String naziv) throws ServerskiException {
        SOPretraziKurseve sopd = new SOPretraziKurseve(naziv);
        sopd.izvrsiOperaciju();
        return sopd.getLista();
    }

    public AbstractObjekat izmeniKurs(Kurs k) throws ServerskiException {
        SOIzmeniKurs so = new SOIzmeniKurs(k);
        so.izvrsiOperaciju();
        return so.getKurs();
    }

    public AbstractObjekat obrisiKurs(Kurs k) throws ServerskiException {
        SOObrisiKurs soop = new SOObrisiKurs(k);
        soop.izvrsiOperaciju();
        return soop.getObrisan();
    }
    
       public AbstractObjekat kreirajGrupu(Grupa g) throws ServerskiException {
        SOSacuvajGrupu so = new SOSacuvajGrupu(g);
        so.izvrsiOperaciju();
        return so.getGrupa();
    }

    public List<AbstractObjekat> vratiListuGrupa() throws ServerskiException {
        SOUcitajGrupe soud = new SOUcitajGrupe();
        soud.izvrsiOperaciju();
        return soud.getLista();
    }

    public List<AbstractObjekat> pretraziGrupe(String naziv) throws ServerskiException {
        SOPretraziGrupe sopd = new SOPretraziGrupe(naziv);
        sopd.izvrsiOperaciju();
        return sopd.getListaNadjenih();
    }

    public AbstractObjekat izmeniGrupu(Grupa grupaZaIzmenu) throws ServerskiException {
        SOIzmeniGrupu so = new SOIzmeniGrupu(grupaZaIzmenu);
        so.izvrsiOperaciju();
        return so.getGrupa();
    }



}
