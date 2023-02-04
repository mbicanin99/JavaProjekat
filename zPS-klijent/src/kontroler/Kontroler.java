/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.Kurs;
;
import domen.Menadzer;
import domen.Predavac;
import domen.Ucesnik;
import java.io.IOException;
import java.util.List;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;


/**
 *
 * @author Andjelka
 */
public class Kontroler {

    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kt = new KlijentskiZahtev();
        kt.setOperacija(operacija);
        kt.setParametar(parametar);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiOdgovor st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }
    
    //ova metoda prima operaciju i salje u posalji zahtev koja prima operaciju i parametar
    private Object posaljiZahtev(int operacija) throws Exception {
        return posaljiZahtev(operacija, null);
    }

     //u ovim metodama saljemo operaciju i primamo ogovor u vidu liste i objekta
     public AbstractObjekat ulogujKorisnika(String username,String sifra) throws Exception {
         Menadzer m = new Menadzer(-1, null, null, username,sifra, false);
         return (AbstractObjekat) posaljiZahtev(Operacije.LOGIN, m);
    }

     //ucesnik
    public AbstractObjekat sacuvajUcesnika(Ucesnik u) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_UCESNIKA, u);
    }

   public List<AbstractObjekat> ucitajUcesnike() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_UCESNIKE);
    }
   
   
     public AbstractObjekat izmeniUcesnika(Ucesnik izabraniUcesnik) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_UCESNIKA, izabraniUcesnik);
    }
   
     public AbstractObjekat obrisiUcesnika(Ucesnik izabraniUcesnik) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.OBRISI_UCESNIKA, izabraniUcesnik);
    }
     
     public List<AbstractObjekat> pretraziUcesnike(String ime) throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_UCESNIKE, ime);
    }
     
     //predavac
     
       public AbstractObjekat sacuvajPredavaca(Predavac p) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_PREDAVACA, p);
    }

   public List<AbstractObjekat> ucitajPredavace() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_PREDAVACE);
    }
   
   
     public AbstractObjekat izmeniPredavaca(Predavac izabraniPredavac) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_PREDAVACA, izabraniPredavac);
    }
   
     public AbstractObjekat obrisiPredavaca(Predavac izabraniPredavac) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.OBRISI_PREDAVACA, izabraniPredavac);
    }
     
     public List<AbstractObjekat> pretraziPredavace(String ime) throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_PREDAVACE, ime);
    }
     
     //kursevi
     
       
       public AbstractObjekat sacuvajKurs(Kurs k) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_KURS, k);
    }

   public List<AbstractObjekat> ucitajKurseve() throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_KURSEVE);
    }
   
   
     public AbstractObjekat izmeniKurs(Kurs izabraniKurs) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_KURS, izabraniKurs);
    }
   
     public AbstractObjekat obrisiKurs(Kurs izabraniKurs) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.OBRISI_KURS, izabraniKurs);
    }
     
     public List<AbstractObjekat> pretraziKurseve(String naziv) throws Exception {
        return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_KURSEVE, naziv);
    }

      public AbstractObjekat izlogujMenadzera(Menadzer menadzer) throws Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZLOGUJ_MENADZERA, menadzer);
    }
      
      
    
    
    public AbstractObjekat sacuvajGrupu(Grupa g) throws IOException, ClassNotFoundException, Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.SACUVAJ_GRUPU, g);
    }

     public List<AbstractObjekat> ucitajGrupe() throws Exception {
             return (List<AbstractObjekat>) posaljiZahtev(Operacije.UCITAJ_GRUPE);
    }

   
   
     public AbstractObjekat izmeniGrupu(Grupa izabranaGrupa) throws IOException, ClassNotFoundException, Exception {
        return (AbstractObjekat) posaljiZahtev(Operacije.IZMENI_GRUPU, izabranaGrupa);
    }
   
  
      public List<AbstractObjekat> pretraziGrupe(String naziv) throws Exception {
             return (List<AbstractObjekat>) posaljiZahtev(Operacije.PRETRAZI_GRUPE);
    }

      /*
    public List<String> ucitajNaziveKurseva() throws IOException, ClassNotFoundException, Exception {
      return (List<String>) posaljiZahtev(Operacije.UCITAJ_NAZIVE_KURSEVA);
    }*/
     
    
      
      
}
