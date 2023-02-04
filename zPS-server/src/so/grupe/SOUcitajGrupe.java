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
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author hp
 */
public class SOUcitajGrupe extends AbstractSO {

    private List<AbstractObjekat> listaGrupa;
    private List<AbstractObjekat> listaSvihGrupa;

    public SOUcitajGrupe() { //ucitajListuGrupa
        listaGrupa = new ArrayList<>();
        listaSvihGrupa = new ArrayList<>();
    }

    public List<AbstractObjekat> getLista() {
        return listaGrupa;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaSvihGrupa = dbb.vratiSveObjekte(new Grupa());
        System.out.println(listaSvihGrupa.size());
        ucitajDetalje();
 
        for (AbstractObjekat abstractObjekat : listaSvihGrupa) {
            Grupa grupa= (Grupa) abstractObjekat;
            System.out.println(grupa);
            listaGrupa.add(grupa);
        }
    }

     private void ucitajDetalje() throws ServerskiException {
   

        for (AbstractObjekat gru : listaSvihGrupa) {
            Grupa grupa = (Grupa) gru;

            Kurs kurs=(Kurs) dbb.vratiObjekatPoKljucu(new Kurs(), grupa.getKurs().getKursID());
          
            Menadzer menadzer = (Menadzer) dbb.vratiObjekatPoKljucu(new Menadzer(), grupa.getMenadzer().getMenadzerID());

            grupa.setKurs(kurs);
            grupa.setMenadzer(menadzer);
           
            
           List<AbstractObjekat> listaPredavaca = dbb.ucitajPredavacePoIDGrupe(grupa.getGrupaID());
           grupa.setListaPredavaca(listaPredavaca);
             
           List<AbstractObjekat> listaUcesnika=dbb.ucitajUcesnikePoIDGrupe(grupa.getGrupaID());
          grupa.setListaUcesnika(listaUcesnika);
           
        }
    }
     
  
}

