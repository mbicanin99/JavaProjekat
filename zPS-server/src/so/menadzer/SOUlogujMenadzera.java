/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.menadzer;

import domen.AbstractObjekat;
import domen.Menadzer;
import exception.ServerskiException;
import java.util.List;
import kontroler.Kontroler;
import so.AbstractSO;

/**
 *
 * @author Andjelka
 */
public class SOUlogujMenadzera extends AbstractSO {

    private AbstractObjekat unetiParametri;
    private AbstractObjekat ulogovanKorisnik;

   
       @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> listaMenadzera = dbb.vratiSveObjekte(new Menadzer());
        Menadzer unetiMenadzer = (Menadzer) unetiParametri;
        for (AbstractObjekat abstractObjekat : listaMenadzera) {

            Menadzer menadzerIzBaze = (Menadzer) abstractObjekat;
            
          
                if (menadzerIzBaze.getUsername().equals(unetiMenadzer.getUsername())&&menadzerIzBaze.getSifra().equals(unetiMenadzer.getSifra())) {
                    ulogovanKorisnik = menadzerIzBaze;
                    int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(menadzerIzBaze);
                    Menadzer izListe = (Menadzer) Kontroler.vratiInstancu().getListaKorisnika().get(indeks);
                   /* if (izListe.isUlogovan()) {
                        throw new ServerskiException("Menadžer je vec ulogovan!");
                    } else {
                        izListe.setUlogovan(true);
                    }*/
                    System.out.println("Postavio menadžera da je ulogovan.");
                    return;
                }
                
            
        }
    throw new ServerskiException("Neuspesno prijavljivanje!");
    }

    public AbstractObjekat getUnetiParametri() {
        return unetiParametri;
    }

    public void setUnetiParametri(AbstractObjekat unetiParametri) {
        this.unetiParametri = unetiParametri;
    }

    public AbstractObjekat getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(AbstractObjekat ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

}
