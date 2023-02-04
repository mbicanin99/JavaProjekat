/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grupe;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.Kurs;
import domen.Menadzer;
import domen.Predavac;
import domen.Ucesnik;
import exception.ServerskiException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author hp
 */
public class SOPretraziGrupe extends AbstractSO {

    private String naziv;
     private List<AbstractObjekat> listaNadjenih;

    public SOPretraziGrupe(String naziv) {
        this.naziv = naziv;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<AbstractObjekat> izBaze = dbb.vratiSveObjekte(new Grupa());
      
        listaNadjenih = new ArrayList<>();
   
        
        
        for (AbstractObjekat abstractObjekat : izBaze) {
            Grupa grupa = (Grupa) abstractObjekat;
            String nazivIzBaze = grupa.getNaziv().trim();
            if (nazivIzBaze.equals(naziv)) {
                
                Kurs kurs = (Kurs) dbb.vratiObjekatPoKljucu(new Kurs(), grupa.getKurs().getKursID());
                
                Menadzer menadzer = (Menadzer) dbb.vratiObjekatPoKljucu(new Menadzer(), grupa.getMenadzer().getMenadzerID());

                grupa.setKurs(kurs);
                grupa.setMenadzer(menadzer);
              

                List<AbstractObjekat> listaPredavaca = dbb.ucitajPredavacePoIDGrupe(grupa.getGrupaID()); //stavka
                List<AbstractObjekat> listaUcesnika = dbb.ucitajUcesnikePoIDGrupe(grupa.getGrupaID()); //stavka
                grupa.setListaPredavaca(listaPredavaca);
                grupa.setListaUcesnika(listaUcesnika);

                listaNadjenih.add(grupa);
            }
        }
    }

    public List<AbstractObjekat> getListaNadjenih() {
        return listaNadjenih;
    }

}
