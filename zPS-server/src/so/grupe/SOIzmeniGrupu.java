/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.grupe;

import domen.AbstractObjekat;
import domen.Grupa;
import domen.GrupaStavkaDodatiPredavaci;
import domen.GrupaStavkaDodatiUcesnici;
import exception.ServerskiException;
import so.AbstractSO;

/**
 *
 * @author hp
 */
public class SOIzmeniGrupu extends AbstractSO{
    AbstractObjekat param;
    AbstractObjekat grupa;

    public SOIzmeniGrupu(Grupa param) {
        this.param = param;
    }

    public AbstractObjekat getGrupa() {
        return grupa;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        grupa = dbb.izmeniObjekat(param); 
        Grupa gru = (Grupa) grupa;
        
        for (AbstractObjekat ao:  gru.getListaPredavaca()) {
            GrupaStavkaDodatiPredavaci predavac = (GrupaStavkaDodatiPredavaci) ao;
          predavac.setStanje("nije obrisana");
         System.out.println("Stanje predavaca "+predavac.getStanje());
            if(predavac.getPredavac()!=null && predavac.getStanje().equals("obrisana")){ //treba da pise obrisana  if(predavac.getPredavac()!=null && predavac.getStanje().equals("obrisana")){
                System.out.println("u if");
                dbb.obrisiStavku(predavac);
            }else{
                dbb.sacuvajIliAzurirajObjekatPredavaca(predavac);
            }
        }
        
          for (AbstractObjekat ao:  gru.getListaUcesnika()) {
              
            GrupaStavkaDodatiUcesnici ucesnik = (GrupaStavkaDodatiUcesnici) ao;
            
           ucesnik.setStanje(" nije obrisana");
          
            if(ucesnik.getUcesnik()!=null && ucesnik.getStanje().equals("obrisana")){ //if(ucesnik.getUcesnik()!=null && ucesnik.getStanje().equals("orbisana")){
                dbb.obrisiStavku(ucesnik);
            }else{
                dbb.sacuvajIliAzurirajObjekatUcesnik(ucesnik);
            }
        }
    }
}
