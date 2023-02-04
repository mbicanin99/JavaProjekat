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
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author hp
 */
public class SOSacuvajGrupu extends AbstractSO{
    AbstractObjekat param;
    AbstractObjekat grupa;

    public SOSacuvajGrupu(AbstractObjekat param) {
        this.param = param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        grupa = dbb.sacuvajObjekat(param);
        sacuvajPredavace();
        sacuvajUcesnike();
    }

    public AbstractObjekat getGrupa() {
        return grupa;
    }

    public AbstractObjekat getParam() {
        return param;
    }

    private void sacuvajPredavace() throws ServerskiException {
        Grupa gru = (Grupa) param; //dodali smo poslatu grupu u atribut gru
        List<AbstractObjekat> listaPredavaca = gru.getListaPredavaca(); //uzimamo iz nje listu predavaca
        
        for (AbstractObjekat abstractObjekat : listaPredavaca) {
            GrupaStavkaDodatiPredavaci  gsp= (GrupaStavkaDodatiPredavaci) abstractObjekat;
            dbb.sacuvajObjekat(gsp); 
        }
         
         
    }
    
     private void sacuvajUcesnike() throws ServerskiException {
        Grupa gru = (Grupa) param;
        List<AbstractObjekat> listaUcesnika = gru.getListaUcesnika();
        
        for (AbstractObjekat abstractObjekat : listaUcesnika) {
            GrupaStavkaDodatiUcesnici  gsu= (GrupaStavkaDodatiUcesnici) abstractObjekat;
            dbb.sacuvajObjekat(gsu); 
        }
        
         
    }
    
    

}
