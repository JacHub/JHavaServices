package nl.tkp.domein;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Evenement {
    private    String naam;
    private Uitnodiging uitnodiging;
    private MailService emailService;

    Evenement(){}
    Evenement(String naam,Uitnodiging uitnodiging){
        this.naam = naam;
        this.uitnodiging = uitnodiging;
    }
    Evenement(String naam,Uitnodiging uitnodiging, MailService mailService){
        this.naam = naam;
        this.uitnodiging = uitnodiging;
        this.emailService = mailService;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Uitnodiging getUitnodiging() {
        return uitnodiging;
    }

    public void setUitnodiging(Uitnodiging uitnodiging) {
        this.uitnodiging = uitnodiging;
    }

    public void verstuurUitnodigingen() {
        for (Genodigde genodigde : uitnodiging.getGenodigden()) {
            emailService.verstuurEmail(this.naam, uitnodiging.getBeschrijving(), genodigde.getEmailadres());
        }
    }

}
