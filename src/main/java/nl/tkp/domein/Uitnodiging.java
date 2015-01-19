package nl.tkp.domein;

import nl.tkp.domein.EmailService;
import nl.tkp.domein.Evenement;
import nl.tkp.domein.Genodigde;

import java.util.List;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Uitnodiging {
    private String beschrijving;
    private List<Genodigde> genodigden;

    Uitnodiging() {
    }

    Uitnodiging(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    Uitnodiging(String beschrijving, List<Genodigde> genodigden) {
        this.beschrijving = beschrijving;
        this.genodigden = genodigden;
    }
    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public List<Genodigde> getGenodigden() {
        return genodigden;
    }

    public void setGenodigden(List<Genodigde> genodigden) {
        this.genodigden = genodigden;
    }

}