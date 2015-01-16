package nl.tkp.domein;

import nl.tkp.domein.EmailService;
import nl.tkp.domein.Evenement;
import nl.tkp.domein.Genodigde;

import java.util.List;

/**
 * Created by Jacob on 14-1-2015.
 */
public class Uitnodiging {
    String beschrijving;
    List<Genodigde> genodigden;

    Uitnodiging() {
    }

    Uitnodiging(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    Uitnodiging(String beschrijving, List<Genodigde> genodigden) {
        this.beschrijving = beschrijving;
        this.genodigden = genodigden;
    }
}