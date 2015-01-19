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

    Uitnodiging(String beschrijving, List<Genodigde> genodigden) {
        this.beschrijving = beschrijving;
        this.genodigden = genodigden;
    }
    public String getBeschrijving() {
        return beschrijving;
    }

    public List<Genodigde> getGenodigden() {
        return genodigden;
    }

}