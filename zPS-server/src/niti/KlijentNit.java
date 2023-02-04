/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.Kurs;
import domen.Menadzer;
import domen.Predavac;
import domen.Ucesnik;
import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Andjelka
 */
public class KlijentNit extends Thread {

    private Socket socket;
    private List<KlijentNit> klijenti;
    ObjectInputStream in;
    ObjectOutputStream out;
    AbstractObjekat korisnik;
    AbstractObjekat korisnikServer;

    public KlijentNit(Socket socket, List<KlijentNit> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;
    }

    @Override
    public void run() {
        System.out.println("Klijent nit pokrenuta.");
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("Cekam zahtev");
                KlijentskiZahtev kt = (KlijentskiZahtev) in.readUnshared();
                ServerskiOdgovor st = new ServerskiOdgovor();
                try {
                    int operacija = kt.getOperacija();
                    switch (operacija) {
                        case Operacije.LOGIN:
                            Menadzer men = (Menadzer) kt.getParametar();
                            korisnik = Kontroler.vratiInstancu().ulogujKorisnika(men);
                            st.setPodaci(korisnik);
                            break;
                        //ucesnici

                        case Operacije.SACUVAJ_UCESNIKA:
                            Ucesnik u = (Ucesnik) kt.getParametar();
                            AbstractObjekat dob = Kontroler.vratiInstancu().kreirajUcesnika(u);
                            st.setPodaci(dob);
                            break;

                        case Operacije.UCITAJ_UCESNIKE:
                            List<AbstractObjekat> listaUcesnika = Kontroler.vratiInstancu().vratiListuUcesnika();
                            st.setPodaci(listaUcesnika);
                            break;
                        case Operacije.PRETRAZI_UCESNIKE:
                            String ime = (String) kt.getParametar();
                            List<AbstractObjekat> listaD = Kontroler.vratiInstancu().pretraziUcesnike(ime);
                            st.setPodaci(listaD);
                            break;
                        case Operacije.OBRISI_UCESNIKA:
                            Ucesnik ucee = (Ucesnik) kt.getParametar();
                            Ucesnik uce1 = (Ucesnik) Kontroler.vratiInstancu().obrisiUcesnika(ucee);
                            st.setPodaci(uce1);
                            break;
                        case Operacije.IZMENI_UCESNIKA:
                            Ucesnik ucev = (Ucesnik) kt.getParametar();
                            AbstractObjekat ucev1 = Kontroler.vratiInstancu().izmeniUcesnika(ucev);
                            st.setPodaci(ucev1);
                            break;

                        //predavaci
                        case Operacije.SACUVAJ_PREDAVACA:
                            Predavac p = (Predavac) kt.getParametar();
                            AbstractObjekat p1 = Kontroler.vratiInstancu().kreirajPredavaca(p);
                            st.setPodaci(p1);
                            break;

                        case Operacije.UCITAJ_PREDAVACE:
                            List<AbstractObjekat> listaPredavaca = Kontroler.vratiInstancu().vratiListuPredavaca();
                            st.setPodaci(listaPredavaca);
                            break;
                        case Operacije.PRETRAZI_PREDAVACE:
                            String imeP = (String) kt.getParametar();
                            List<AbstractObjekat> listaP = Kontroler.vratiInstancu().pretraziPredavace(imeP);
                            st.setPodaci(listaP);
                            break;
                        case Operacije.OBRISI_PREDAVACA:
                            Predavac pree = (Predavac) kt.getParametar();
                            Predavac pree1 = (Predavac) Kontroler.vratiInstancu().obrisiPredavaca(pree);
                            st.setPodaci(pree1);
                            break;
                        case Operacije.IZMENI_PREDAVACA:
                            Predavac prev = (Predavac) kt.getParametar();
                            AbstractObjekat pv1 = Kontroler.vratiInstancu().izmeniPredavaca(prev);
                            st.setPodaci(pv1);
                            break;

                        //kursevi
                        case Operacije.SACUVAJ_KURS:
                            Kurs k = (Kurs) kt.getParametar();
                            AbstractObjekat k1 = Kontroler.vratiInstancu().kreirajKurs(k);
                            st.setPodaci(k1);
                            break;
                        case Operacije.UCITAJ_KURSEVE: //ovo vraca sve
                            List<AbstractObjekat> listaKurseva = Kontroler.vratiInstancu().vratiListuKurseva();
                            st.setPodaci(listaKurseva);
                            break;
                        case Operacije.PRETRAZI_KURSEVE: //ovo vraca samo neke
                            String naziv = (String) kt.getParametar();
                            List<AbstractObjekat> listaK = Kontroler.vratiInstancu().pretraziKurseve(naziv);
                            st.setPodaci(listaK);
                            break;
                        case Operacije.OBRISI_KURS:
                            Kurs kurss = (Kurs) kt.getParametar();
                            Kurs ku1 = (Kurs) Kontroler.vratiInstancu().obrisiKurs(kurss);
                            st.setPodaci(ku1);
                            break;
                        case Operacije.IZMENI_KURS:
                            Kurs kursss = (Kurs) kt.getParametar();
                            AbstractObjekat kursss1 = Kontroler.vratiInstancu().izmeniKurs(kursss);
                            st.setPodaci(kursss1);
                            break;
                        //grupe   
                        case Operacije.SACUVAJ_GRUPU:
                            Grupa g = (Grupa) kt.getParametar();
                            AbstractObjekat grupa = Kontroler.vratiInstancu().kreirajGrupu(g);
                            st.setPodaci(grupa);
                            break;

                        case Operacije.UCITAJ_GRUPE:
                            List<AbstractObjekat> listaGrupa = Kontroler.vratiInstancu().vratiListuGrupa();
                            st.setPodaci(listaGrupa);
                            break;
                        case Operacije.PRETRAZI_GRUPE:
                            String naziv2 = (String) kt.getParametar();
                            List<AbstractObjekat> listaG = Kontroler.vratiInstancu().pretraziGrupe(naziv2);
                            st.setPodaci(listaG);
                            break;

                        case Operacije.IZMENI_GRUPU:
                            Grupa grupaZaIzmenu = (Grupa) kt.getParametar();
                            AbstractObjekat ggg1 = Kontroler.vratiInstancu().izmeniGrupu(grupaZaIzmenu);
                            st.setPodaci(ggg1);
                            break;

                        case Operacije.IZLOGUJ_MENADZERA:
                            Menadzer menadzer = (Menadzer) kt.getParametar();
                            Kontroler.vratiInstancu().izlogujMenadzera(menadzer);
                            break;

                    }
                    st.setUspesnost(1);
                } catch (ServerskiException ex) {
                    st.setUspesnost(-1);
                    st.setException(ex);
                }
                out.writeUnshared(st);
            }
        } catch (SocketException ex) {
            try {
                System.out.println("Klijent se iskljucuje...");
                Kontroler.vratiInstancu().izlogujMenadzera(korisnik);
                in.close();
                out.close();
                socket.close();
                klijenti.remove(this);
            } catch (IOException ex1) {
                Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (ServerskiException ex1) {
                Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractObjekat getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(AbstractObjekat korisnik) {
        this.korisnik = korisnik;
    }

}
