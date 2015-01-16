package nl.tkp.domein;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Evenement {
public    String naam;
public Uitnodiging uitnodiging;

    Evenement(){}
    Evenement(String naam,Uitnodiging uitnodiging){
        this.naam = naam;
        this.uitnodiging = uitnodiging;
    }

    public void verstuurUitnodigingen() {
        EmailService mailService = new EmailService();
        for (Genodigde genodigde : uitnodiging.genodigden) {
            mailService.verstuurEmail(this.naam, uitnodiging.beschrijving, genodigde.emailadres);
        }
    }

}
