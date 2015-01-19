package nl.tkp.domein;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Genodigde {

    private String emailadres;

    Genodigde(){}

    Genodigde(String emailadres){
        this.emailadres = emailadres;

    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

}
