package nl.tkp.domein;

import nl.tkp.domein.EmailService;
import nl.tkp.domein.Evenement;
import nl.tkp.domein.Genodigde;

import java.util.List;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Uitnodiging {
    Evenement evenement;
    String beschrijving;
    List<Genodigde> genodigden;
    Uitnodiging(){}

    Uitnodiging(Evenement evenement,String beschrijving){
        this.evenement = evenement;
        this.beschrijving = beschrijving;
    }

    Uitnodiging(Evenement evenement,String beschrijving,List<Genodigde> genodigden){
        this.evenement = evenement;
        this.beschrijving = beschrijving;
        this.genodigden = genodigden;
    }
    public void verstuurUitnodigingen(){
        EmailService mailService = new EmailService();
        for (Genodigde genodigde : genodigden) {
            mailService.verstuurEmail(evenement.naam,beschrijving,genodigde.emailadres );
        }
    }
}
